package vn.iotstar.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import vn.iotstar.entity.Video_24110177;
import vn.iotstar.services.VideoService_24110177;
import vn.iotstar.services.impl.VideoServiceImpl_24110177;

@WebServlet(urlPatterns = {"/video/detail"})
public class VideoDetailController_24110177 extends HttpServlet {
    private VideoService_24110177 videoService = new VideoServiceImpl_24110177();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Video_24110177 video = videoService.getById(id);
        
        req.setAttribute("video", video);
        req.setAttribute("shareCount", 10);
        req.setAttribute("likeCount", 10);
        
        req.getRequestDispatcher("/views/user/video-detail.jsp").forward(req, resp);
    }
}