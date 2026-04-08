package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ecommerce.bean.User;

public class UserDAO {

	public boolean insert(User u) throws ClassNotFoundException, SQLException {
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");//load driver
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_db", "root", "root");//connect database
		PreparedStatement pst = con.prepareStatement("INSERT INTO users (name,email,password) values(?,?,?)");
		pst.setString(1, u.getName());
		pst.setString(2, u.getEmail());
		pst.setString(3, u.getPassword());
		
		int i =pst.executeUpdate();
		if(i>0) {
			System.out.println("succesful");
			return true;
		}else {
			System.out.println("not succesful");
			return false;
		}
	}
	
	
}
