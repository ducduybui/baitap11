package vn.iotstar.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import vn.iotstar.entity.User_24110177;
import vn.iotstar.services.UserService_24110177;
import vn.iotstar.services.impl.UserServiceImpl_24110177;

@WebServlet(urlPatterns = {"/login"})
public class LoginController_24110177 extends HttpServlet {
    private UserService_24110177 userService = new UserServiceImpl_24110177();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Cố định font tiếng Việt
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String username = req.getParameter("username");
        String pass = req.getParameter("password");

        User_24110177 user = userService.login(username, pass);
        if (user != null && user.isActive()) {
            HttpSession session = req.getSession();
            session.setAttribute("account", user);
            if (user.isAdmin()) {
                resp.sendRedirect(req.getContextPath() + "/admin/home");
            } else {
                resp.sendRedirect(req.getContextPath() + "/home");
            }
        } else {
            req.setAttribute("error", "Tài khoản không chính xác hoặc chưa kích hoạt!");
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        }
    }
}