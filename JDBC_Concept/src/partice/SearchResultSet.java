package partice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SearchResultSet {

	public boolean searchQuery(int studentId) {
		final String url="jdbc:mysql://localhost:3306";
		final String userName="root";
		final String userPassword="root";
		final String query="select * from jdbconlineclass.jspiders where studentId="+studentId;
		boolean recordFound = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection(url, userName, userPassword);
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				int id=rs.getInt("studentId");
				String name=rs.getString("studentName");
				int rating=rs.getInt("studentRating");
				System.out.println("Student Details ");
				System.out.println("Student_Id "+id);
				System.out.println("Student_Name "+name);
				System.out.println("Student_rating "+rating);
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return recordFound;
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter The StudentId ");
		int stId=sc.nextInt();
			SearchResultSet r=new SearchResultSet();
			boolean isPresent=r.searchQuery(stId);
			if(isPresent) {
				System.out.println("Student Record Is Valid ");
			}
			else 
				System.out.println("Student Record is Not Valid ");
	}
}
