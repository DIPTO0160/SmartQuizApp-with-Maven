package com.mycompany.smartquizapp.servlet;

import com.mycompany.smartquizapp.model.QuizCategory;
import com.mycompany.smartquizapp.model.QuizQuestion;
import com.mycompany.smartquizapp.model.User;
import com.mycompany.smartquizapp.service.QuizRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/submit-quiz")
public class QuizResultServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        User user = session == null ? null : (User) session.getAttribute("loggedInUser");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        QuizCategory category = QuizCategory.fromSlug(request.getParameter("category"));
        if (category == null) {
            response.sendRedirect(request.getContextPath() + "/dashboard");
            return;
        }

        List<QuizQuestion> questions = QuizRepository.getQuestions(category);
        int score = 0;
        for (QuizQuestion question : questions) {
            String selectedAnswer = request.getParameter("question_" + question.getId());
            if (question.getCorrectAnswer().equals(selectedAnswer)) {
                score++;
            }
        }

        long startedAt = 0L;
        Object startedAtValue = session.getAttribute(QuizServlet.getStartTimeKey(category));
        if (startedAtValue instanceof Long) {
            startedAt = (Long) startedAtValue;
        }
        long submittedAt = System.currentTimeMillis();
        boolean timeExpired = startedAt > 0L && submittedAt - startedAt >= QuizServlet.QUIZ_DURATION_MILLIS;

        session.removeAttribute(QuizServlet.getStartTimeKey(category));
        request.setAttribute("user", user);
        request.setAttribute("category", category);
        request.setAttribute("score", score);
        request.setAttribute("totalQuestions", questions.size());
        request.setAttribute("timeExpired", timeExpired);
        request.getRequestDispatcher("/WEB-INF/views/quiz-result.jsp").forward(request, response);
    }
}
