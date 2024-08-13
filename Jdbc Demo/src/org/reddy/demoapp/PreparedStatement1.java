package org.reddy.demoapp;

import java.sql.DriverManager;
import java.sql.*;
public class PreparedStatement1 {
	public static void main(String[] args) {
		String Query="Insert into jdbc.kijy (etId,etName,etSal,etDept) values(?,?,?,?)";
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			PreparedStatement prs=con.prepareStatement(Query);
			prs.setInt(1,6);
			prs.setString(2,"Anju");
			prs.setInt(3, 67);
			prs.setString(4, "ASD");
			prs.executeUpdate();
			System.out.println("Data Inserted Sucessfully ");
			prs.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			System.out.println("Hiiiiiiiiiiii Friends Code Executed Sucessfully ");
		}
	}
}
