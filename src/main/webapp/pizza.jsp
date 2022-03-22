<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pizza Order</title>
</head>
<body>
<div class="form">
    <form action="pizza.jsp" method="post">
        <label for="crust">Select a crust:</label>
        <%--The name attribute is needed to reference the form data after the form is submitted--%>
        <select id="crust" name="crust">
            <%--The value attribute indicates what is sent to the server on form submission.--%>
            <option value="chicago">Chicago Deep-Dish</option>
            <option value="thin">Thin Crust</option>
            <option value="stuffed">Stuffed Crust</option>
        </select>
        <label for="sauce">Select a sauce:</label>
        <select id="sauce" name="sauce">
            <option value="tomato">Tomato</option>
            <option value="alfredo">Alfredo</option>
            <option value="bbq">BBQ</option>
            <option value="pesto">Pesto</option>
        </select>
        <label for="size">Select a size:</label>
        <select id="size" name="size">
            <option value="small">Personal (8")</option>
            <option value="medium">Medium (12")</option>
            <option value="large">Large (16")</option>
        </select>
        <label>Select your toppings:</label>
        <input type="checkbox" id="pepperoni" name="pepperoni" value="pepperoni">
        <label for="pepperoni"> Pepperoni</label><br>
        <input type="checkbox" id="italian" name="italian" value="italian">
        <label for="italian"> Italian Sausage</label><br>
        <input type="checkbox" id="anchovy" name="anchovy" value="anchovy">
        <label for="anchovy"> Anchovies</label><br>
        <button type="submit">Submit Order</button>
    </form>
</div>
</body>
</html>
