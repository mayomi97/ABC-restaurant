package com.restaurant.dao;

import com.restaurant.models.Reservation;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String username = "root";
        String password = "password";
        return DriverManager.getConnection(url, username, password);
    }

    public boolean createReservation(Reservation reservation) {
        boolean result = false;
        try (Connection connection = getConnection()) {
            String sql = "INSERT INTO reservations (user_id, type, date, time, status) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, reservation.getUserId());
                stmt.setString(2, reservation.getType());
                stmt.setDate(3, reservation.getDate());
                stmt.setTime(4, reservation.getTime());
                stmt.setString(5, reservation.getStatus());
                result = stmt.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Reservation> getReservationsByUserId(int userId) {
        List<Reservation> reservations = new ArrayList<>();
        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM reservations WHERE user_id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, userId);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    Reservation reservation = new Reservation(
                        rs.getInt("reservation_id"),
                        rs.getInt("user_id"),
                        rs.getString("type"),
                        rs.getDate("date"),
                        rs.getTime("time"),
                        rs.getString("status")
                    );
                    reservations.add(reservation);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservations;
    }
}
