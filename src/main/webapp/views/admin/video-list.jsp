<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản lý Video - Bùi Đức Duy (24110177)</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; background-color: #f8f9fa; }
        h2 { color: #333; }
        table { width: 100%; border-collapse: collapse; background: #fff; margin-top: 15px; }
        th, td { padding: 12px; border: 1px solid #ddd; text-align: center; }
        th { background-color: #007bff; color: white; }
        .btn { padding: 6px 12px; text-decoration: none; background: #28a745; color: white; border-radius: 4px; }
        .btn-danger { background: #dc3545; }
        .pagination { margin-top: 20px; text-align: center; }
        .pagination a { padding: 8px 16px; margin: 0 4px; border: 1px solid #ddd; text-decoration: none; background: #fff; color: #007bff; border-radius: 4px; }
        .pagination a.active { background: #007bff; color: white; border-color: #007bff; }
    </style>
</head>
<body>
    <h2>Quản lý danh sách Video (Phân trang 6 video/trang)</h2>
    <a href="video/add" class="btn">Thêm Video mới</a>
    <table>
        <tr>
            <th>Mã Video</th>
            <th>Tiêu đề</th>
            <th>Poster</th>
            <th>Views</th>
            <th>Trạng thái</th>
            <th>Hành động</th>
        </tr>
        <c:forEach items="${videoList}" var="v">
            <tr>
                <td>${v.videoid}</td>
                <td>${v.title}</td>
                <td><img src="${v.poster}" width="60" height="40"/></td>
                <td>${v.views}</td>
                <td>${v.active ? 'Hoạt động' : 'Khóa'}</td>
                <td>
                    <a href="video/edit?id=${v.videoid}" class="btn">Sửa</a>
                    <a href="video/delete?id=${v.videoid}" class="btn btn-danger" onclick="return confirm('Bạn có chắc muốn xóa?')">Xóa</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <!-- Phân trang -->
    <div class="pagination">
        <c:forEach begin="1" end="${totalPages}" var="i">
            <a href="videos?page=${i}" class="${currentPage == i ? 'active' : ''}">${i}</a>
        </c:forEach>
    </div>
</body>
</html>