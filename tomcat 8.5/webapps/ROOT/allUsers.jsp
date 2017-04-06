<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<%@include file="head.jsp" %>
<%session.setAttribute("path", "/allUsers.jsp");%>
<div class="searchFriends">
    <form action="SearchUsersServlet" method="post">
        <input type="text" class="textSearch" name="firstName" value="" pattern="[A-Za-zА-Яа-яЁё]{1,50}"/>
        <input type="text" class="textSearch" name="lastName" value="" pattern="[A-Za-zА-Яа-яЁё]{1,50}"/>
        <select class="selectSearch" name="gender">
            <option value="Unknown" selected></option>
            <option value="Male"><fmt:message key="male"/></option>
            <option value="Female"><fmt:message key="female"/></option>
        </select>
        <button class="btnSearch" name="searchFriends" type="submit"><fmt:message key="find"/></button>
    </form>
</div>
<caption>All users in Social Network</caption>
<table class="table table-condensed">
    <thead>
    <tr>
        <th><fmt:message key="login"/></th>
        <th><fmt:message key="firstName"/></th>
        <th><fmt:message key="lastName"/></th>
        <th><fmt:message key="email"/></th>
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
                <c:if test="${sessionScope.friendsList.contains(userFromList)}">
                    <c:set var="contains" value="true"/>
                </c:if>

                <c:choose>
                    <c:when test="${contains eq contains}">
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
</body>
</html>
