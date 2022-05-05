<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 05/05/2022
  Time: 10:26 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="mail" method="post" action="/edit">
    <div>
        Languages
        <form:select path="languages">
            <form:option value="english" label="english"/>
            <form:option value="vietnamese" label="vietnamese"/>
            <form:option value="korea" label="korea"/>
        </form:select>
    </div>

    <div>
        Page Size:
        <form:select path="pageSize">
            <form:option value="5" label="5"/>
            <form:option value="10" label="10"/>
            <form:option value="15" label="15"/>
            <form:option value="25" label="25"/>
            <form:option value="50" label="50"/>
            <form:option value="100" label="100"/>
        </form:select>
        emails per page

    </div>

    <div>
        Spams filter:
        <form:checkbox path="spamsFillter" value="spamsFillter"/>
        Enable spams filter
    </div>

    <div>
        Signature:
        <form:input path="signature" cssStyle="width:200px; height: 100px; "/>
    </div>
    <div>
        <input type="submit">
        <button type="reset"> cancel</button>
    </div>
</form:form>
${mail1.languages}
<br>
${mail1.pageSize}
<br>
${mail1.spamsFillter}
<br>
${mail1.signature}
</body>
</html>
