<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="com.mycompany.smartquizapp.model.User" %>
<%
    User user = (User) request.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard | SmartQuizApp</title>
    <style>
        body {
            margin: 0;
            font-family: "Segoe UI", sans-serif;
            background: #f8fafc;
            padding: 40px;
        }
        .panel {
            max-width: 720px;
            margin: 0 auto;
            background: #ffffff;
            border-radius: 16px;
            padding: 32px;
            box-shadow: 0 12px 28px rgba(15, 23, 42, 0.08);
        }
        a {
            color: #2563eb;
            text-decoration: none;
            font-weight: 600;
        }
    </style>
</head>
<body>
    <div class="panel">
        <h1>Welcome, <%= user.getFullName() %></h1>
        <p>You are logged in with <strong><%= user.getEmail() %></strong>.</p>
        <p>This page confirms the `/login` and `/signup` flow is working with your local MySQL-backed user table.</p>
        <a href="${pageContext.request.contextPath}/logout">Logout</a>
    </div>
</body>
</html>
