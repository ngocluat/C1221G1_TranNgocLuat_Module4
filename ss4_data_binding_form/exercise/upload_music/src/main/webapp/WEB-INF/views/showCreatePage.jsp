<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="createMusic" action="create" method="post">

    Tên bài hát:
    <form:input path="nameMusic"/>
    <br>
    Nghệ sĩ thể hiện
    <form:input path="artist"/>
    <br>
    Thể loại nhạc (nhập thông tin dạng list)
    <form:input path="category"/>
    <br>
    Đường dẫn file bài hát
    <form:input path="pathFileMusic"/>
    <br>
    <button type="submit"> LƯU</button>
</form:form>
</body>
</html>
