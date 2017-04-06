<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<head>
    <link href="/css/login.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<%@ include file="/head.jsp" %>
<%@include file="informationForStartPage.jsp" %>
<%session.setAttribute("path", "/login.jsp");%>
<form action="Login" method="post">
    <div class="main">
        <div class="child">
            <label class="label"><fmt:message key="login"/>:  </label>
            <input class="block" type="text" name="login">
        </div>
        <div class="child">
            <label class="label"><fmt:message key="password"/>:  </label>
            <input class="block" type="password" name="password">
        </div>
        <div class="child">
            <button class="button1" type="submit"><fmt:message key="Submit"/></button>
            <button class="button2" type="reset"><fmt:message key="clear"/></button>
        </div>
    </div>
    <c:if test="${sessionScope.containsKey('isIncorrect')}">
        <div class="incorrect">
            <span><fmt:message key="Incorrect_login_or_password"/></span>
        </div>
    </c:if>
</form>
</body>
</html>