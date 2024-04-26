package com.mypackage;

import java.sql.*;

interface Register {
	boolean registerUser();
}

public class Authenticate {
	public boolean authenticate(String username, String pwd) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_database", "root", "admin");
			String query = "SELECT * FROM user WHERE username = ? AND password = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, username);
			pstmt.setString(2, pwd);
			ResultSet rs = pstmt.executeQuery();
			return rs.next();

		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public boolean registerUser(String us, String pd, String add, String mob, String email) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_database", "root", "admin");
			String query = "INSERT INTO user (username, password, address, mobile, email) VALUES ('" + us + "', '" + pd
					+ "','" + add + "','" + mob + "','" + email + "')";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.executeUpdate();
			System.out.println("User Registraion Successful! ");
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
}
