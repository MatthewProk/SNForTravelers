<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title><fmt:message key="personalPage"/></title>
    <%--<link rel="stylesheet" href="/css/mypage.css">--%>
</head>
<body>
<%@include file="head.jsp" %>
<div class="forImg">
    <img src="${sessionScope.user.avatar}">
</div>
<form class="forForm1">
    <div class="block2"><fmt:message key="firstName"/></div>
    <div class="block1">${sessionScope.user.firstName}</div>
    <div class="block2"><fmt:message key="lastName"/></div>
    <div class="block1">${sessionScope.user.lastName}</div>
    <div>
        <div class="block2"><fmt:message key="dob"/></div>
        <div class="block1">${sessionScope.user.dateOfBirth}</div>
    </div>
    <div>
        <div class="block2"><fmt:message key="age"/></div>
        <div class="block1">${sessionScope.user.age}</div>
    </div>
    <div>
        <div class="block2"><fmt:message key="email"/></div>
        <div class="block1">${sessionScope.user.email}</div>
    </div>
    <div>
        <div class="block2"><fmt:message key="telephone"/></div>
        <div class="block1">${sessionScope.user.telephone}</div>
    </div>
    <div>
        <div class="block2"><fmt:message key="country"/></div>
        <div class="block1"></div>
    </div>
    <div>
        <div class="block2"><fmt:message key="city"/></div>
        <div class="block1"></div>
    </div>
    <div>
        <div class="block2"><fmt:message key="street"/></div>
        <div class="block1"></div>
    </div>
    <div>
        <div class="block2"><fmt:message key="house"/></div>
        <div class="block1"></div>
    </div>
    <div>
        <div class="block2"><fmt:message key="flat"/></div>
        <div class="block1"></div>
    </div>
</form>
<div>
    <div class="block2"><fmt:message key="aboutSelf"/></div>
    <div class="aboutSelf">${sessionScope.user.aboutSelf}</div>
</div>
<table class="table table-condensed">
    <caption>All users in Social Network</caption>
    <thead>
    <tr>
        <th>User Login</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="userFromList" items="${usersList}">
        <tr>
            <td>${userFromList.login}</td>
            <td>${userFromList.firstName}</td>
            <td>${userFromList.lastName}</td>
            <td>${userFromList.email}</td>
            <td>
                <form method="post" action="MessageServlet">
                    <input type="hidden" name="receiverLogin" value="${userFromList.login}">
                    <input type="submit" value="Message">
                </form>
            </td>
            <td>
                <c:set var="contains" value="false"/>
                <c:if test="${friendsList.contains(userFromList)}">
                    <c:set var="contains" value="true"/>
                </c:if>

                <c:choose>
                    <c:when test="${contains eq false}">
                        <form method="post" action="FriendShipServlet">
                            <input type="hidden" name="login" value="${userFromList.login}">
                            <input style="width:100px;height:35px" class="btn btn-success" type="submit"
                                   value="Follow">
                        </form>
                    </c:when>
                    <c:otherwise>
                        <form method="post" action="UnfollowServlet">
                            <input type="hidden" name="login" value="${userFromList.login}">
                            <input style="width:100px;height:35px" class="btn btn-warning" type="submit"
                                   value="Unfollow">
                        </form>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<select name="friend">
<c:forEach items="${sessionScope.friendsList}" var="usersList">
    <option value="">${usersList.login}</option>
</c:forEach>
</select>

</body>
</html>
