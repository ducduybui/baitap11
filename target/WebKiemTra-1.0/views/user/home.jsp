<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Trang Chủ - Bùi Đức Duy (24110177)</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; background: #f9f9f9; }
        .header-banner { background: #007bff; color: white; padding: 15px 20px; text-align: center; border-radius: 6px; margin-bottom: 20px; display: flex; justify-content: space-between; align-items: center; }
        .category-section { margin-bottom: 30px; background: #fff; padding: 15px; border-radius: 6px; box-shadow: 0 2px 4px rgba(0,0,0,0.1); }
        .video-grid { display: flex; gap: 20px; flex-wrap: wrap; margin-top: 10px; }
        .video-card { width: 220px; border: 1px solid #ddd; padding: 10px; border-radius: 4px; text-align: center; background: #fff; display: flex; flex-direction: column; justify-content: space-between; }
        .video-card img { width: 100%; height: 130px; object-fit: cover; border-radius: 4px; }
        .pagination { margin-top: 15px; }
        .pagination a { padding: 5px 10px; margin: 0 2px; border: 1px solid #007bff; text-decoration: none; color: #007bff; border-radius: 3px; }
        .pagination a.active { background: #007bff; color: white; }
        .footer { text-align: center; color: #666; padding: 20px; margin-top: 40px; border-top: 1px solid #ddd; }
        
        /* CSS cho nút Giỏ hàng */
        .btn-cart { background: #ff9800; color: white; padding: 8px 12px; text-decoration: none; border-radius: 4px; display: inline-block; width: 100%; box-sizing: border-box; margin-top: 10px; font-weight: bold; }
        .btn-cart:hover { background: #e68900; }
        .top-cart-btn { background: #17a2b8; color: white; padding: 8px 15px; text-decoration: none; border-radius: 4px; margin-right: 15px; font-weight: bold; border: 1px solid #fff; }
    </style>
</head>
<body>
    <div class="header-banner">
        <div>
            <h2 style="margin: 0;">Họ tên: Bùi Đức Duy | MSSV: 24110177 | Đề số: 03</h2>
            <p style="margin: 5px 0 0 0;">Trang Chủ Quản Lý Website Video - MVC & JPA</p>
        </div>
        <div>
            <!-- NÚT GIỎ HÀNG TRÊN HEADER -->
            <a href="${pageContext.request.contextPath}/cart" class="top-cart-btn">
                🛒 Giỏ hàng (<c:out value="${empty sessionScope.cart ? 0 : sessionScope.cart.size()}"/>)
            </a>

            <c:choose>
                <c:when test="${not empty sessionScope.account}">
                    <span style="margin-right: 15px; font-weight: bold;">Xin chào: ${sessionScope.account.username}</span>
                    <a href="${pageContext.request.contextPath}/logout" style="background: #dc3545; color: white; padding: 8px 12px; text-decoration: none; border-radius: 4px;">Đăng Xuất</a>
                </c:when>
                <c:otherwise>
                    <a href="${pageContext.request.contextPath}/login" style="background: #28a745; color: white; padding: 8px 12px; text-decoration: none; border-radius: 4px; margin-right: 5px;">Đăng Nhập</a>
                    <a href="${pageContext.request.contextPath}/register" style="background: #ffc107; color: black; padding: 8px 12px; text-decoration: none; border-radius: 4px;">Đăng Ký</a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>

    <c:forEach items="${categories}" var="cat">
        <div class="category-section">
            <h3>${cat.categoryname} (${countMap[cat.categoryid]} video)</h3>
            
            <div class="video-grid">
                <c:forEach items="${videoMap[cat.categoryid]}" var="v">
                    <div class="video-card">
                        <div>
                            <a href="${pageContext.request.contextPath}/video/detail?id=${v.videoid}">
                                <img src="${v.poster}" alt="Poster" onerror="this.src='https://via.placeholder.com/200x130?text=No+Image'"/>
                            </a>
                            <h4><a href="${pageContext.request.contextPath}/video/detail?id=${v.videoid}" style="text-decoration: none; color: #007bff;">${v.title}</a></h4>
                            <p style="margin: 5px 0;">Mã video: ${v.videoid}</p>
                            <p style="margin: 5px 0;">View: ${v.views}</p>
                            <p style="margin: 5px 0; font-size: 13px; color: #555;">Share(10) | Like(10)</p>
                        </div>
                        <!-- NÚT THÊM VÀO GIỎ HÀNG DƯỚI VIDEO -->
                        <a href="${pageContext.request.contextPath}/cart/add?videoId=${v.videoid}" class="btn-cart">Thêm vào Giỏ</a>
                    </div>
                </c:forEach>
            </div>

            <div class="pagination">
                <c:set var="paramName" value="p_${cat.categoryid}" />
                <c:forEach begin="1" end="${totalPagesMap[cat.categoryid]}" var="i">
                    <a href="home?p_${cat.categoryid}=${i}" class="${param[paramName] == i || (empty param[paramName] && i == 1) ? 'active' : ''}">${i}</a>
                </c:forEach>
            </div>
        </div>
    </c:forEach>

    <div class="footer">
        <p>&copy; 2026 - Phát triển bởi Bùi Đức Duy (24110177). All rights reserved.</p>
    </div>
</body>
</html>