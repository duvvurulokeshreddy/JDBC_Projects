package com;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class CallableStatementDelete {
	
	public static void main(String[] args) {
		
		final String url="jdbc:mysql://localhost:3306/luckymanjdbcrev";
		final String userName="root";
		final String password="root";
		Connection connection=null;
		CallableStatement statement=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,userName,password);
			statement=connection.prepareCall("call deleteSuperMan (?)");
			statement.setInt(1,2);
			boolean rs=statement.execute();
			if(rs==false) {
				System.out.println("Data Deleted Sucessfully ");
			}
			else {
				System.out.println("Data Not deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(statement!=null && connection!=null) {
				try {
				statement.close();
				connection.close();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/*
	 * CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteSuperMan`(IN p_superId INT)
BEGIN
    DELETE FROM superman WHERE superId = p_superId;
END
	 */
}
