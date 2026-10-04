<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chi Tiết Video - Bùi Đức Duy (24110177)</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f9f9f9; margin: 30px; }
        .detail-box { max-width: 600px; margin: auto; background: white; padding: 25px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0,0,0,0.1); }
        .video-poster img { width: 100%; max-height: 300px; object-fit: cover; border-radius: 6px; margin-bottom: 15px; }
        h3 { margin-top: 0; color: #333; }
        p { font-size: 15px; color: #444; line-height: 1.5; }
        .back-link { display: inline-block; margin-top: 20px; text-decoration: none; color: #007bff; font-weight: bold; }
    </style>
</head>
<body>
    <div class="detail-box">
        <div class="video-poster">
            <img src="${video.poster}" alt="Poster" onerror="this.src='https://via.placeholder.com/500x300?text=No+Image'"/>
        </div>
        <h3>Tiêu đề: ${video.title}</h3>
        <p><strong>Mã video:</strong> ${video.videoid}</p>
        <p><strong>Category ID:</strong> ${video.categoryid}</p>
        <p><strong>View:</strong> ${video.views}</p>
        <p><strong>Share(10) | Like(10)</strong></p>
        <hr style="border: 0; border-top: 1px solid #ddd; margin: 15px 0;">
        <p><strong>Description:</strong> ${video.description}</p>
        
        <a href="${pageContext.request.contextPath}/home" class="back-link">&larr; Quay lại trang chủ</a>
    </div>
</body>
</html>