package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ecommerce.bean.Product;

public class ProductUpdateDataDao {

	public boolean updateProduct(Product p) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");//load driver
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_db", "root", "root");//connect database
		PreparedStatement pst = con.prepareStatement("UPDATE products SET name=?,price=?,image=?,description=? WHERE id=?");
		pst.setString(1, p.getName());
		pst.setDouble(2, p.getPrice());
		pst.setString(3, p.getImage());
		pst.setString(4, p.getDescription());
		pst.setInt(5, p.getId());
		
		int result = pst.executeUpdate();
		if(result>0) {
			System.out.println("suceessful");
			return true;
		}else {
			System.out.println("not suceessful");
			return false;
		}
		
	}
}
