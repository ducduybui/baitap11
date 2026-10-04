package vn.iotstar.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.iotstar.entity.User_24110177;
import vn.iotstar.model.CartItem_24110177;
import vn.iotstar.services.OrderService_24110177;
import vn.iotstar.services.impl.OrderServiceImpl_24110177;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/checkout"})
public class CheckoutController_24110177 extends HttpServlet {

    private OrderService_24110177 orderService = new OrderServiceImpl_24110177();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        
        User_24110177 user = (User_24110177) session.getAttribute("account");
        @SuppressWarnings("unchecked")
        List<CartItem_24110177> cart = (List<CartItem_24110177>) session.getAttribute("cart");

        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        if (cart != null && !cart.isEmpty()) {
            orderService.saveOrder(user, cart);
            session.removeAttribute("cart");
            
            // ĐÃ SỔ ĐÍCH: Thanh toán xong chuyển thẳng sang trang Lịch sử đơn hàng
            resp.sendRedirect(req.getContextPath() + "/order-history");
        } else {
            resp.sendRedirect(req.getContextPath() + "/home");
        }
    }
}