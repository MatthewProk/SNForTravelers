<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<%@include file="head.jsp" %>
<%session.setAttribute("path", "/message.jsp");%>
<div><fmt:message key="conversaitionWith"/>  <b>${sessionScope.get("receiver").firstName} ${sessionScope.get("receiver").lastName}</b></div>
<table class="table">
<c:forEach var="message" items="${messagesList}">
    <tr>
        <td>${message.textMessage}</td>
        <td>${message.sendingTime}</td>
        <td><form method="post" action="DeleteMessageServlet">
        <input type="hidden" name="textMessage" value="${message.textMessage}">
            <input style="width:100px;height:35px" class="btn btn-success" type="submit"
                   value="Delete">
            </form>
        </td>
    </tr>
</c:forEach>

</table>

<form method="post" action="SendingMessageServlet">
    <textarea placeholder="Type message..." name="textMessage" rows="3" cols="45"></textarea>
    <br/>
    <input style="width:340px" class="btn btn-success" type="submit" value="Send">
</form>
</body>
</html>
