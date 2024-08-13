package partice;

import java.sql.Connection;
import java.sql.*;


public class Step3Delete {
	
	public static void main(String[] args) {
		
		final String userName="root";
		final String userPassword="root";
		final String url="jdbc:mysql://localhost:3306";
		final String deleteQuery="delete from jdbconlineclass.jspiders where studentId=104";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection(url, userName, userPassword);
			Statement stmt=conn.createStatement();
			int delete=stmt.executeUpdate(deleteQuery);
			System.out.println("Deleted Sucessfully "+delete);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
