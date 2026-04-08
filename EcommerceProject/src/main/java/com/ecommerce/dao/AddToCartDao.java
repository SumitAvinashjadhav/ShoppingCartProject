package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ecommerce.bean.Cart;
import com.ecommerce.bean.CartItem;
import com.ecommerce.bean.Product;

public class AddToCartDao {

	
	
     public boolean checkCart(CartItem p) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");//load driver
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_db", "root", "root");//connect database
		PreparedStatement pst = con.prepareStatement("select * from cart_items where product_id=? and user_id=?");
		pst.setInt(1, p.getProductId());
		pst.setInt(2, p.getUserId());
	
		
		
		ResultSet result=pst.executeQuery();
		
		if(result.next()) {
			p.setQuantity(result.getInt("quantity"));
			return true;
		}
		return false;
		
	}
	public boolean AddToCart(CartItem p) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");//load driver
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_db", "root", "root");//connect database
		PreparedStatement pst = con.prepareStatement("insert into cart_items(product_Id,user_Id,quantity) values(?,?,?)");
		pst.setInt(1, p.getProductId());
		pst.setInt(2, p.getUserId());
		pst.setInt(3, p.getQuantity());
		
		
		int result=pst.executeUpdate();
		
		if(result>0) {
			return true;
		}
		return false;
		
	}
	
	public boolean updateCart(CartItem p) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");//load driver
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_db", "root", "root");//connect database
		PreparedStatement pst = con.prepareStatement("update cart_items set quantity=? where product_id=? and user_id=?");
		pst.setInt(1, p.getQuantity()+1);
		pst.setInt(2, p.getProductId());
		pst.setInt(3, p.getUserId());
				
		int result=pst.executeUpdate();
		
		if(result>0) {
			return true;
		}
		return false;
		
	}


	public ArrayList<Cart> showCart(CartItem p) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");//load driver
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_db", "root", "root");//connect database
		PreparedStatement pst = con.prepareStatement("select products.id,name,price,image,quantity from products inner join cart_items on products.id=cart_items.product_id where user_id=?");
		pst.setInt(1, p.getUserId());
		
		ResultSet rs=pst.executeQuery();
		
		ArrayList<Cart> list=new ArrayList<Cart>();
		
		while(rs.next()) {
			list.add(new Cart(
					rs.getInt(1),
					rs.getString(2),
					rs.getDouble(3),
					rs.getString(4),
					rs.getInt(5)));
		}
		return list;
		
	}

		

	
}
