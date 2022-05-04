<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 04/05/2022
  Time: 11:29 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/calculationResults" method="post">
    <label>
        number 1
        <input type="number" name="number1">
    </label>
    <label>
        number 2
        <input type="number" name="number2">
    </label>
    <br>
    <button type="submit" name="pheptinh" value="cong">cộng</button>
    <button type="submit" name="pheptinh" value="tru">trừ</button>
    <button type="submit" name="pheptinh" value="nhan">nhân</button>
    <button type="submit" name="pheptinh" value="chia">chia</button>
    <h1>kết quả ${answer}</h1>

</form>
</body>
</html>
