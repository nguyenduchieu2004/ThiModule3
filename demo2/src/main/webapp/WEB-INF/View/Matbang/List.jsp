<%--
  Created by IntelliJ IDEA.
  User: NGUYEN DUC HIEU
  Date: 13/01/2025
  Time: 7:41 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách Mặt Bằng</title>
</head>
<body>
<h1>Danh sách Mặt Bằng</h1>
<table border="1" cellpadding="5" cellspacing="0">
    <thead>
    <tr>
        <th>Mã Mặt Bằng</th>
        <th>Trạng Thái</th>
        <th>Diện Tích (m²)</th>
        <th>Tầng</th>
        <th>Loại Mặt Bằng</th>
        <th>Giá Tiền (VNĐ)</th>
        <th>Ngày Bắt Đầu</th>
        <th>Ngày Kết Thúc</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="matBang" items="${mat_bang}">
        <tr>
            <td>${matBang.maMatBang}</td>
            <td>${matBang.trangThai}</td>
            <td>${matBang.dienTich}</td>
            <td>${matBang.tang}</td>
            <td>${matBang.loaiMatBang}</td>
            <td>${matBang.giaTien}</td>
            <td>${matBang.ngayBatDau}</td>
            <td>${matBang.ngayKetThuc}</td>
            <td>
                <!-- Nút xóa -->
                <a href="/Matbang?action=delete&id=${matBang.id}"
                   onclick="return confirm('Bạn có chắc chắn muốn xóa mặt bằng với mã ${matBang.maMatBang} không?');">
                    Xóa
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>