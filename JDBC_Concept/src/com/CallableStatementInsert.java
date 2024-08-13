package com;

import java.sql.*;

public class CallableStatementInsert {
	
	public static void main(String[] args) {
		
		final String url="jdbc:mysql://localhost:3306/luckymanjdbcrev";
		final String userName="root";
		final String password="root";
		Connection connection=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,userName,password);
			CallableStatement statement=connection.prepareCall("call superman(?,?,?,?)");
			statement.setInt(1, 9);
			statement.setString(2, "Ramesh");
			statement.setInt(3, 65);
			statement.setString(4, "New York");
			boolean result=statement.execute();
			if(result==false) {
				System.out.println("Data Is Sucessfully Entered");
			}
			else {
				System.out.println("Data Is not Saved");
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
	 * CREATE DEFINER=`root`@`localhost` PROCEDURE `superman`(superId int ,superName varchar(45),superAge int ,superPlace varchar(45))
BEGIN
		insert into superman values(superId,superName,superAge,superPlace);
END
	 */

}
