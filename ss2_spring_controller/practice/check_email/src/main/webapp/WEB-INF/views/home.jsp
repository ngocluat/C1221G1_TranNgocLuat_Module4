<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 03/05/2022
  Time: 10:08 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/validate" method="post">
    <label>
        mail :
        <input type="text"  name="email">
        <h3 style="color:red">${message}</h3>
        <h3 style="color:aqua">${email}</h3>
    </label>
    <button type="submit"> check </button>
</form>

</body>
</html>
