package com.restaurant.dao;

import com.restaurant.models.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.restaurant.dao.UserDAO;


public class UserDAO {

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String username = "root";
        String password = "password";
        return DriverManager.getConnection(url, username, password);
    }

    public User validateUser(String username, String password) {
        User user = null;
        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, username);
                stmt.setString(2, password);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    user = new User(rs.getInt("user_id"), username, rs.getString("role"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean registerUser(User user) {
        boolean result = false;
        try (Connection connection = getConnection()) {
            String sql = "INSERT INTO users (username, password, email, phone, role) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, user.getUsername());
                stmt.setString(2, user.getPassword());
                stmt.setString(3, user.getEmail());
                stmt.setString(4, user.getPhone());
                stmt.setString(5, user.getRole());
                result = stmt.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
