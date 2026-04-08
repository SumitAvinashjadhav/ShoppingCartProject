package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ecommerce.bean.contact;

public class EcommerceContactDao {

	public boolean insertContact(contact c) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");//load driver
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_db", "root", "root");//connect database
		PreparedStatement pst = con.prepareStatement("INSERT into contact_us(firstname,lastname,email,message) values (?,?,?,?)");
		pst.setString(1, c.getFirstname());
		pst.setString(2, c.getLastname());
		pst.setString(3, c.getEmail());
		pst.setString(4, c.getMessage());
		
		int result = pst.executeUpdate();
		
		if(result > 0) {
			System.out.println("successful");
			return true;
		}
		System.out.println("not successful");
		return false;
	}
}
