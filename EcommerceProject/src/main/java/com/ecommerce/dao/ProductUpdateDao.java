package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ecommerce.bean.Product;

public class ProductUpdateDao {

	public Product showProduct(Product p) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");//load driver
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_db", "root", "root");//connect database
		PreparedStatement pst = con.prepareStatement("SELECT * from products WHERE id=?");
		pst.setInt(1, p.getId());
		
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			p.setName(rs.getString(2));
			p.setPrice(rs.getDouble(3));
			p.setImage(rs.getString(4));
			p.setDescription(rs.getString(5));
			
			
		}
		return p;
		
	}
}
