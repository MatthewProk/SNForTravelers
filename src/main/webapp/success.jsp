<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="/css/success.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<%@include file="head.jsp" %>
<%session.setAttribute("path", "/success.jsp");%>
<form action="Success" method="post">
    <div class="forWords"><h3><fmt:message key="successfully"/></h3></div>
    <button id="button1" type="submit" value="><fmt:message key="returnToLoginPage"/></button>
</form>
</body>
</html>
