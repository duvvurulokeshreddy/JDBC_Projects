package org.reddy.demoapp;

import java.util.Scanner;



import java.sql.*;
public class SearchDataBaseDemo {

	public void search(int etId) {
		final String url="jdbc:mysql://localhost:3306";
		final String userName="root";
		final String userPassword="root";
		final String Query="Select * from jdbc.kijy where etId="+etId;
		
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,userName,userPassword);
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(Query);
			
			if(rs.next()) {
				
				String Name=rs.getString("etName");
				int sal=rs.getInt("etSal");
				String dept=rs.getString("etDept");
				System.out.println("Employee DataBase");
				System.out.println("Name "+Name);
				System.out.println("sal "+sal);
				System.out.println("dept "+dept);
				System.out.println("Data Successfully ");
			}
			else {
				System.out.println("No data Present");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the etId");
		int n=sc.nextInt();
		sc.close();
		SearchDataBaseDemo s=new SearchDataBaseDemo();
		s.search(n);
		
	}
	
}
