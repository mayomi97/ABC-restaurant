<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.restaurant.dao.ProductDAO" %>
<%@ page import="com.restaurant.models.Product" %>

<%
    // Initialize the ProductDAO and retrieve the list of products
    ProductDAO productDAO = new ProductDAO();
    List<Product> products = productDAO.getAllProducts();
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Food Online</title>
    <!-- Link to your CSS files -->
    <link rel="stylesheet" href="styles.css">
    <!-- You can include Bootstrap or other CSS frameworks if needed -->
</head>
<body>
    <div class="container">
        <h2>Order Food Online</h2>
        <p>Select from our delicious menu and add items to your cart.</p>

        <!-- Display the list of products available for order -->
        <div class="menu">
            <c:forEach var="product" items="${products}">
                <div class="menu-item">
                    <!-- Display product image, name, description, and price -->
                    <img src="images/${product.getName().toLowerCase()}.jpg" alt="${product.getName()}" class="menu-image">
                    <h3>${product.getName()}</h3>
                    <p>${product.getDescription()}</p>
                    <p>Price: $${product.getPrice()}</p>

                    <!-- Form to add product to the cart -->
                    <form action="CartServlet" method="post">
                        <input type="hidden" name="productId" value="${product.getProductId()}">
                        <button type="submit" class="btn btn-primary">Add to Cart</button>
                    </form>
                </div>
            </c:forEach>
        </div>
    </div>

    <!-- Include your JavaScript files -->
    <script src="scripts.js"></script>
</body>
</html>
