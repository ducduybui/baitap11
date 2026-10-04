<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Giỏ Hàng - 24110177</title>
    <!-- Import Bootstrap 5 để bảng đẹp gọn gàng -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">Giỏ Hàng Của Bạn</h2>
    
    <c:if test="${empty sessionScope.cart}">
        <div class="alert alert-warning">Giỏ hàng đang trống! Hãy thêm Video vào nhé.</div>
        <a href="${pageContext.request.contextPath}/home" class="btn btn-primary">Quay lại trang chủ</a>
    </c:if>

    <c:if test="${not empty sessionScope.cart}">
        <table class="table table-bordered text-center align-middle">
            <thead class="table-dark">
                <tr>
                    <th>Hình ảnh</th>
                    <th>Tên Video</th>
                    <th>Số lượng</th>
                    <th>Hành động</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${sessionScope.cart}" var="item">
                    <tr>
                        <td>
                            <img src="${item.video.poster}" alt="video" width="120" class="img-thumbnail">
                        </td>
                        <td>
                            <strong>${item.video.title}</strong>
                        </td>
                        <td>
                            <form action="${pageContext.request.contextPath}/cart/update" method="post" class="d-flex justify-content-center">
                                <!-- Đã sửa thành videoid (chữ i thường) -->
                                <input type="hidden" name="videoId" value="${item.video.videoid}">
                                <input type="number" name="quantity" value="${item.quantity}" min="1" max="10" class="form-control text-center" style="width: 80px; margin-right: 10px;">
                                <button type="submit" class="btn btn-warning btn-sm">Cập nhật</button>
                            </form>
                        </td>
                        <td>
                            <!-- Đã sửa thành videoid (chữ i thường) -->
                            <a href="${pageContext.request.contextPath}/cart/remove?videoId=${item.video.videoid}" class="btn btn-danger btn-sm">Xóa</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <div class="d-flex justify-content-between mt-4">
            <a href="${pageContext.request.contextPath}/home" class="btn btn-secondary">Tiếp tục chọn Video</a>
            
            <form action="${pageContext.request.contextPath}/checkout" method="post">
                <button type="submit" class="btn btn-success px-5">Thanh toán Đơn hàng (COD)</button>
            </form>
        </div>
    </c:if>
</div>
</body>
</html>