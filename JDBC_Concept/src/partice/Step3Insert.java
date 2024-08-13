package partice;

import java.sql.Connection;
import java.sql.*;

public class Step3Insert {

	public static void main(String[] args) {

		final String url="jdbc:mysql://localhost:3306";
		final String userName="root";
		final String userPassword="root";
		final String insert="insert into jdbconlineclass.jspiders values (105,'Sameer','9.5') ";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection(url,userName,userPassword);
			Statement stmt = conn.createStatement();
			int update = stmt.executeUpdate(insert);
			System.out.println("One Row Is Inserted "+update);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
