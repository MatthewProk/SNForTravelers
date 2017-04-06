<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/css/myMessages.css">
</head>
<body>
<%@ include file="/head.jsp" %>
<%session.setAttribute("path", "/myMessages.jsp");%>
<div class="forForm">
    <form action="/SentMessagesServlet" method="post">
        <button class="button" id="button1" type="submit"><fmt:message key="sentMessages"/></button>
    </form>
    <form action="/ReceivedMessagesServlet" method="post">
        <button class="button" type="submit"><fmt:message key="receivedMessages"/></button>
    </form>
</div>
</body>
</html>
