<%@page import="com.ecommerce.bean.CartItem"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ecommerce.bean.Cart"%>

<%
    ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("CartData");
    Integer userIdObj = (Integer) session.getAttribute("userId");
    int userId = (userIdObj != null) ? userIdObj : 0;
%>

<!DOCTYPE html>
<html>
<head>
    <title>Your Cart</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(120deg, #f6f9fc, #e9eff5);
            margin: 0;
            padding: 0;
        }
        h2 {
            text-align: center;
            padding: 20px;
            color: #333;
            margin-top: 20px;
        }
        .cart-container {
            width: 90%;
            max-width: 1000px;
            margin: auto;
            background: white;
            padding: 20px;
            border-radius: 12px;
            box-shadow: 0 5px 25px rgba(0,0,0,0.1);
        }
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th {
            background: #3b5d50;
            color: white;
            padding: 12px;
            font-size: 16px;
        }
        td {
            padding: 12px;
            text-align: center;
            border-bottom: 1px solid #eee;
            font-size: 15px;
        }
        img {
            border-radius: 8px;
        }
        a.cancel-btn {
            text-decoration: none;
            color: white;
            background: #dc3545;
            padding: 6px 12px;
            border-radius: 6px;
            transition: background 0.3s ease;
        }
        a.cancel-btn:hover {
            background: #b02a37;
        }
        .total-row {
            font-weight: bold;
            background-color: #f8f9fa;
        }
        .empty-cart {
            text-align: center;
            padding: 40px;
            color: #666;
            font-size: 18px;
        }
        .cart-actions {
            display: flex;
            justify-content: space-between;
            margin-top: 20px;
        }
        .btn {
            text-decoration: none;
            padding: 10px 20px;
            border-radius: 6px;
            font-size: 16px;
            transition: background 0.3s ease;
        }
        .btn-shop {
            background: #28a745;
            color: white;
        }
        .btn-shop:hover {
            background: #218838;
        }
        .btn-pay {
            background: #ffc107;
            color: black;
        }
        .btn-pay:hover {
            background: #e0a800;
        }
    </style>
</head>
<body>

<h2> Your Shopping Cart</h2>

<div class="cart-container">
<%
    if (cartList == null || cartList.isEmpty()) {
%>
    <p class="empty-cart">Your cart is empty. <a href="productList.jsp">Start Shopping</a> 🛍</p>
<%
    } else {
        double grandTotal = 0;
%>
    <table>
        <tr>
            <th>Name</th>
            <th>Price</th>
            <th>Image</th>
            <th>Quantity</th>
            <th>Total</th>
            <th>Cancel</th>
        </tr>
        <% 
            for (Cart item : cartList) {
                double total = item.getProductPrice() * item.getQuantity();
                grandTotal += total;
               
        %>
        <tr>
            <td><%= item.getProductName() %></td>
            <td><%= item.getProductPrice() %></td>
            <td><img src="<%= item.getProductImage() %>" width="80" height="80"></td>
            <td><%= item.getQuantity() %></td>
            <td><%= total %></td>
            <td>
                <a class="cancel-btn" href="RemoveFromCartController?productId=<%= item.getProductId() %>&userId=<%= userId %>">
                    Cancel
                </a>
            </td>
        </tr>
        <% } %>
        <tr class="total-row">
            <td colspan="4">Grand Total</td>
            <td colspan="2"><%= grandTotal %></td>
        </tr>
    </table>

    <div class="cart-actions">
        <a href="shop.jsp" class="btn btn-shop"> Continue Shopping</a>
        <a href="payment.jsp" class="btn btn-pay">Proceed to Payment </a>
    </div>
<%
    }
%>
</div>

</body>
</html>
