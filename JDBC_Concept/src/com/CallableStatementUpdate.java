package com;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CallableStatementUpdate {
	
	public static void main(String[] args) {
		
		final String url="jdbc:mysql://localhost:3306/luckymanjdbcrev";
		final String userName="root";
		final String password="root";
		Connection connection=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,userName,password);
			CallableStatement statement=connection.prepareCall("call updateSupermanPlace(?,?)");
			statement.setInt(1,3);
			statement.setString(2, "Indore");
			boolean rs=statement.execute();
			if(rs==false) {
				System.out.println("Data Enterd Sucessfully");
			}
			else {
				System.out.println("Data is not enterd");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	/*
	 * CREATE DEFINER=`root`@`localhost` PROCEDURE `updateSupermanPlace`(IN p_superId INT, IN p_superPlace VARCHAR(45))
BEGIN
    UPDATE superman
    SET superPlace = p_superPlace
    WHERE superId = p_superId;
END
	 */
}
