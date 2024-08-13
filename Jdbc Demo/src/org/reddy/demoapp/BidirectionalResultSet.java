package org.reddy.demoapp;

import java.sql.*;

public class BidirectionalResultSet {
	public static void main(String[] args) {
		final String url="jdbc:mysql://localhost:3306";
		final String userName="root";
		final String userPassword="root";
		final String Query="Select * from jdbc.kijy";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,userName,userPassword);
			Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=stmt.executeQuery(Query);
			rs.afterLast();
			while(rs.previous()) {
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
}
}



