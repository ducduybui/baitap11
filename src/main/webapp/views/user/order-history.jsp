<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lịch Sử Đơn Hàng - 24110177</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2>Lịch Sử Mua Hàng Của Bạn</h2>
    <hr>
    <c:if test="${empty orders}">
        <div class="alert alert-info">Bạn chưa có đơn hàng nào!</div>
    </c:if>
    <c:if test="${not empty orders}">
        <table class="table table-bordered">
            <thead class="table-dark">
                <tr>
                    <th>Mã Đơn Hàng</th>
                    <th>Ngày Mua</th>
                    <th>Tổng Tiền</th>
                    <th>Trạng thái</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${orders}" var="o">
                    <tr>
                        <!-- Sửa từ orderid thành orderId -->
                        <td>#${o.orderId}</td>
                        <!-- Sửa từ buyDate thành orderDate cho khớp với Entity -->
                        <td>${o.orderDate}</td>
                        <td>${o.totalAmount} đ</td>
                        <td><span class="badge bg-success">${o.status} (${o.paymentMethod})</span></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    <a href="${pageContext.request.contextPath}/home" class="btn btn-primary mt-3">Quay lại trang chủ</a>
</div>
</body>
</html>