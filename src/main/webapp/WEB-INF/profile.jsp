<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Your Profile"/>
    </jsp:include>
</head>
<body>
<jsp:include page="../partials/navbar.jsp"/>

<div class="container">
    <h1>Viewing your profile.</h1>
    <%--sessionScope: Fetches attributes from session scope, set by session object--%>
    <%--https://www.javatpoint.com/EL-expression-in-jsp--%>
    <p> Welcome, ${sessionScope.user}! </p>
</div>

</body>
</html>
