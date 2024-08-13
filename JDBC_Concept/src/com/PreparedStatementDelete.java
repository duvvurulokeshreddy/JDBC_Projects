package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementDelete {

	public static void main(String[] args) {
		
		final String url="jdbc:mysql://localhost:3306";
		final String userName="root";
		final String password="root";
		final String deleteQuery="delete from luckymanjdbcrev.superman where superId=?";
		Connection connection=null;
		PreparedStatement statement=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,userName,password);
			statement=connection.prepareStatement(deleteQuery);
			statement.setInt(1, 10);
			statement.executeUpdate();
			System.out.println("Data Delete Sucessfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(connection !=null && statement!=null) {
				try {
					connection.close();
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
