package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteSuperManStep3AndStep4 {

	public static void main(String[] args) {
		final String userName="root";
		final String password="root";
		final String url="jdbc:mysql://localhost:3306";
		final String dmlQuery="delete from  luckymanjdbcrev.superman where superId=3";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url,userName,password);
			Statement statement=connection.createStatement();
			int query=statement.executeUpdate(dmlQuery);
			System.out.println("Deleted The Data Sucessfully "+query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
