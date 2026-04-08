package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ecommerce.bean.User;

public class EcommerceLoginDao {

public boolean login(User u) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");//load driver
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_db", "root", "root");//connect database
		PreparedStatement pst = con.prepareStatement("select * from users WHERE email=? AND password=? ");
		pst.setString(1, u.getEmail());
		pst.setString(2, u.getPassword());
		
		ResultSet rs = pst.executeQuery();
		
		if(rs.next()) {
			
			String name=rs.getString("name");
			u.setName(name);
			u.setId(rs.getInt("id"));
			
			return true;
		}
		return false;
	}
}
