package jdbcConcepts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdatePreparedStmt {

	public static void main(String[] args) {
		final String url="jdbc:mysql://localhost:3306";
		final String userName="root";
		final String userPassword="root";

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter The New StudentName");
		String name=sc.nextLine();
		System.out.println("Enter The StudentId");
		int id=sc.nextInt();
		final String updateQuery = "UPDATE jdbcconcepts.studentinformation SET studentName=? where studentId=? ";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection(url, userName, userPassword);
			PreparedStatement stmt=conn.prepareStatement(updateQuery);
			stmt.setString(1, name);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			System.out.println("Updated successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		sc.close();
	}

}
