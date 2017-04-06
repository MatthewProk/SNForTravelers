<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<%@ include file="/myMessages.jsp" %>
<%session.setAttribute("path", "/messagePage.jsp");%>
<table class="table">
    <tr>
        <th><fmt:message key="from"/></th>
        <th><fmt:message key="to"/></th>
        <th><fmt:message key="textMessage"/></th>
        <th><fmt:message key="sendingTime"/></th>
    </tr>
    <c:forEach var="message" items="${messagesList}">
        <tr>
            <td> ${message.sender.firstName} ${message.sender.lastName}</td>
            <td> ${message.receiver.firstName} ${message.receiver.lastName}</td>
            <td>${message.textMessage}</td>
            <td>${message.sendingTime}</td>
            <td>
                <form method="post" action="DeleteMessageServlet">
                    <input type="hidden" name="textMessage" value="${message.textMessage}">
                    <input class="" type="submit" value="<fmt:message key="delete"/>">
                </form>
            </td>
            <td>
                <form method="post" action="MessageServlet">
                    <input type="hidden" name="receiverLogin" value="${message.sender.login}">
                    <input class="" type="submit" value="<fmt:message key="reply"/>">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
