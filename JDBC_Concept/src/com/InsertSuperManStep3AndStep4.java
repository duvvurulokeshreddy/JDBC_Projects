package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertSuperManStep3AndStep4 {

	public static void main(String[] args) {
		final String userName="root";
		final String password="root";
		final String url="jdbc:mysql://localhost:3306";
		final String insertQuery="insert into luckymanjdbcrev.superman values(4,'Sai',38,'Kurnool')";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,password,userName);
			Statement statement=con.createStatement();
			int query=statement.executeUpdate(insertQuery);
			System.out.println("Data Inserted Sucessfully "+query);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
