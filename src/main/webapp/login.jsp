<%--
When a user visits /login.jsp, they should see a form for logging in
This form should have a 'username' and 'password' field.
This form should submit a POST request to /login.jsp
Inside of login.jsp write some code to check the submmitted values.
If the username submitted is "admin", and the password is "password", redirect the user to the profile page; otherwise, redirect back to the login form.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--JSTL--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
request (javax.servlet.http.HttpServletRequest): To get the values of attributes or parameters that are passed to a JSP page.
.setAttribute(name, o)
    String name : By providing the value of this argument you can specify the name of attribute.
    Object o : By providing the value of this argument you can specify the value of the named attribute. i.e. you can store the Object.
--%>
<%
    request.setAttribute("getUsername", request.getParameter("username"));
    request.setAttribute("getPassword", request.getParameter("password"));
%>
<c:choose>
    <c:when test="${getUsername.equals('admin') && getPassword.equals('password')}">
        <% response.sendRedirect("/profile.jsp"); %>
    </c:when>
</c:choose>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
<form method="post" action="">
    <label for="username">Username</label>
    <input id="username" name="username" placeholder="Enter username">
    <label for="password">Password</label>
    <input type="password" id="password" name="password" placeholder="Enter password">
    <button type="submit" id="submit">Login</button>
</form>
</body>
</html>
