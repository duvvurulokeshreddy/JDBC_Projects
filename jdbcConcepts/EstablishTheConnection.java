package jdbcConcepts;

import java.sql.Connection;
import java.sql.DriverManager;

public class EstablishTheConnection {
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Step 1 is loaded");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcconcepts","root", "root");
			System.out.println("Step 2 is loaded");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
