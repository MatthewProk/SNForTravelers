<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<%@include file="head.jsp" %>
<%session.setAttribute("path", "/messageIsSent.jsp");%>
<div><fmt:message key="messageIsSent"/></div>
<form action="myMessages.jsp">
    <button class="" type="submit"><fmt:message key="returnToMessage"/></button>
</form>
</body>
</html>
