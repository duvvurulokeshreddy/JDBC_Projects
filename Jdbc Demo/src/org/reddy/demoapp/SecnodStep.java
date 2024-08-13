package org.reddy.demoapp;

import java.sql.Connection;
import java.sql.DriverManager;

public class SecnodStep {
	public static void main(String[] args) {
		final String url="jdbc:mysql://localhost:3306";
		final String userName="root";
		final String userPassword="root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,userName,userPassword);
			System.out.println(con);
			System.out.println("Second Step is successfully exceuted ");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	}

