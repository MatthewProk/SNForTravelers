<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="/css/registration.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<%@include file="head.jsp" %>
<%session.setAttribute("path", "/editingProfile.jsp");%>
<form action="EditingProfileServlet" method="post">
    <div class="forForm">
        <div>
            <label class="labelReg"><fmt:message key="firstName"/>:</label>
            <input type="text" class="block1" name="firstName" pattern="[A-Za-zА-Яа-яЁё-]{2,50}"/>
        </div>
        <div>
            <label class="labelReg"><fmt:message key="lastName"/>:</label>
            <input type="text" class="block1" name="lastName" pattern="[A-Za-zА-Яа-яЁё-]{2,50}"/>
        </div>
        <div>
            <label class="labelReg"><fmt:message key="email"/>:</label>
            <p><input type="text" class="block1" name="email"/></p>
        </div>
        <div>
            <label class="labelReg"><fmt:message key="age"/>:</label>
            <p><input type="text" class="block1" name="age"/></p>
        </div>
        <div>
            <label class="labelReg"><fmt:message key="telephone"/>:</label>
            <p><input type="text" class="block1" name="telephone"/></p>
        </div>
        <div>
            <label class="labelReg"><fmt:message key="country"/>:</label>
            <p><input type="text" class="block1" name="country" required="required"/></p>
        </div>
        <div>
            <label class="labelReg"><fmt:message key="city"/>:</label>
            <p><input type="text" class="block1" name="city" required="required"/></p>
        </div>
        <div>
            <label class="labelReg"><fmt:message key="aboutSelf"/>:</label>
            <p><input type="text" class="block1" name="aboutSelf" required="required"/></p>
        </div>
    </div>
    <div class="forButton1">
        <INPUT id="button1" type="submit" value="Register">
        <INPUT id="button2" type="reset" value="Clear">
    </div>
</form>
</body>
</html>

</body>
</html>
