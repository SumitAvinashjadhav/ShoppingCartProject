<%@ page import="java.util.List" %>
<%@ page import="com.ecommerce.bean.CartItem" %>

<%
    List<CartItem> cartItems = (List<CartItem>) request.getAttribute("cartItems");
%>

<h2>Your Cart</h2>
<table border="1">
<tr>
    <th>Product ID</th>
    <th>Quantity</th>
    <th>Action</th>
</tr>
<%
    for(CartItem c : cartItems) {
%>
<tr>
    <td><%= c.getProductId() %></td>
    <td><%= c.getQuantity() %></td>
    <td>
        <form action="RemoveFromCartServlet" method="get">
            <input type="hidden" name="productId" value="<%= c.getProductId() %>">
            <input type="submit" value="Remove">
        </form>
    </td>
</tr>
<%
    }
%>
</table>
