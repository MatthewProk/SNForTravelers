<%@ include file="/content/init/initLang.jsp"%>
<link rel="stylesheet" href="/css/head.css">
<div class="wrapper">
<%session.setAttribute("path","/head.jsp");%>
    <c:choose>
        <c:when test="${sessionScope.containsKey('user')}">
            <form action="/editingProfile.jsp">
                <button class="button" type="submit"><fmt:message key="editProfile"/></button>
            </form>
            <form action="/myMessages.jsp">
                <button class="button" type="submit"><fmt:message key="myMessages"/></button>
            </form>
            <form action="/mypage.jsp">
                <button class="button"  type="submit"><fmt:message key="mypage"/></button>
            </form>
            <form action="/SignOut">
                <button class="button"  type="submit" formmethod="post"><fmt:message key="exit"/></button>
            </form>
            <form method="post" action="AllUsersServlet">
                <button class="button" type="submit" formmethod="post"><fmt:message key="allUsers"/></button>
            </form>
        </c:when>
        <c:otherwise>
            <form action="/login.jsp">
                <button class="button" name="btn" value="signIn" type="submit" formmethod="post"><fmt:message key="signIn"/></button>
            </form>
            <form action="/userRegistration.jsp">
                <button class="button" name="btn" value="signIn" type="submit" formmethod="post"><fmt:message key="registration"/></button>
            </form>
        </c:otherwise>
    </c:choose>
    <form action="InitLangServlet">
        <button class="button" name="locale" value="en_EN" type="submit" formmethod="post">EN</button>
        <button class="button" name="locale" value="ru_RU" type="submit" formmethod="post">RU</button>
    </form>
</div>