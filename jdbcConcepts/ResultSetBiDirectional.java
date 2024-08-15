package jdbcConcepts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetBiDirectional {
	
	public static void main(String[] args) {
		

		final String url="jdbc:mysql://localhost:3306";
		final String userName="root";
		final String userPassword="root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection(url, userName, userPassword);
			Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=stmt.executeQuery("select * from jdbcconcepts.studentinformation");
			rs.afterLast();        
			while (rs.previous()) {
			    int id = rs.getInt("studentId"); 
			    String name = rs.getString("studentName"); 
			    int phoneNumber = rs.getInt("studentPhoneNumber"); 
			    String address = rs.getString("studentAddress");
			    System.out.println("Id: " + id + " Name: " + name + " PhoneNumber: " + phoneNumber + " Address: " + address);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
