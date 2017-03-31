<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<head>
    <title>Sign up</title>
    <%--<link href="/css/registration.css" rel="stylesheet" type="text/css"/>--%>
</head>
<body>
<%@ include file="/head.jsp" %>
<label class="reg"><fmt:message key="signIn"/></label>
<form class="forForm" action="Login" method="post">
    <div class="block1">
        <label for="form-login"><fmt:message key="login"/>: </label>
        <input id="form-login" type="text" name="login">
    </div>
    <div class="block1">
        <label for="form-password"><fmt:message key="password"/>: </label>
        <input id="form-password" type="password" name="password">
    </div>
    <c:if test="${sessionScope.containsKey('isIncorrect')}">
        <div class="block1">
            <span><fmt:message key="Incorrect_login_or_password"/></span>
        </div>
    </c:if>
    <div class="forButton1">
        <input type="submit" value="<fmt:message key="Submit"/>">
    </div>
</form>
</body>
</html>