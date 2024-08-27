package com.restaurant.dao;

import com.restaurant.models.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String username = "root";
        String password = "password";
        return DriverManager.getConnection(url, username, password);
    }

    public boolean addProduct(Product product) {
        boolean result = false;
        try (Connection connection = getConnection()) {
            String sql = "INSERT INTO products (name, description, price) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, product.getName());
                stmt.setString(2, product.getDescription());
                stmt.setDouble(3, product.getPrice());
                result = stmt.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean updateProduct(Product product) {
        boolean result = false;
        try (Connection connection = getConnection()) {
            String sql = "UPDATE products SET name = ?, description = ?, price = ? WHERE product_id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, product.getName());
                stmt.setString(2, product.getDescription());
                stmt.setDouble(3, product.getPrice());
                stmt.setInt(4, product.getProductId());
                result = stmt.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM products";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    Product product = new Product(
                        rs.getInt("product_id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDouble("price")
                    );
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public boolean deleteProduct(int productId) {
        boolean result = false;
        try (Connection connection = getConnection()) {
            String sql = "DELETE FROM products WHERE product_id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, productId);
                result = stmt.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

	public Product getProductById(int productId) {
		// TODO Auto-generated method stub
		return null;
	}
}
