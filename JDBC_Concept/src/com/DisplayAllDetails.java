package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DisplayAllDetails {
	
	public void displayDetails() {
		final String userName="root";
		final String password="root";
		final String url="jdbc:mysql://localhost:3306";
		final String query="select * from luckymanjdbcrev.superman ";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection(url,userName,password);
			Statement statement=conn.createStatement();
			ResultSet set=statement.executeQuery(query);
			while(set.next()) {
				int superId=set.getInt("superId");
				String superName=set.getString("superName");
				int superAge=set.getInt("superAge");
				String superPlace=set.getString("superPlace");
				System.out.println("SuperId is : "+superId);
				System.out.println("SuperName is : "+superName);
				System.out.println("SuperAge is : "+superAge);
				System.out.println("SuperPlace is : "+superPlace);
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		DisplayAllDetails d=new DisplayAllDetails();
		d.displayDetails();
	}

}
