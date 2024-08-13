package partice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetSubQuery {

    public static void main(String[] args) {
        final String query = "SELECT * FROM jdbconlineclass.jspiders WHERE studentRating > " +
                             "(SELECT studentRating FROM jdbconlineclass.jspiders WHERE studentName = 'Rahul')";
        final String url = "jdbc:mysql://localhost:3306/jdbconlineclass";
        final String userName = "root";
        final String userPassword = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(url, userName, userPassword);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
            	int id=rs.getInt("studentId");
				String name=rs.getString("studentName");
				int rating=rs.getInt("studentRating");
				System.out.println("Student Details ");
				System.out.println("Student_Id "+id);
				System.out.println("Student_Name "+name);
				System.out.println("Student_rating "+rating);
				System.out.println();
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


