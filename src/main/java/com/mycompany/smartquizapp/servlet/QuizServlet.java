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

@WebServlet("/quiz")
public class QuizServlet extends HttpServlet {

    public static final long QUIZ_DURATION_MILLIS = 20L * 60L * 1000L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = getLoggedInUser(request);
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
        long startedAt = System.currentTimeMillis();
        request.getSession(true).setAttribute(getStartTimeKey(category), startedAt);
        request.setAttribute("user", user);
        request.setAttribute("category", category);
        request.setAttribute("questions", questions);
        request.setAttribute("durationSeconds", QUIZ_DURATION_MILLIS / 1000L);
        request.getRequestDispatcher(category.getViewPath()).forward(request, response);
    }

    static String getStartTimeKey(QuizCategory category) {
        return "quizStart_" + category.getSlug();
    }

    private User getLoggedInUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return session == null ? null : (User) session.getAttribute("loggedInUser");
    }
}
