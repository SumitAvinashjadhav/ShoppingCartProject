<%@ page import="java.util.List" %>
<%@ page import="com.ecommerce.bean.Product" %>

<%
    List<Product> products = (List<Product>) request.getAttribute("products");
%>

<h2>Products</h2>
<table border="1">
<tr>
    <th>Name</th>
    <th>Price</th>
    <th>Action</th>
</tr>
<%
    for(Product p : products) {
%>
<tr>
    <td><%= p.getName() %></td>
    <td><%= p.getPrice() %></td>
    <td>
        <form action="AddToCartServlet" method="get">
            <input type="hidden" name="productId" value="<%= p.getId() %>">
            <input type="hidden" name="quantity" value="1">
            <input type="submit" value="Add to Cart">
        </form>
    </td>
</tr>
<%
    }
%>
</table>
