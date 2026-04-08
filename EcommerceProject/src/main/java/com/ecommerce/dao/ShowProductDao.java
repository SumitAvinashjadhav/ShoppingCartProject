package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ecommerce.bean.Product;

public class ShowProductDao {

	public ArrayList<Product> getAllproducts(Product p) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");//load driver
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_db", "root", "root");//connect database
		PreparedStatement pst = con.prepareStatement("SELECT * from products");
		ResultSet rs = pst.executeQuery();
		
		ArrayList<Product> arr = new ArrayList<Product>();
		
		while( rs.next() ) {
			
			Product pr = new Product();
			pr.setId(rs.getInt("id"));
			pr.setName(rs.getString("name"));
			pr.setPrice(rs.getDouble("price"));
			pr.setImage(rs.getString("image"));
			pr.setDescription(rs.getString("description"));
			arr.add(pr);
		}
		return arr;
	}
}
