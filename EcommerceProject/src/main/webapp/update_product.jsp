<%@page import="com.ecommerce.bean.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Update Product</h2>
	<%
		Product p =(Product)session.getAttribute("data");
	%>
		<form action="ProductUpdateDataController" method="get">
		    <!-- Hidden field to hold product id -->
		    <input type="hidden" name="id" value="<%= p.getId() %>" />
		
		    <label for="name">Name:</label><br>
		    <input type="text" id="name" name="name" value="<%= p.getName() %>" required /><br><br>
		
		    <label for="price">Price:</label><br>
		    <input type="number" id="price" name="price" step="0.01" value="<%= p.getPrice() %>" required /><br><br>
		
		    <label for="image">Image URL:</label><br>
		    <input type="text" id="image" name="image" value="<%= p.getImage() %>" required /><br><br>
		
		    <label for="description">Description:</label><br>
		    <textarea id="description" name="description" rows="4" cols="50" required><%= p.getDescription() %></textarea><br><br>
		
		    <input type="submit" value="Update Product" />
		</form>
</body>
</html>