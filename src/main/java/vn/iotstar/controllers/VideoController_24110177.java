package vn.iotstar.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;
import vn.iotstar.entity.Video_24110177;
import vn.iotstar.services.VideoService_24110177;
import vn.iotstar.services.impl.VideoServiceImpl_24110177;

@WebServlet(urlPatterns = {"/admin/videos", "/admin/video/add", "/admin/video/insert", "/admin/video/edit", "/admin/video/update", "/admin/video/delete"})
public class VideoController_24110177 extends HttpServlet {
    private VideoService_24110177 videoService = new VideoServiceImpl_24110177();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        
        if (url.contains("videos")) {
            int page = 1;
            int pageSize = 6;
            String pageStr = req.getParameter("page");
            if (pageStr != null) {
                page = Integer.parseInt(pageStr);
            }
            
            List<Video_24110177> list = videoService.findAllPaginate(page, pageSize);
            long totalVideos = videoService.count();
            long totalPages = (long) Math.ceil((double) totalVideos / pageSize);
            
            req.setAttribute("videoList", list);
            req.setAttribute("currentPage", page);
            req.setAttribute("totalPages", totalPages);
            
            req.getRequestDispatcher("/views/admin/video-list.jsp").forward(req, resp);
        } else if (url.contains("delete")) {
            String id = req.getParameter("id");
            videoService.delete(id);
            resp.sendRedirect(req.getContextPath() + "/admin/videos");
        } else if (url.contains("add")) {
            req.getRequestDispatcher("/views/admin/video-add.jsp").forward(req, resp);
        } else if (url.contains("edit")) {
            String id = req.getParameter("id");
            Video_24110177 video = videoService.getById(id);
            req.setAttribute("video", video);
            req.getRequestDispatcher("/views/admin/video-edit.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String url = req.getRequestURI();
        
        if (url.contains("insert")) {
            String id = req.getParameter("videoid");
            String title = req.getParameter("title");
            String poster = req.getParameter("poster");
            int views = Integer.parseInt(req.getParameter("views"));
            String description = req.getParameter("description");
            boolean active = Boolean.parseBoolean(req.getParameter("active"));
            int categoryid = Integer.parseInt(req.getParameter("categoryid"));
            
            Video_24110177 v = new Video_24110177();
            v.setVideoid(id);
            v.setTitle(title);
            v.setPoster(poster);
            v.setViews(views);
            v.setDescription(description);
            v.setActive(active);
            v.setCategoryid(categoryid);
            
            videoService.insert(v);
            resp.sendRedirect(req.getContextPath() + "/admin/videos");
        } else if (url.contains("update")) {
            String id = req.getParameter("videoid");
            String title = req.getParameter("title");
            String poster = req.getParameter("poster");
            int views = Integer.parseInt(req.getParameter("views"));
            String description = req.getParameter("description");
            boolean active = Boolean.parseBoolean(req.getParameter("active"));
            int categoryid = Integer.parseInt(req.getParameter("categoryid"));
            
            Video_24110177 v = new Video_24110177();
            v.setVideoid(id);
            v.setTitle(title);
            v.setPoster(poster);
            v.setViews(views);
            v.setDescription(description);
            v.setActive(active);
            v.setCategoryid(categoryid);
            
            videoService.update(v);
            resp.sendRedirect(req.getContextPath() + "/admin/videos");
        }
    }
}