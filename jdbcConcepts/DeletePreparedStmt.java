package jdbcConcepts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeletePreparedStmt {
	
	public static void main(String[] args) {
		
		final String url="jdbc:mysql://localhost:3306";
		final String userName="root";
		final String userPassword="root";

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter The StudentId");
		int id=sc.nextInt();
		final String updateQuery = "delete from jdbcconcepts.studentinformation where studentId=?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection(url, userName, userPassword);
			PreparedStatement stmt=conn.prepareStatement(updateQuery);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			System.out.println("Deleted successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		sc.close();
	}

}
