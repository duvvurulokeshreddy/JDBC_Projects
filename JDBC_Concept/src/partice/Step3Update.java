package partice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Step3Update {
	
	public static void main(String[] args) {
		
		final String url="jdbc:mysql://localhost:3306";
		final String userName="root";
		final String userPassword="root";
		
		final String updateQuery ="update jdbconlineclass.jspiders set studentRating=6 where studentId=105 ";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection(url,userName,userPassword);
			Statement stmt=conn.createStatement();
			int update=stmt.executeUpdate(updateQuery);
			System.out.println("Updated Succesfully "+update);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
