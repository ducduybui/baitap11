package vn.iotstar.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.entity.Order_24110177;
import vn.iotstar.entity.User_24110177;
import vn.iotstar.services.OrderService_24110177;
import vn.iotstar.services.impl.OrderServiceImpl_24110177;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/order-history"})
public class OrderHistoryController_24110177 extends HttpServlet {
    private OrderService_24110177 orderService = new OrderServiceImpl_24110177();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User_24110177 user = (User_24110177) session.getAttribute("account");

        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        // Truy vấn danh sách đơn hàng dựa vào username của user đang đăng nhập
        List<Order_24110177> orders = orderService.findByUserId(user.getUsername());
        req.setAttribute("orders", orders);

        req.getRequestDispatcher("/views/user/order-history.jsp").forward(req, resp);
    }
}