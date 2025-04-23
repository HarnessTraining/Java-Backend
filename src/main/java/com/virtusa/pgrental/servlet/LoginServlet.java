package com.virtusa.pgrental.servlet;

import com.virtusa.pgrental.dao.UserDAO;
import com.virtusa.pgrental.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("pass");
        HttpSession session = req.getSession();
        RequestDispatcher requestDispatcher = null;

        UserDAO userDAO = new UserDAO();
        User user = userDAO.getUserByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("email", email);
            requestDispatcher = req.getRequestDispatcher("index.jsp");
        } else {
            req.setAttribute("status", "failed");
            requestDispatcher = req.getRequestDispatcher("login.jsp");
        }
        requestDispatcher.forward(req, resp);
    }
}
