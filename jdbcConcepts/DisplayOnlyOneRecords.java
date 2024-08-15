package jdbcConcepts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DisplayOnlyOneRecords {
	
	public static void main(String[] args) {
		
		final String url="jdbc:mysql://localhost:3306";
		final String userName="root";
		final String userPassword="root";
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter The StudentId ");
		int n=sc.nextInt();
		final String query="SELECT * FROM jdbcconcepts.studentinformation where studentId="+n;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection(url, userName, userPassword);
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				int id=rs.getInt("studentId");
				String name=rs.getString("studentName");
				int phone=rs.getInt("studentPhoneNumber");
				String address=rs.getString("studentAddress");
				
				System.out.println("Student Details : ");
				System.out.println("Id : "+id);
				System.out.println("Name : "+name);
				System.out.println("phone : "+phone);
				System.out.println("address : "+address);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		sc.close();
	}

}
