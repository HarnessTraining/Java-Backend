package com.virtusa.pgrental.servlet;

import com.virtusa.pgrental.dao.UserDAO;
import com.virtusa.pgrental.model.User;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String pass = req.getParameter("pass");
        String rePass = req.getParameter("re_pass");
        String mobile = req.getParameter("mobile");

        // Validate passwords match
        if (!pass.equals(rePass)) {
            req.setAttribute("status", "password_mismatch");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("registration.jsp");
            requestDispatcher.forward(req, resp);
            return;
        }

        User user = new User(name, email, pass, mobile);
        UserDAO userDAO = new UserDAO();
        boolean success = userDAO.addUser(user);

        if (success) {
            req.setAttribute("status", "success");
        } else {
            req.setAttribute("status", "failed");
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("registration.jsp");
        requestDispatcher.forward(req, resp);
    }
}
