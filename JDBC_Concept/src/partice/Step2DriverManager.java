package partice;

import java.sql.Connection;
import java.sql.DriverManager;

public class Step2DriverManager {
	
	public static void main(String[] args) {
		
		final String url="jdbc:mysql://localhost:3306";
		final String userName="root";
		final String userPassword="root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection(url,userName,userPassword);
			System.out.println("Step2 Executed Succesfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
