<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<%@ include file="/myMessages.jsp" %>
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
</body>
</html>
