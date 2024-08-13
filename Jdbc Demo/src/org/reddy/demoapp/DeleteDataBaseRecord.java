package org.reddy.demoapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteDataBaseRecord {
	public static void main(String[] args) {
		final String url="jdbc:mysql://localhost:3306";
		final String userName="root";
		final String userPassword="root";
		final String dml="delete from jdbc.kijy where etId=3";
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,userName,userPassword);
		Statement stmt=con.createStatement();
		int n=stmt.executeUpdate(dml);
		System.out.println(n+" is updated scuuessfully ");
		con.close();
		stmt.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
