package vn.iotstar.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.iotstar.entity.Video_24110177;
import vn.iotstar.model.CartItem_24110177;
import vn.iotstar.services.VideoService_24110177;
import vn.iotstar.services.impl.VideoServiceImpl_24110177;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/cart", "/cart/add", "/cart/update", "/cart/remove"})
public class CartController_24110177 extends HttpServlet {

    private VideoService_24110177 videoService = new VideoServiceImpl_24110177(); 

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        HttpSession session = req.getSession();
        
        @SuppressWarnings("unchecked")
        List<CartItem_24110177> cart = (List<CartItem_24110177>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }

        if ("/cart/add".equals(path)) {
            String videoId = req.getParameter("videoId"); 
            // Đã sửa thành getById theo đúng Service của bạn
            Video_24110177 video = videoService.getById(videoId); 

            if (video != null) {
                boolean exist = false;
                for (CartItem_24110177 item : cart) {
                    // Đã sửa thành getVideoid() theo đúng thuộc tính trong entity
                    if (item.getVideo().getVideoid().equals(videoId)) {
                        if(item.getQuantity() < 10) {
                            item.setQuantity(item.getQuantity() + 1); 
                        }
                        exist = true;
                        break;
                    }
                }
                if (!exist) {
                    cart.add(new CartItem_24110177(video, 1)); 
                }
            }
            session.setAttribute("cart", cart);
            resp.sendRedirect(req.getContextPath() + "/cart");

        } else if ("/cart/remove".equals(path)) {
            String videoId = req.getParameter("videoId");
            cart.removeIf(item -> item.getVideo().getVideoid().equals(videoId));
            session.setAttribute("cart", cart);
            resp.sendRedirect(req.getContextPath() + "/cart");

        } else {
            req.getRequestDispatcher("/views/user/cart.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        
        if ("/cart/update".equals(path)) {
            HttpSession session = req.getSession();
            @SuppressWarnings("unchecked")
            List<CartItem_24110177> cart = (List<CartItem_24110177>) session.getAttribute("cart");
            
            String videoId = req.getParameter("videoId");
            int quantity = Integer.parseInt(req.getParameter("quantity"));

            if (cart != null) {
                for (CartItem_24110177 item : cart) {
                    if (item.getVideo().getVideoid().equals(videoId)) {
                        if(quantity > 0 && quantity <= 10) {
                            item.setQuantity(quantity);
                        }
                        break;
                    }
                }
                session.setAttribute("cart", cart);
            }
            resp.sendRedirect(req.getContextPath() + "/cart");
        }
    }
}