package com.mycompany.smartquizapp.util;

import jakarta.servlet.ServletContext;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DatabaseUtil {

    private DatabaseUtil() {
    }

    public static Connection getConnection(ServletContext context) throws SQLException {
        String url = context.getInitParameter("dbUrl");
        String user = context.getInitParameter("dbUser");
        String password = context.getInitParameter("dbPassword");
        return DriverManager.getConnection(url, user, password);
    }
}
