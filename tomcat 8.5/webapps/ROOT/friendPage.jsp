<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/css/mypage.css">
</head>
<body>
<%@include file="head.jsp" %>
<%session.setAttribute("path", "/friendPage.jsp");%>
<div class="first">
    <img src="${sessionScope.friend.avatar}">
</div>
<div class="third">
    <form method="post" action="MessageServlet">
        <input type="hidden" name="receiverLogin" value="${sessionScope.friend.login}">
        <button class="button1" type="submit"><fmt:message key="messages"/></button>
    </form>
</div>
<div class="second">
    <div class="secondChild">
        <div class="label"><fmt:message key="firstName"/>:</div>
        <div class="block">${sessionScope.friend.firstName}</div>
    </div>
    <div class="secondChild">
        <div class="label"><fmt:message key="lastName"/>:</div>
        <div class="block">${sessionScope.friend.lastName}</div>
    </div>
    <div class="secondChild">
        <div class="label"><fmt:message key="age"/>:</div>
        <div class="block">${sessionScope.friend.age}</div>
    </div>
    <div class="secondChild">
        <div class="label"><fmt:message key="email"/>:</div>
        <div class="block">${sessionScope.friend.email}</div>
    </div>
    <div class="secondChild">
        <div class="label"><fmt:message key="telephone"/>:</div>
        <div class="block">${sessionScope.friend.telephone}</div>
    </div>
    <div class="secondChild">
        <div class="label"><fmt:message key="country"/>:</div>
        <div class="block">${sessionScope.friend.country}</div>
    </div>
    <div class="secondChild">
        <div class="label"><fmt:message key="city"/>:</div>
        <div class="block">${sessionScope.friend.city}</div>
    </div>
    <div class="label"><fmt:message key="aboutSelf"/>:</div>
    <div class="blockSelf">${sessionScope.friend.aboutSelf}</div>
</div>

</body>
</html>
