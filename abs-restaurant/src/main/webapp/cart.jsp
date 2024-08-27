<!-- cart.jsp -->
<%@ page import="java.util.List" %>
<%@ page import="com.restaurant.models.Product" %>
<%
    List<Product> cart = (List<Product>) session.getAttribute("cart");
    double total = 0;
    if (cart != null) {
        for (Product product : cart) {
            total += product.getPrice();
        }
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Cart</title>
    <!-- Include your CSS and JS files -->
</head>
<body>
    <div class="container">
        <h2>Your Cart</h2>

        <c:if test="${cart != null}">
            <table>
                <thead>
                    <tr>
                        <th>Item</th>
                        <th>Price</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="product" items="${cart}">
                        <tr>
                            <td>${product.getName()}</td>
                            <td>$${product.getPrice()}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <h3>Total: $${total}</h3>

            <form action="CheckoutServlet" method="post">
                <button type="submit" class="btn btn-primary">Checkout</button>
            </form>
        </c:if>

        <c:if test="${cart == null || cart.isEmpty()}">
            <p>Your cart is empty.</p>
        </c:if>
    </div>
</body>
</html>
