<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/css/myMessages.css">
</head>
<body>
<%@include file="head.jsp" %>
<div class="forForm">
    <form action="AllUsersServlet" method="post">
        <button class="buttonFR" id="button1" type="submit"><fmt:message key="allUsers"/></button>
    </form>
    <form action="/allFriends.jsp">
        <button class="buttonFR" type="submit"><fmt:message key="allFriends"/></button>
    </form>
</div>
</body>
</html>
