package jdbcConcepts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateStmt {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter The studentName: ");
        String name = sc.nextLine();
        System.out.println("Enter The studentId: ");
        int id = sc.nextInt();
        
        final String url = "jdbc:mysql://localhost:3306";
        final String userName = "root";
        final String userPassword = "root";
        final String updateQuery = "UPDATE jdbcconcepts.studentinformation SET studentName = '" + name + "' WHERE studentId = " + id;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, userName, userPassword);
            Statement stmt = conn.createStatement();
            int rowsAffected = stmt.executeUpdate(updateQuery);
            System.out.println(rowsAffected + " row(s) updated successfully");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
