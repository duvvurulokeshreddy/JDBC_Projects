package com;

import java.sql.Connection;
import java.sql.DriverManager;

public class SecondStep {

	public static void main(String[] args) {
		final String userName="root";
		final String password="root";
		final String url="jdbc:mysql://localhost:3306";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection(url,userName,password);
			System.out.println("Connection Sucessfully");
			System.out.println(conn+userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
