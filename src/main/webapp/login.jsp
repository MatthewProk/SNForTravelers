<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>signUp</title>
    <link rel="stylesheet" href="/css/reg.css">
</head>
<body>
<%@ include file="/head.jsp" %>
<mytag:path path="/signUp.jsp"/>
<label class="reg"><fmt:message key="registration"/></label>
<c:if test="${sessionScope.containsKey('freeLogin')}">
            <span class="loginNotFree">
                <fmt:message key="loginNotFree"/>
            </span>
</c:if>