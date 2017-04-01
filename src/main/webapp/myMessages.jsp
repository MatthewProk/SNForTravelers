<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="/head.jsp" %>
<form class="" action="/SentMessagesServlet" method="post">
    <button class="" type="submit"><fmt:message key="sentMessages"/></button>
</form>
<form class="" action="/ReceivedMessagesServlet" method="post">
    <button class="" type="submit"><fmt:message key="receivedMessages"/></button>
</form>
</div>
</body>
</html>
