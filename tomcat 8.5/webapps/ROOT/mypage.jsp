<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" href="/css/mypage.css">
</head>
<body>
<%@include file="head.jsp" %>
<%session.setAttribute("path", "/mypage.jsp");%>
<div class="first">
    <img src="${sessionScope.user.avatar}">
</div>
<div class="third">
    <form method="post" action="FriendPageServlet">
        <select class="selectText" name="friendLogin">
            <c:forEach items="${sessionScope.friendsList}" var="usersList">
                <option class="optional" value="${usersList.login}">${usersList.login}</option>
            </c:forEach>
        </select>
        <button class="button1" type="submit"><fmt:message key="GoToPage"/></button>
    </form>
</div>
<div class="second">
    <div class="secondChild">
        <div class="label"><fmt:message key="firstName"/>:</div>
        <div class="block">${sessionScope.user.firstName}</div>
    </div>
    <div class="secondChild">
        <div class="label"><fmt:message key="lastName"/>:</div>
        <div class="block">${sessionScope.user.lastName}</div>
    </div>
    <div class="secondChild">
        <div class="label"><fmt:message key="age"/>:</div>
        <div class="block">${sessionScope.user.age}</div>
    </div>
    <div class="secondChild">
        <div class="label"><fmt:message key="email"/>:</div>
        <div class="block">${sessionScope.user.email}</div>
    </div>
    <div class="secondChild">
        <div class="label"><fmt:message key="telephone"/>:</div>
        <div class="block">${sessionScope.user.telephone}</div>
    </div>
    <div class="secondChild">
        <div class="label"><fmt:message key="country"/>:</div>
        <div class="block">${sessionScope.user.country}</div>
    </div>
    <div class="secondChild">
        <div class="label"><fmt:message key="city"/>:</div>
        <div class="block">${sessionScope.user.city}</div>
    </div>
    <div class="label"><fmt:message key="aboutSelf"/>:</div>
    <div class="blockSelf">${sessionScope.user.aboutSelf}</div>
</div>
</body>
</html>
