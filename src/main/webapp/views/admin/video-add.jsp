<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm Video Mới - 24110177</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 30px; background: #f9f9f9; }
        .form-box { max-width: 500px; margin: auto; background: #fff; padding: 20px; border-radius: 6px; box-shadow: 0 2px 4px rgba(0,0,0,0.1); }
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; font-weight: bold; }
        input[type="text"], textarea { width: 100%; padding: 8px; border: 1px solid #ddd; border-radius: 4px; }
        button { padding: 10px 20px; background: #28a745; color: white; border: none; border-radius: 4px; cursor: pointer; }
        button:hover { background: #218838; }
    </style>
</head>
<body>
    <div class="form-box">
        <h2>Thêm mới Video</h2>
        <form action="${pageContext.request.contextPath}/admin/video/insert" method="post">
            <div class="form-group">
                <label>Mã Video (Videold):</label>
                <input type="text" name="videoid" required />
            </div>
            <div class="form-group">
                <label>Tiêu đề:</label>
                <input type="text" name="title" required />
            </div>
            <div class="form-group">
                <label>Link Poster:</label>
                <input type="text" name="poster" />
            </div>
            <div class="form-group">
                <label>Lượt xem (Views):</label>
                <input type="text" name="views" value="0" />
            </div>
            <div class="form-group">
                <label>Mô tả (Description):</label>
                <textarea name="description" rows="3"></textarea>
            </div>
            <div class="form-group">
                <label>Trạng thái Active (true/false):</label>
                <input type="text" name="active" value="true" />
            </div>
            <div class="form-group">
                <label>Mã danh mục (Category ID):</label>
                <input type="text" name="categoryid" required />
            </div>
            <button type="submit">Lưu Video</button>
        </form>
    </div>
</body>
</html>