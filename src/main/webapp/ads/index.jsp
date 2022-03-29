<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ads</title>
</head>
<body>
<h1>List of all ads</h1>
<%--Loop through the ads defined in the controller (ShowAdsServlet)--%>
<c:forEach var="ad" items="${ads}">
    <div>
        <h2>${ads.title}</h2>
        <p>${ads.description}</p></div>
</c:forEach>

</body>
</html>
