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

        // Lấy tham số status từ URL
        String status = req.getParameter("status");
        List<Order_24110177> orders;

        // Nếu có chọn lọc trạng thái và không phải "all"
        if (status != null && !status.isEmpty() && !status.equals("all")) {
            orders = orderService.findByUserIdAndStatus(user.getUsername(), status);
        } else {
            orders = orderService.findByUserId(user.getUsername());
            status = "all"; // gán mặc định để hiển thị đúng trên thẻ select
        }

        req.setAttribute("orders", orders);
        req.setAttribute("selectedStatus", status); // Lưu trạng thái đang chọn để View giữ nguyên giá trị

        req.getRequestDispatcher("/views/user/order-history.jsp").forward(req, resp);
    }
}