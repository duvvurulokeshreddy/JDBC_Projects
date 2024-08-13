package org.reddy.demoapp;

import java.sql.*;

public class FowardDirection {
	
	public static void main(String[] args) {
		Connection connection=null;
		Statement stm=null;
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			final String url="jdbc:mysql://localhost:3306?user=root&password=root";
			Connection con=DriverManager.getConnection(url);
			Statement stmt=con.createStatement();
			String query="select * from jdbc.kijy";
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				int id=rs.getInt("etId");
				String name=rs.getString("etName");
				int sal=rs.getInt("etSal");
				String dept=rs.getString("etDept");
				System.out.println("Id "+id+" Name "+name+" Sal "+sal+" Dept "+dept);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(stm!=null && connection!=null) {
				try {
					stm.close();
					connection.close();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}

