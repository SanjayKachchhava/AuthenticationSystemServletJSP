package com.mycompany.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Auth {
	
	public static boolean check(String email,String password) {
		
		try {
			String pswdHash = SHA256Encryption.encrypt(password);
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","root");
			
			String query = "SELECT * FROM users WHERE email=? and pswd=?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, email);
			st.setString(2,pswdHash);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				con.close();
				return true;
			}
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	private static boolean isExist(String email) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","root");
			
			String query = "SELECT * FROM users WHERE email=?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, email);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				con.close();
				return true;
			}
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}

	public static boolean register(String email, String password, String firstname, String lastname) {
		
		if(isExist(email)) return false;
		
		try {
			
			String pswdHash = SHA256Encryption.encrypt(password);
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","root");
			
			String query = "INSERT INTO users VALUES(?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, 0);
			st.setString(2, email);
			st.setString(3,pswdHash);
			st.setString(4,firstname);
			st.setString(5,lastname);
			
			st.execute();
			
			
			return true;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return false;
	}
	
	
}
