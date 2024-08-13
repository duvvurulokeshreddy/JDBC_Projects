package com;

import java.sql.*;


public class BidirectionalResultSet {
	
	public static void main(String[] args) {
		
		final String url="jdbc:mysql://localhost:3306";
		final String userName="root";
		final String password="root";
		final String query="select * from luckymanjdbcrev.superman";
		Connection connection=null;
		Statement statement=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,userName,password);
			statement=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=statement.executeQuery(query);
			rs.afterLast();
			while(rs.previous()) {
				int id=rs.getInt("superId");
				String name=rs.getString("superName");
				int age=rs.getInt("superAge");
				String place=rs.getString("superPlace");
				System.out.println("The superId    : "+id);
				System.out.println("The superName  : "+name);
				System.out.println("The superAge   : "+age);
				System.out.println("The superPlace : "+place);
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			if(statement!=null && connection !=null) {
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
