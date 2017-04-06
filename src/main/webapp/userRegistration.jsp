<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Sign up</title>
    <link href="/css/registration.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<%@include file="head.jsp" %>
<%@include file="informationForStartPage.jsp" %>
<%session.setAttribute("path", "/userRegistration.jsp");%>
<c:if test="${sessionScope.containsKey('freeLogin')}">
            <span class="loginNotFree">
                <fmt:message key="loginNotFree"/>
            </span>
</c:if>
<form action="UserRegistration" method="get">
    <div class="main">
        <div class="child">
            <label class="label"><fmt:message key="firstName"/>:</label>
            <input type="text" class="block" name="firstName" required="required" pattern="[A-Za-zА-Яа-яЁё-]{2,50}"/>
        </div>
        <div class="child">
            <label class="label"><fmt:message key="lastName"/>:</label>
            <input type="text" class="block" name="lastName" required="required" pattern="[A-Za-zА-Яа-яЁё-]{2,50}"/>
        </div>
        <div class="child">
            <label class="label"><fmt:message key="login"/>:</label>
            <input type="text" class="block" name="login" required="required" pattern="[A-Za-zА-Яа-яЁё-]{2,255}"/>
        </div>
        <div class="child">
            <label class="label"><fmt:message key="password"/>:</label>
            <input type="password" class="block" name="password" required="required"
                   pattern="[A-Za-zА-Яа-яЁё-0-9-]{2,255}"/>
        </div>
        <div class="child">
            <label class="label"><fmt:message key="email"/>:</label>
            <input type="text" class="block" name="email" required="required"
                      pattern="^([a-z0-9_-]+\.)*[a-z0-9_-]+@[a-z0-9_-]+(\.[a-z0-9_-]+)*\.[a-z]{2,6}$"/>
        </div>
        <div class="child">
            <label class="label"><fmt:message key="sex"/>:</label>
            <select class="block" name="genderType">
                <option value="Male"><fmt:message key="male"/></option>
                <option value="Female"><fmt:message key="female"/></option>
            </select>
        </div>
        <div class="child">
            <button class="button1" type="submit"><fmt:message key="registration"/></button>
            <button class="button2" type="reset"><fmt:message key="clear"/></button>
        </div>
    </div>

</form>
</body>
</html>
