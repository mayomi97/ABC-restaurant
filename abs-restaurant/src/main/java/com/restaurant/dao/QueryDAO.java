package com.restaurant.dao;

import com.restaurant.models.Query;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryDAO {

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String username = "root";
        String password = "password";
        return DriverManager.getConnection(url, username, password);
    }

    public boolean submitQuery(Query query) {
        boolean result = false;
        try (Connection connection = getConnection()) {
            String sql = "INSERT INTO queries (user_id, message, status) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, query.getUserId());
                stmt.setString(2, query.getMessage());
                stmt.setString(3, query.getStatus());
                result = stmt.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Query> getQueriesByUserId(int userId) {
        List<Query> queries = new ArrayList<>();
        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM queries WHERE user_id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, userId);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    Query query = new Query(
                        rs.getInt("query_id"),
                        rs.getInt("user_id"),
                        rs.getString("message"),
                        rs.getString("status")
                    );
                    queries.add(query);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return queries;
    }
}
