<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Sign up</title>
    <link href="/css/registration.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<%@include file="head.jsp"%>
<%session.setAttribute("path","/userRegistration.jsp");%>
    <c:if test="${sessionScope.containsKey('freeLogin')}">
            <span class="loginNotFree">
                <fmt:message key="loginNotFree"/>
            </span>
    </c:if>
<form action="UserRegistration" method="get">
    <div class="forForm">
        <div>
            <label class="labelReg"><fmt:message key="firstName"/>:</label>
            <input type="text" class="block1" name="firstName" required="required" pattern="[A-Za-zА-Яа-яЁё-]{2,50}"/>
        </div>
        <div>
            <label class="labelReg"><fmt:message key="lastName"/>:</label>
            <input type="text" class="block1" name="lastName" required="required" pattern="[A-Za-zА-Яа-яЁё-]{2,50}"/>
        </div>
        <div>
            <label class="labelReg"><fmt:message key="login"/>:</label>
            <input type="text" class="block1" name="login" value="" pattern="[A-Za-zА-Яа-яЁё-]{2,255}"/>
        </div>
        <div>
            <label class="labelReg"><fmt:message key="password"/>:</label>
            <input type="password" class="block1" name="password" value="" pattern="[A-Za-zА-Яа-яЁё-0-9-]{2,255}"/>
        </div>
        <div>
            <label class="labelReg"><fmt:message key="email"/>:</label>
            <input type="text" class="block1" name="email" required="required"/>
        </div>
        <div>
            <label class="labelReg"><fmt:message key="sex"/>:</label>
            <select class="selectText" name="genderType">
                <option value="Male"><fmt:message key="male"/></option>
                <option value="Female"><fmt:message key="female"/></option>
            </select>
        </div>
    </div>
    <div class="forButton1">
    <INPUT id="button1" type="submit" value="Register">
    <INPUT id="button2" type="reset" value="Clear">
    </div>
</form>
</body>
</html>
