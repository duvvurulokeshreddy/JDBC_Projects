package com;

import java.sql.*;

public class PreparedStatementUpdate {
	
	public static void main(String[] args) {
		
		final String url="jdbc:mysql://localhost:3306";
		final String userName="root";
		final String password="root";
		final String queryes="update luckymanjdbcrev.superman set superPlace=? where superId=?";
		Connection connection=null;
		PreparedStatement statement=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,userName,password);
			statement=connection.prepareStatement(queryes);
			statement.setString(1, "Kurnool City");
			statement.setInt(2, 8);
			statement.executeUpdate();
			System.out.println("Data Sucess");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(connection!=null) {
				try {
				connection.close();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
