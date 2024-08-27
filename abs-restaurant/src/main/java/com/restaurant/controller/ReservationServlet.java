package com.restaurant.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.restaurant.dao.ReservationDAO;
import com.restaurant.dao.UserDAO;
import com.restaurant.models.Reservation;
import com.restaurant.models.User;

public class ReservationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String type = request.getParameter("type");
        String date = request.getParameter("date");
        String time = request.getParameter("time");

        Reservation reservation = new Reservation();
        ReservationDAO reservationDAO = new ReservationDAO();

        if (reservationDAO.createReservation(reservation)) {
            response.sendRedirect("customer/dashboard.jsp?success=Reservation successful");
        } else {
            response.sendRedirect("reservation.jsp?error=Reservation failed");
        }
    }
}
