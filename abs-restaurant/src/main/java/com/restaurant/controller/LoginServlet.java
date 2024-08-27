package com.restaurant.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.restaurant.dao.UserDAO;
import com.restaurant.models.User;



public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDAO userDAO = new UserDAO();
        User user = userDAO.validateUser(username, password);

        if (user != null) {
            request.getSession().setAttribute("user", user);
            if ("customer".equals(user.getRole())) {
                response.sendRedirect("customer/dashboard.jsp");
            } else if ("staff".equals(user.getRole())) {
                response.sendRedirect("staff/dashboard.jsp");
            } else if ("admin".equals(user.getRole())) {
                response.sendRedirect("admin/dashboard.jsp");
            }
        } else {
            response.sendRedirect("login.jsp?error=Invalid username or password");
        }
    }
}
