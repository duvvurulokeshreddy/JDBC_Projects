package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SearchSuperManDemo {

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
			statement=connection.createStatement();
			ResultSet rs=statement.executeQuery(query);
			while(rs.next()){
				int id=rs.getInt("superId");
				String name=rs.getString("superName");
				int age=rs.getInt("superAge");
				String place=rs.getString("superPlace");
				System.out.println("superId    : "+id);
				System.out.println("superName  : "+name);
				System.out.println("superAge   : "+age);
				System.out.println("superPlace : "+place);
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if(statement!=null && connection!=null){
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

}
