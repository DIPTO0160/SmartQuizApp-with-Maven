<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="com.mycompany.smartquizapp.model.User" %>
<%@ page import="com.mycompany.smartquizapp.model.QuizCategory" %>
<%
    User user = (User) request.getAttribute("user");
    QuizCategory[] categories = (QuizCategory[]) request.getAttribute("categories");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Choose Quiz | SmartQuizApp</title>
    <style>
        :root {
            --ink: #10233f;
            --sky: #e0f2fe;
            --mint: #d1fae5;
            --sand: #fef3c7;
            --card: rgba(255, 255, 255, 0.92);
        }
        body {
            margin: 0;
            font-family: "Segoe UI", sans-serif;
            background:
                radial-gradient(circle at top left, #bfdbfe, transparent 35%),
                radial-gradient(circle at bottom right, #a7f3d0, transparent 28%),
                linear-gradient(135deg, #eff6ff, #f8fafc 42%, #fefce8);
            min-height: 100vh;
            color: var(--ink);
        }
        .shell {
            max-width: 1120px;
            margin: 0 auto;
            padding: 40px 24px 56px;
        }
        .topbar {
            display: flex;
            justify-content: space-between;
            gap: 16px;
            align-items: center;
            margin-bottom: 28px;
        }
        .topbar a {
            color: #0f766e;
            text-decoration: none;
            font-weight: 700;
        }
        .hero {
            background: var(--card);
            border-radius: 28px;
            padding: 32px;
            box-shadow: 0 24px 50px rgba(15, 23, 42, 0.12);
            margin-bottom: 28px;
        }
        .hero h1 {
            margin: 0 0 12px;
            font-size: 38px;
        }
        .hero p {
            margin: 0;
            max-width: 760px;
            line-height: 1.6;
            color: #334155;
        }
        .grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(260px, 1fr));
            gap: 22px;
        }
        .card {
            background: var(--card);
            border-radius: 24px;
            padding: 26px;
            box-shadow: 0 18px 40px rgba(15, 23, 42, 0.10);
        }
        .card:nth-child(1) {
            background: linear-gradient(180deg, #ffffff, var(--sky));
        }
        .card:nth-child(2) {
            background: linear-gradient(180deg, #ffffff, var(--mint));
        }
        .card:nth-child(3) {
            background: linear-gradient(180deg, #ffffff, var(--sand));
        }
        .card h2 {
            margin: 0 0 12px;
            font-size: 24px;
        }
        .card p {
            min-height: 72px;
            color: #334155;
            line-height: 1.55;
        }
        .meta {
            font-size: 14px;
            font-weight: 700;
            letter-spacing: 0.08em;
            text-transform: uppercase;
            color: #1d4ed8;
            margin-bottom: 10px;
        }
        .action {
            display: inline-block;
            margin-top: 10px;
            padding: 12px 16px;
            border-radius: 14px;
            background: #10233f;
            color: #ffffff;
            text-decoration: none;
            font-weight: 700;
        }
    </style>
</head>
<body>
    <div class="shell">
        <div class="topbar">
            <div>Logged in as <strong><%= user.getFullName() %></strong></div>
            <a href="${pageContext.request.contextPath}/logout">Logout</a>
        </div>

        <section class="hero">
            <h1>Select Your Quiz Category</h1>
            <p>Each quiz contains 20 questions and a 20 minute timer. When time finishes, the quiz submits automatically, shows your score, and sends you back here so you can choose another category.</p>
        </section>

        <section class="grid">
            <% for (QuizCategory category : categories) { %>
                <article class="card">
                    <div class="meta">20 Questions • 20 Minutes</div>
                    <h2><%= category.getTitle() %></h2>
                    <p><%= category.getDescription() %></p>
                    <a class="action" href="${pageContext.request.contextPath}/quiz?category=<%= category.getSlug() %>">Start Quiz</a>
                </article>
            <% } %>
        </section>
    </div>
</body>
</html>
