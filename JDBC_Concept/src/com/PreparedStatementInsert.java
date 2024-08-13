package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PreparedStatementInsert {
	
	public static void main(String[] args) {
		String insertQuery="Insert into luckymanjdbcrev.superman (superId,superName,superAge,superPlace)values(?,?,?,?)";
		String userName="root";
		String password="root";
		String url="jdbc:mysql://localhost:3306";
		Connection connection=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,userName,password);
			PreparedStatement stmt=connection.prepareStatement(insertQuery);
			stmt.setInt(1,10 );
			stmt.setString(2,"Shiva");
			stmt.setInt(3,67);
			stmt.setString(4,"Guntur");
			stmt.executeUpdate();
			System.out.println("Data inserted Sucessfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(connection!=null) {
				try {
					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
