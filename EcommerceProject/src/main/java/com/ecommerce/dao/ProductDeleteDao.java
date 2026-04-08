package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ecommerce.bean.Product;

public class ProductDeleteDao {
	
	public boolean deleteProduct(Product p) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");//load driver
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_db", "root", "root");//connect database
		PreparedStatement pst = con.prepareStatement("Delete from products WHERE id=?");
		pst.setInt(1, p.getId());
		
		int result = pst.executeUpdate();
		if(result>0) {
			return true;
		}
		return false;
	}
}
