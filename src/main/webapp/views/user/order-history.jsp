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
    
    <!-- BỘ LỌC TRẠNG THÁI -->
    <form action="${pageContext.request.contextPath}/order-history" method="get" class="mb-4">
        <div class="row align-items-center">
            <div class="col-auto">
                <label for="status" class="col-form-label fw-bold">Lọc theo trạng thái:</label>
            </div>
            <div class="col-auto">
                <select name="status" id="status" class="form-select">
                    <option value="all" ${selectedStatus == 'all' ? 'selected' : ''}>Tất cả</option>
                    <option value="Mới" ${selectedStatus == 'Mới' ? 'selected' : ''}>Đơn hàng mới</option>
                    <option value="Đã xác nhận" ${selectedStatus == 'Đã xác nhận' ? 'selected' : ''}>Đã xác nhận</option>
                    <option value="Chuẩn bị hàng" ${selectedStatus == 'Chuẩn bị hàng' ? 'selected' : ''}>Chuẩn bị hàng</option>
                    <option value="Vận chuyển" ${selectedStatus == 'Vận chuyển' ? 'selected' : ''}>Vận chuyển</option>
                    <option value="Giao hàng" ${selectedStatus == 'Giao hàng' ? 'selected' : ''}>Giao hàng</option>
                    <option value="Đã giao" ${selectedStatus == 'Đã giao' ? 'selected' : ''}>Đã giao</option>
                    <option value="Đơn hàng hủy" ${selectedStatus == 'Đơn hàng hủy' ? 'selected' : ''}>Đơn hàng hủy</option>
                    <option value="Đơn hàng hoàn" ${selectedStatus == 'Đơn hàng hoàn' ? 'selected' : ''}>Đơn hàng hoàn</option>
                </select>
            </div>
            <div class="col-auto">
                <button type="submit" class="btn btn-dark">Lọc</button>
            </div>
        </div>
    </form>
    <!-- KẾT THÚC BỘ LỌC -->

    <c:if test="${empty orders}">
        <div class="alert alert-info">Không có đơn hàng nào khớp với yêu cầu!</div>
    </c:if>
    <c:if test="${not empty orders}">
        <table class="table table-bordered table-striped">
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
                        <td>#${o.orderId}</td>
                        <td>${o.orderDate}</td>
                        <td>${o.totalAmount} đ</td>
                        <td><span class="badge bg-success">${o.status}</span></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    <a href="${pageContext.request.contextPath}/home" class="btn btn-primary mt-3">Quay lại trang chủ</a>
</div>
</body>
</html>