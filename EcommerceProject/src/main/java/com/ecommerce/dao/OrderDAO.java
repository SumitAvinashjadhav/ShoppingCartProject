package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import com.ecommerce.bean.CartItem;
import com.ecommerce.bean.order;

public class OrderDAO {

public boolean AddToOrder(order p) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");//load driver
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_db", "root", "root");//connect database
		PreparedStatement pst = con.prepareStatement("insert into orders(productId,userId,quantity,date) values(?,?,?,?)");
		pst.setInt(1, p.getProductId());
		pst.setInt(2, p.getUserId());
		pst.setInt(3, p.getQuantity());
		Date d=Date.valueOf(LocalDate.now());
		pst.setDate(4, d);
		
		
		int result=pst.executeUpdate();
		
		if(result>0) {
			return true;
		}
		return false;
		
	}
public boolean emptyCart(CartItem c) throws ClassNotFoundException, SQLException {
	
	Class.forName("com.mysql.cj.jdbc.Driver");//load driver
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_db", "root", "root");//connect database
	PreparedStatement pst = con.prepareStatement("DELETE FROM cart_items WHERE user_id = ?");
	
	pst.setInt(1, c.getUserId());
			
	int result=pst.executeUpdate();
	
	if(result>0) {
		return true;
	}
	return false;
}
}
