package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ecommerce.bean.CartItem;

public class removeFromCart {

	public boolean removeCart(CartItem c) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");//load driver
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_db", "root", "root");//connect database
		PreparedStatement pst = con.prepareStatement("DELETE FROM cart_items WHERE product_id = ? AND user_id = ?");
		pst.setInt(1, c.getProductId());
		pst.setInt(2, c.getUserId());
				
		int result=pst.executeUpdate();
		
		if(result>0) {
			return true;
		}
		return false;
	}
	

}
