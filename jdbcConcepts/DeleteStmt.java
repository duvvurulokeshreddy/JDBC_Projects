package jdbcConcepts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteStmt {
	
	public static void main(String[] args) {
		final String url="jdbc:mysql://localhost:3306";
		final String userName="root";
		final String userPassword="root";
	
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the studentId : ");
		int id=sc.nextInt();
		
		final String dqlQuery="delete from jdbcconcepts.studentinformation where studentId= "+id;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection(url, userName, userPassword);
			Statement stmt=conn.createStatement();
			int rs=stmt.executeUpdate(dqlQuery);
			System.out.println(rs+"Delete Sucessfully");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		sc.close();
	}

}
