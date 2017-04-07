<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="/css/allUsers.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<%@include file="buttonForUsers.jsp" %>
<%session.setAttribute("path", "/allFriends.jsp");%>
<div class="main">
    <label class="allUsersText"><fmt:message key="allFriends"/></label>
    <div class="searchBlock">
        <form action="SearchFriendsServlet" method="post">
            <input type="text" class="chooseBlock" name="firstName" placeholder="<fmt:message key="firstName"/>"
                   pattern="[A-Za-zА-Яа-яЁё]{1,50}"/>
            <input type="text" class="chooseBlock" name="lastName" placeholder="<fmt:message key="lastName"/>"
                   pattern="[A-Za-zА-Яа-яЁё]{1,50}"/>
            <select class="chooseBlock" name="gender">
                <option value="Unknown" selected></option>
                <option value="Male"><fmt:message key="male"/></option>
                <option value="Female"><fmt:message key="female"/></option>
            </select>
            <button class="buttonFind" name="searchFriends" type="submit"><fmt:message key="find"/></button>
        </form>
    </div>
    <table class="table">
        <thead>
        <tr class="td">
            <th><fmt:message key="login"/></th>
            <th><fmt:message key="firstName"/></th>
            <th><fmt:message key="lastName"/></th>
            <th><fmt:message key="email"/></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="userFromList" items="${friendsList}">
            <tr class="td">
                <td>${userFromList.login}</td>
                <td>${userFromList.firstName}</td>
                <td>${userFromList.lastName}</td>
                <td>${userFromList.email}</td>
                <td>
                    <form method="post" action="MessageServlet">
                        <input type="hidden" name="receiverLogin" value="${userFromList.login}">
                        <input class="tableButton" type="submit" value="<fmt:message key="sendMessage"/>">
                    </form>
                </td>
                <td>
                            <form method="post" action="UnfollowServlet">
                                <input type="hidden" name="login" value="${userFromList.login}">
                                <input class="tableButton" type="submit" value="<fmt:message key="deleteFromFriends"/>">
                            </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
