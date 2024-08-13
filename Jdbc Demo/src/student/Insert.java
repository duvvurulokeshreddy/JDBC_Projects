package student;

import java.sql.*;
public class Insert {
	public static void main(String[] args) {
		String dmlQuery="update studentdb.student set studentSec='C' where studentName='Jerry'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			Statement stmt=con.createStatement();
			int n=stmt.executeUpdate(dmlQuery);
			System.out.println(n+"inserted");	
			stmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
