package org.reddy.demoapp;

import java.sql.*;


public class MultipleDataBase {
	public void displayAllData(){
		final String Query="Select * from jdbc.kijy";
		final String userName="root";
		final String userPassword="root";
		final String url="jdbc:mysql://localhost:3306";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,userName,userPassword);
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(Query);
			
			while(rs.next()) {
				int id=rs.getInt("etId");
				String name=rs.getString("etName");
				int sal=rs.getInt("etSal");
				String dept=rs.getString("etDept");
				System.out.println("Enter the All DataBase From a Table");
				System.out.println("Id: "+id+" Name: "+name+" Sal: "+sal+" Dept: "+dept);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		MultipleDataBase m=new MultipleDataBase();
		m.displayAllData();
	}

}
