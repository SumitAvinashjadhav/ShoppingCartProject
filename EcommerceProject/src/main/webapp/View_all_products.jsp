<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ecommerce.bean.Product" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    ArrayList<Product> list = (ArrayList<Product>) session.getAttribute("AllProduct");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>View Products</title>
    <link rel="stylesheet" href="path_to_bootstrap.css"> <!-- Optional -->
</head>
<body>
    <h2>Product List</h2>

    <%
        if (list == null || list.isEmpty()) {
    %>
        <p>No products found.</p>
    <%
        } else {
    %>

    <table border="1" cellpadding="10" cellspacing="0">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Image</th>
                <th>Description</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <%
                for(Product p : list){
            %>
            <tr>
                <td><%= p.getId() %></td>
                <td><%= p.getName() %></td>
                <td>₹<%= p.getPrice() %></td>
                <td><img src="<%= p.getImage() %>" alt="<%= p.getName() %>" width="60" /></td>
                <td><%= p.getDescription() %></td>
                <td>
                    <form action="ProductUpdateController" method="get" style="display:inline;">
                        <input type="hidden" name="id" value="<%= p.getId() %>" />
                        <input type="submit" value="Update" />
                    </form>

                    <form action="ProductDeleteController" method="get" style="display:inline;" onsubmit="return confirm('Are you sure to delete?');">
                        <input type="hidden" name="id" value="<%= p.getId() %>" />
                        <input type="submit" value="Delete" />
                    </form>
                </td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>

    <%
        }
    %>
</body>
</html>
