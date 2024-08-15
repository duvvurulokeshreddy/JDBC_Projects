package jdbcConcepts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class InsertStmt {
    public static void main(String[] args) {
        final String userName = "root";
        final String userPassword = "root";
        final String url = "jdbc:mysql://localhost:3306/jdbcconcepts"; // added database name
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter Student Name: ");
        String name = scanner.next();
        System.out.print("Enter Student Phone Number: ");
        int phone = scanner.nextInt();
        System.out.print("Enter Student Address: ");
        String address = scanner.next();
        
        final String insertQuery = "INSERT INTO studentinformation VALUES (" + id + ", '" + name + "', " + phone + ", '" + address + "')";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, userName, userPassword);
            Statement stmt = conn.createStatement();
            int rs = stmt.executeUpdate(insertQuery);
            System.out.println(rs + " row(s) inserted successfully");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
