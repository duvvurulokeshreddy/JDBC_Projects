package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class SearchSuperDemo {
	
	 void searchSuper(int superId) {
			final String Query="select * from  luckymanjdbcrev.superman where superId="+superId;
			final String url="jdbc:mysql://localhost:3306?user=root&password=root";

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection=DriverManager.getConnection(url);
				Statement statement=connection.createStatement();
				ResultSet set=statement.executeQuery(Query);
				if(set.next()) {
					String name=set.getString("superName");
					int age=set.getInt("superAge");
					String place=set.getString("superPlace");
					System.out.println("Name : "+name);
					System.out.println("Age : "+age);
					System.out.println("Place : "+place);
				}
				else {
					System.out.println("Data Not inserted ");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	 public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter The SuperId ");
		int superId=scanner.nextInt();
		SearchSuperDemo demo=new SearchSuperDemo();
		demo.searchSuper(superId);
		scanner.close();
	}
}
