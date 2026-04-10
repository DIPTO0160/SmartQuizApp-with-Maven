<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="com.mycompany.smartquizapp.model.QuizCategory" %>
<%
    QuizCategory category = (QuizCategory) request.getAttribute("category");
    int score = (Integer) request.getAttribute("score");
    int totalQuestions = (Integer) request.getAttribute("totalQuestions");
    boolean timeExpired = (Boolean) request.getAttribute("timeExpired");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="refresh" content="6;url=${pageContext.request.contextPath}/dashboard">
    <title>Quiz Result | SmartQuizApp</title>
    <style>
        body {
            margin: 0;
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            font-family: "Segoe UI", sans-serif;
            background: radial-gradient(circle at top, #dbeafe, #f8fafc 55%, #dcfce7);
        }
        .panel {
            width: min(520px, 92vw);
            background: rgba(255, 255, 255, 0.94);
            border-radius: 26px;
            padding: 34px;
            box-shadow: 0 24px 50px rgba(15, 23, 42, 0.14);
            text-align: center;
        }
        .score {
            font-size: 56px;
            font-weight: 800;
            color: #1d4ed8;
            margin: 10px 0;
        }
        a {
            display: inline-block;
            margin-top: 18px;
            text-decoration: none;
            background: #10233f;
            color: #ffffff;
            padding: 12px 18px;
            border-radius: 14px;
            font-weight: 700;
        }
    </style>
</head>
<body>
    <div class="panel">
        <h1><%= category.getTitle() %> Result</h1>
        <p><%= timeExpired ? "Time expired, so your quiz was submitted automatically." : "Your quiz was submitted successfully." %></p>
        <div class="score"><%= score %> / <%= totalQuestions %></div>
        <p>You will return to the category selection page automatically in 6 seconds.</p>
        <a href="${pageContext.request.contextPath}/dashboard">Choose Another Category</a>
    </div>
</body>
</html>
