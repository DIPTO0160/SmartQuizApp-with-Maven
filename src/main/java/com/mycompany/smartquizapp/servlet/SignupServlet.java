package com.mycompany.smartquizapp.servlet;

import com.mycompany.smartquizapp.dao.UserDao;
import com.mycompany.smartquizapp.model.User;
import com.mycompany.smartquizapp.util.DatabaseUtil;
import com.mycompany.smartquizapp.util.PasswordUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {

    private final UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (isBlank(fullName) || isBlank(email) || isBlank(password)) {
            request.setAttribute("errorMessage", "All fields are required.");
            request.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(request, response);
            return;
        }

        try (Connection connection = DatabaseUtil.getConnection(getServletContext())) {
            if (userDao.emailExists(connection, email.trim())) {
                request.setAttribute("errorMessage", "An account with this email already exists.");
                request.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(request, response);
                return;
            }

            User user = new User();
            user.setFullName(fullName.trim());
            user.setEmail(email.trim());
            user.setPasswordHash(PasswordUtil.hash(password));
            userDao.create(connection, user);

            response.sendRedirect(request.getContextPath() + "/login?signup=success");
        } catch (SQLException ex) {
            throw new ServletException("Unable to register user", ex);
        }
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}
