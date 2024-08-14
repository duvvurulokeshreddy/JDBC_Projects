package com.jdbc.jdbcProject2_studentDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;



public class StudentService {
	
	 public static Connection config() {
	    	Connection connection=null;
	    	try {
	    		Class.forName("com.mysql.cj.jdbc.Driver");
	    		connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcgrooming","root","root");
	    	}
	    		catch (Exception e) {
					e.printStackTrace();
			 }
	    	return connection;
	    }
		
	
	public boolean addStudent() {
		if(config()!=null)
		try {
			
			PreparedStatement prs=config().prepareStatement("insert into jdbcgrooming.studentpro values(?,?,?,?)");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter The Student Id :");
			prs.setInt(1, sc.nextInt());
			System.out.println("Enter The StudentName");
			prs.setString(2, sc.next());
			System.out.println("Enter The StudentAddress");
			prs.setString(3, sc.next());
			System.out.println("Enter The StudentAge");
			prs.setInt(4, sc.nextInt());
			System.out.println("Data Inserted Successfully");
			prs.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	public boolean findStudentById() {
		if(config()!=null)
		try {
			PreparedStatement prs=config().prepareStatement("select * from jdbcgrooming.studentpro where studentId=? ");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter The studentId");
			prs.setInt(1, sc.nextInt());
			ResultSet rs=prs.executeQuery();
			while(rs.next()) {
				System.out.println("studentId"+rs.getInt("studentId"));
				System.out.println("studentName"+rs.getString("studentName"));
				System.out.println("studentAddress"+rs.getString("studentAddress"));
				System.out.println("studentAge"+rs.getInt("studentAge"));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public void findStudentByName(String studentName) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcgrooming","root","root");
			PreparedStatement prs=con.prepareStatement("select * from jdbcgrooming.studentpro where studentName =?");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter The StudentName");
			prs.setString(1, sc.next());
			ResultSet rs=prs.executeQuery();
			while(rs.next()) {
				System.out.println("studentId"+rs.getInt("studentId"));
				System.out.println("studentName"+rs.getString("studentName"));
				System.out.println("studentAddress"+rs.getString("studentAddress"));
				System.out.println("studentAge"+rs.getInt("studentAge"));	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void findStudentBetweenAge(int x ,int y) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcgrooming","root","root");
			Statement stmt=connection.createStatement();
			ResultSet rs=stmt.executeQuery("select * from jdbcgrooming.studentpro where studentAge between "+x+" And "+y );
			while(rs.next()) {
				System.out.println("studentId : "+rs.getInt("studentId"));
				System.out.println("studentName : "+rs.getString("studentName"));
				System.out.println("studentAddress : "+rs.getString("studentAddress"));
				System.out.println("studentAge : "+rs.getInt("studentAge"));	
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
//-------------------------------- PreapredStatement ------------------------------------------
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcgrooming","root","root");
//			PreparedStatement prs=connection.prepareStatement("select * from jdbcgrooming.studentpro where studentAge Between (?) and (?)");
//			Scanner sc=new Scanner(System.in);
//			System.out.println("Enter The studentAge");
//			prs.setInt(1, sc.nextInt());
//			System.out.println("Enter The Between");
//			prs.setInt(2, sc.nextInt());
//			ResultSet rs=prs.executeQuery();
//			while(rs.next()) {
//				System.out.println("studentId"+rs.getInt("studentId"));
//				System.out.println("studentName"+rs.getString("studentName"));
//				System.out.println("studentAddress"+rs.getString("studentAddress"));
//				System.out.println("studentAge"+rs.getInt("studentAge"));
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
	
	public void updateStudentByAge(int studentAge,int studentId) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcgrooming","root","root");
			Statement stmt=con.createStatement();
			stmt.executeUpdate("UPDATE jdbcgrooming.studentpro SET studentAge = "+ studentAge +" WHERE studentId = "+ studentId);
			System.out.println("Updated Scessfully");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void findAllStudent() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcgrooming","root","root");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("Select * from jdbcgrooming.studentpro ");
			while(rs.next()) {
				System.out.println("studentId : "+rs.getInt("studentId"));
				System.out.println("studentName : "+rs.getString("studentName"));
				System.out.println("studentAddress : "+rs.getString("studentAddress"));
				System.out.println("studentAge : "+rs.getInt("studentAge"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteStudentById(int studentId ) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcgrooming","root","root");
			Statement statement=con.createStatement();
			int rs=statement.executeUpdate("delete from jdbcgrooming.studentpro where studentId ="+studentId);
			System.out.println("Student Is Deleted");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteStudentByName(String studentName) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcgrooming","root","root");
			Statement stmt=con.createStatement();
			int rs=stmt.executeUpdate("delete from jdbcgrooming.studentpro where studentName = '"+studentName+"'");
			System.out.println("Student is deleted");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	
}

























































































//public static Connection config() {
//	Scanner sc=new Scanner(System.in);
//	try {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcgrooming","root","root");
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//	return config();
//}

