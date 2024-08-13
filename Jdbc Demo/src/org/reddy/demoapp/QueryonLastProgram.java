package org.reddy.demoapp;

import java.sql.*;

public class QueryonLastProgram {
	public static void main(String[] args) {
		String Query="Select * from jdbc.kijy where etDept=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			PreparedStatement prs=con.prepareStatement(Query);
			prs.setString(1,"Accounting");
			ResultSet rs=prs.executeQuery();
			System.out.println("List of Employee belong to ASD ");
			while(rs.next()) {
				System.out.println("ID :"+rs.getInt("etId"));
				System.out.println("Name :"+rs.getString("etName"));
				System.out.println("Sal :"+rs.getInt("etSal"));
				System.out.println();
			}
			System.out.println();
			System.out.println("****");
			System.out.println();
			prs.setString(1, "java");
			rs=prs.executeQuery();
				System.out.println("List of et belong to hr department");
				while(rs.next()) {
				System.out.println("ID :"+rs.getInt("etId"));
				System.out.println("Name :"+rs.getString("etName"));
				System.out.println("Sal :"+rs.getInt("etSal"));
				System.out.println();
			}
			prs.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
