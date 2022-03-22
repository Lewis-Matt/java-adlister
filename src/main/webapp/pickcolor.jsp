<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pick Color</title>
</head>
<body>
<form method="post">
    <label for="color">Enter a color: </label>
<%-- The color is attached to the "name" field--%>
    <input type="text" id="color" name="color" placeholder="Red">
    <button type="submit">Submit</button>
</form>
</body>
</html>
