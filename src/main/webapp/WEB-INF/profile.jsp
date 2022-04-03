<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
<%--This displays the pointer to the user object on the heap, rather than the username--%>
<%--Edit: the fix was to just add .username--%>
        <h1>Welcome, ${sessionScope.user.username}!</h1>
    </div>

</body>
</html>
