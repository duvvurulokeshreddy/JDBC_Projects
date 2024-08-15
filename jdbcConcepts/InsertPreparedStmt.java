package jdbcConcepts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertPreparedStmt {
    
    public static void main(String[] args) {
        final String url = "jdbc:mysql://localhost:3306";
        final String userName = "root";
        final String userPassword = "root";
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the StudentId: ");
        int studentId = sc.nextInt();
        sc.nextLine();  
        System.out.println("Enter the StudentName: ");
        String studentName = sc.nextLine();
        System.out.println("Enter the StudentPhoneNumber: ");
        int studentPhoneNumber = sc.nextInt();
        sc.nextLine(); 
        System.out.println("Enter the StudentAddress: ");
        String studentAddress = sc.nextLine();
        
        final String query = "INSERT INTO jdbcconcepts.studentinformation(studentId, studentName, studentPhoneNumber, studentAddress) VALUES(?, ?, ?, ?)";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, userName, userPassword);
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, studentId);
            stmt.setString(2, studentName);
            stmt.setInt(3, studentPhoneNumber);
            stmt.setString(4, studentAddress);
            stmt.executeUpdate();
            System.out.println("Data inserted successfully");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
