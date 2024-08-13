package org.reddy.demoapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Step3AndStep4 { 
	//we are insert the data 
	//jdbc is a database name
	//kijy is a table name

	public static void main(String[] args) {
		final String dml="Insert into jdbc.kijy values(3,'sdda',567,'junior')";
		final String userName="root";
		final String userPassword="root";
		final String url="jdbc:mysql://localhost:3306";
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,userName,userPassword);
		Statement stmt=con.createStatement();
		int n=stmt.executeUpdate(dml);
		System.out.println(n+"Add Successfully");
		stmt.close();
		con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
