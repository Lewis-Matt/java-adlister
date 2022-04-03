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
<%--This displays the pointer to the user object on the heap, rather than the username. Should I set a variable in the controller to username?--%>
        <h1>Welcome, ${sessionScope.user}!</h1>
    </div>

</body>
</html>
