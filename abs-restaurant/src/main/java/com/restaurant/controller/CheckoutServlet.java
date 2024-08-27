package com.restaurant.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.restaurant.models.Product;

import java.io.IOException;
import java.util.List;


public class CheckoutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Product> cart = (List<Product>) session.getAttribute("cart");

        if (cart != null && !cart.isEmpty()) {
            // Here you would handle payment processing and order creation.
            // For simplicity, we will just clear the cart and display a success message.

            session.removeAttribute("cart");
            request.setAttribute("message", "Your order has been placed successfully!");
            request.getRequestDispatcher("orderSuccess.jsp").forward(request, response);
        } else {
            response.sendRedirect("cart.jsp");
        }
    }
}
