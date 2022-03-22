<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Color</title>
</head>
<%--Referencing the color variable set in ViewColorServlet--%>
<body style="background-color: ${color}">
<h1>Your color was: ${color}</h1>
</body>
</html>
