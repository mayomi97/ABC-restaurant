package com.restaurant.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.restaurant.dao.QueryDAO;
import com.restaurant.dao.UserDAO;
import com.restaurant.models.Query;
import com.restaurant.models.User;
public class QueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String message = request.getParameter("message");

        Query query = new Query(user.getUserId(), message, message);
        QueryDAO queryDAO = new QueryDAO();

        if (queryDAO.submitQuery(query)) {
            response.sendRedirect("customer/dashboard.jsp?success=Query submitted");
        } else {
            response.sendRedirect("submitQuery.jsp?error=Query submission failed");
        }
    }
}
