<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login | SmartQuizApp</title>
    <style>
        body {
            margin: 0;
            font-family: "Segoe UI", sans-serif;
            background: linear-gradient(135deg, #f8fafc, #dbeafe);
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .card {
            width: 360px;
            background: #ffffff;
            padding: 32px;
            border-radius: 16px;
            box-shadow: 0 18px 40px rgba(15, 23, 42, 0.12);
        }
        h1 {
            margin-top: 0;
            color: #0f172a;
        }
        .message {
            padding: 10px 12px;
            border-radius: 10px;
            margin-bottom: 16px;
            font-size: 14px;
        }
        .error {
            background: #fee2e2;
            color: #991b1b;
        }
        .success {
            background: #dcfce7;
            color: #166534;
        }
        label {
            display: block;
            margin: 12px 0 6px;
            color: #334155;
        }
        input {
            width: 100%;
            padding: 12px;
            border: 1px solid #cbd5e1;
            border-radius: 10px;
            box-sizing: border-box;
        }
        button, .link-button {
            width: 100%;
            margin-top: 16px;
            padding: 12px;
            border: none;
            border-radius: 10px;
            cursor: pointer;
            font-size: 15px;
            text-decoration: none;
            display: inline-block;
            text-align: center;
            box-sizing: border-box;
        }
        button {
            background: #2563eb;
            color: #ffffff;
        }
        .link-button {
            background: #e2e8f0;
            color: #0f172a;
        }
    </style>
</head>
<body>
    <div class="card">
        <h1>Login</h1>

        <% if (request.getAttribute("errorMessage") != null) { %>
            <div class="message error"><%= request.getAttribute("errorMessage") %></div>
        <% } %>

        <% if ("success".equals(request.getParameter("signup"))) { %>
            <div class="message success">Signup complete. You can login now.</div>
        <% } %>

        <form method="post" action="${pageContext.request.contextPath}/login">
            <label for="email">Email</label>
            <input id="email" name="email" type="email" required>

            <label for="password">Password</label>
            <input id="password" name="password" type="password" required>

            <button type="submit">Login</button>
        </form>

        <a class="link-button" href="${pageContext.request.contextPath}/signup">Sign Up</a>
    </div>
</body>
</html>
