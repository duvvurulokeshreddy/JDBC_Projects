package org.reddy.demoapp;

import java.sql.*;
import java.sql.DriverManager;

public class UpdateDataBase {
	public static void main(String[] args) {
		final String url="jdbc:mysql://localhost:3306";
		final String userName="root";
		final String userPassword="root";
		final String dml="update jdbc.kijy set etName='raju' where etId=3";
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
