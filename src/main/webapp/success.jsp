
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Successful registration</title>
    <link rel="stylesheet" href="E://EPAMCourse/SocialNetwork/src/main/webapp/css/css.css">
</head>
<%@include file="head.jsp"%>
<body>
<form class="block1" action="Success" method="get">
    <h3><fmt:message key="successfully"/></h3>
    <button type="submit" value="<fmt:message key="returnToLoginPage"/>"></button>
</form>
</body>
</html>
