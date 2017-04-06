<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="/css/edit.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<%@include file="head.jsp" %>
<%session.setAttribute("path", "/editingProfile.jsp");%>
<form action="EditingProfileServlet" method="post">
    <div class="main">
        <div class="child">
            <label class="label"><fmt:message key="firstName"/>:</label>
            <input type="text" class="block" name="firstName" value="${sessionScope.user.firstName}"
                   pattern="[A-Za-zА-Яа-яЁё-]{2,50}"/>
        </div>
        <div class="child">
            <label class="label"><fmt:message key="lastName"/>:</label>
            <input type="text" class="block" name="lastName" value="${sessionScope.user.lastName}"
                   pattern="[A-Za-zА-Яа-яЁё-]{2,50}"/>
        </div>
        <div class="child">
            <label class="label"><fmt:message key="email"/>:</label>
            <input type="text" class="block" name="email" value="${sessionScope.user.email}"
                   pattern="^([a-z0-9_-]+\.)*[a-z0-9_-]+@[a-z0-9_-]+(\.[a-z0-9_-]+)*\.[a-z]{2,6}$"/>
        </div>
        <div class="child">
            <label class="label"><fmt:message key="age"/>:</label>
            <input type="text" class="block" name="age" value="${sessionScope.user.age}"/>
        </div>
        <div class="child">
            <label class="label"><fmt:message key="telephone"/>:</label>
            <input type="text" class="block" name="telephone" value="${sessionScope.user.telephone}"/>
        </div>
        <div class="child">
            <label class="label"><fmt:message key="country"/>:</label>
            <input type="text" class="block" name="country" value="${sessionScope.user.country}"/>
        </div>
        <div class="child">
            <label class="label"><fmt:message key="city"/>:</label>
            <input type="text" class="block" name="city" value="${sessionScope.user.city}"/>
        </div>
            <label class="label"><fmt:message key="aboutSelf"/>:</label>
            <textarea class="blockSelf" name="aboutSelf" rows="6" cols="45" value="${sessionScope.user.aboutSelf}"></textarea>

    </div>
    <div class="forButton1">
        <INPUT class="button" type="submit" value="<fmt:message key="update"/>">
        <INPUT class="button" type="reset" value="<fmt:message key="clear"/>">
    </div>
</form>
</body>
</html>

</body>
</html>
