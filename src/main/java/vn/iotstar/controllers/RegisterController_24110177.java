package vn.iotstar.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import vn.iotstar.entity.User_24110177;
import vn.iotstar.services.UserService_24110177;
import vn.iotstar.services.impl.UserServiceImpl_24110177;

@WebServlet(urlPatterns = {"/register", "/send-otp", "/verify-register"})
public class RegisterController_24110177 extends HttpServlet {
    private UserService_24110177 userService = new UserServiceImpl_24110177();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if (url.contains("register")) {
            req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String url = req.getRequestURI();
        HttpSession session = req.getSession();

        if (url.contains("send-otp")) {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String email = req.getParameter("email");
            String fullname = req.getParameter("fullname"); 

            String otp = String.format("%06d", new Random().nextInt(999999));
            boolean sent = sendEmail(email, otp);

            if (sent) {
                session.setAttribute("reg_username", username);
                session.setAttribute("reg_password", password);
                session.setAttribute("reg_email", email);
                if (fullname != null) session.setAttribute("reg_fullname", fullname);
                session.setAttribute("server_otp", otp);

                req.setAttribute("message", "Ma OTP da duoc gui ve email cua ban! Vui long kiem tra.");
                req.getRequestDispatcher("/views/verify-otp.jsp").forward(req, resp);
            } else {
                req.setAttribute("error", "Gui email that bai. Vui long kiem tra lai dia chi email!");
                req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
            }

        } else if (url.contains("verify-register")) {
            String userOtp = req.getParameter("otp");
            String serverOtp = (String) session.getAttribute("server_otp");

            if (serverOtp != null && serverOtp.equals(userOtp)) {
                String username = (String) session.getAttribute("reg_username");
                String password = (String) session.getAttribute("reg_password");

                User_24110177 user = new User_24110177();
                user.setUsername(username);
                user.setPassword(password);
                user.setAdmin(false);
                user.setActive(true); // Kich hoạt tài khoản ngay

                userService.insert(user);
                session.removeAttribute("server_otp");

                req.setAttribute("success", "Dang ky thanh cong! Vui long dang nhap.");
                req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
            } else {
                req.setAttribute("error", "Ma OTP khong chinh xac!");
                req.getRequestDispatcher("/views/verify-otp.jsp").forward(req, resp);
            }
        }
    }

    private boolean sendEmail(String recipientEmail, String otp) {
        final String fromEmail = "ducduybui247@gmail.com"; 
        final String appPassword = "tjxf ennf yutj tzbf";   

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, appPassword);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject("Ma xac thuc OTP Dang Ky Website", "UTF-8");
            message.setText("Xin chao,\n\nMa OTP dang ky tai khoan cua ban la: " + otp + "\n\nVui long khong chia se ma nay cho bat ky ai.");
            
            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }
}