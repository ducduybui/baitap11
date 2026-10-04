package vn.iotstar.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import vn.iotstar.entity.Category_24110177;
import vn.iotstar.entity.Video_24110177;
import vn.iotstar.services.CategoryService_24110177;
import vn.iotstar.services.VideoService_24110177;
import vn.iotstar.services.impl.CategoryServiceImpl_24110177;
import vn.iotstar.services.impl.VideoServiceImpl_24110177;

@WebServlet(urlPatterns = {"/home"})
public class HomeController_24110177 extends HttpServlet {
    private CategoryService_24110177 categoryService = new CategoryServiceImpl_24110177();
    private VideoService_24110177 videoService = new VideoServiceImpl_24110177();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category_24110177> categories = categoryService.getAll();
        
        Map<Integer, List<Video_24110177>> videoMap = new HashMap<>();
        Map<Integer, Long> countMap = new HashMap<>();
        Map<Integer, Long> totalPagesMap = new HashMap<>();

        int pageSize = 3;

        for (Category_24110177 cat : categories) {
            int catId = cat.getCategoryid();
            
            int page = 1;
            String pageParam = req.getParameter("p_" + catId);
            if (pageParam != null) {
                page = Integer.parseInt(pageParam);
            }

            List<Video_24110177> videos = videoService.findByCategoryIdPaginate(catId, page, pageSize);
            long totalVideos = videoService.countByCategoryId(catId);
            long totalPages = (long) Math.ceil((double) totalVideos / pageSize);

            videoMap.put(catId, videos);
            countMap.put(catId, totalVideos);
            totalPagesMap.put(catId, totalPages == 0 ? 1 : totalPages);
        }

        req.setAttribute("categories", categories);
        req.setAttribute("videoMap", videoMap);
        req.setAttribute("countMap", countMap);
        req.setAttribute("totalPagesMap", totalPagesMap);

        req.getRequestDispatcher("/views/user/home.jsp").forward(req, resp);
    }
}