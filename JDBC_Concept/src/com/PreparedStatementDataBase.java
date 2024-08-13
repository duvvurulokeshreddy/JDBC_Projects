package com;

import java.sql.*;

public class PreparedStatementDataBase {

	public static void main(String[] args) {
		final String url="jdbc:mysql://localhost:3306";
		final String userName="root";
		final String password="root";
		final String query="select * from luckymanjdbcrev.superman where superId=?";
		Connection connection=null;
		PreparedStatement statement=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,userName,password);
			statement=connection.prepareStatement(query);
			int superId = 4; 
			if (superId >= 1 && superId <= 8) {
			    statement.setInt(1, superId);
			    ResultSet rs = statement.executeQuery();
			    System.out.println("List Of Employee Belong To superId : ");
			    System.out.println();
			    while (rs.next()) {
			        int id = rs.getInt("superId");
			        String name = rs.getString("superName");
			        int age = rs.getInt("superAge");
			        String place = rs.getString("superPlace");
			        System.out.println("superId is    :	" + id);
			        System.out.println("superName is  : " + name);
			        System.out.println("superAge is   : " + age);
			        System.out.println("superPlace is : " + place);
			    }
			} else {
			    System.out.println("Error: superId should be between 1 and 8.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
