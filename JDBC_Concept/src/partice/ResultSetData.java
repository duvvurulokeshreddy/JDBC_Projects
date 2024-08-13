package partice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetData {
    public static void main(String[] args) {
        final String userName = "root";
        final String userPassword = "root";
        final String url="jdbc:mysql://localhost:3306";
        final String query="select * from jdbconlineclass.jspiders";
        
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection(url, userName, userPassword);
			Statement stmt=conn.createStatement();
			boolean cute = stmt.execute(query);
			ResultSet rs = stmt.getResultSet();
			
			
			
			
			
//			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				int id=rs.getInt("studentId");
				String name=rs.getString("studentName");
				int rating=rs.getInt("studentRating");
				
				System.out.println("Student_Id "+id);
				System.out.println("Student_Name "+name);
				System.out.println("Student_rating "+rating);
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}

