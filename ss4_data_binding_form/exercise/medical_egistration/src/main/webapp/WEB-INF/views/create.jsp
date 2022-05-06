<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>tờ khai y tế </title>
</head>
<body>
<p style="  text-align: center">
    TỜ KHAIYTÉ</p>

<p style=" text-align: center">
    ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUANYTẾ LIÊN LẠC KHI CÀN THIẾT ĐÉ PHÒNG CHÓNG DỊCH BỆNH
    TRUYỀN NHIỄM
</p>
<p style="color: red ; text-align: center">
    Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình sự
</p>

<form:form method="post" modelAttribute="list" action="createinformation">
    <div>
        Họ tên (ghi chữ IN HOA) (*)
        <form:input path="name"/>
    </div>

    <div>
        Năm Sinh
        <form:input type="date" path="yearOfBirth"/>
    </div>
    <div>
        Giới Tính
        <form:select path="gender">
            <form:option value="Nam"/>Nam
            <form:option value="Nữ"/>Nữ
        </form:select>
    </div>

    <div>
        Quốc Tịch
        <form:input path="country"/>
    </div>

    <div>
        Số Chứng Minh Nhân Dân
        <form:input path="idCMNN"/>
    </div>

    <div>
        Thông thi đi lại :
        <form:radiobutton path="travelInformation" value="Tàu bay"/> Tàu bay
        <form:radiobutton path="travelInformation" value="Tàu thuyền"/> Tàu thuyền
        <form:radiobutton path="travelInformation" value="Ô tô"/> Ô tô
        <form:radiobutton path="travelInformation" value="Khác"/> Khác
    </div>

    <div>
        Số hiệu phương tiện
        <form:input path="licensePlate"/>
    </div>

    <div>
        Ngày khổi hành
        <form:input path="dayStart"/>
    </div>

    <div>
        ngày Kết thúc
        <form:input path="dayEnd"/>
    </div>

    <div>
        thông tin 14 ngày qua
        <form:input cssStyle="width: 100px ;height: 50px;" path="information"/>
    </div>
    <input type="submit" value="LƯU" />

</form:form>

<button><a href="/inforMedical">in tư  </a></button>

</body>
</html>
