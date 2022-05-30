<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/spice">
    <label>
        <input type="checkbox" value="Lettuce" name="condiment">
        Lettuce
    </label>
    <label>
        <input type="checkbox" value="Tomato" name="condiment">
        Tomato
    </label>
    <label>
        <input type="checkbox" value="Mustard" name="condiment">
        Mustard
    </label>
    <label>
        <input type="checkbox" value="Sprouts" name="condiment" >
        Sprouts
    </label>
    <input type="submit" value="save">
</form>

</body>
</html>
