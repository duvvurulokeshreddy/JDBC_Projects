package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdatedSuperManStep3AndStep4 {
	
	public static void main(String[] args) {
		final String userName="root";
		final String password="root";
		final String url="jdbc:mysql://localhost:3306";
		final String updateQuery="update luckymanjdbcrev.superman set superPlace='Naidupeta' where superId=1";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,userName, password);
			Statement statement=con.createStatement();
			int query=statement.executeUpdate(updateQuery);
			System.out.println("Data Inserted Sucessfully "+query);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
