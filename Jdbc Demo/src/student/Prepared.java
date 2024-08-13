package student;
import java.sql.*;
public class Prepared {
	public static void main(String[] args) {
		final String dql="insert into studentdb.student(studentId,studentName,studentClass,studentSec)"
				+ "values(?,?,?,?)";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			PreparedStatement prs=con.prepareStatement(dql);
			prs.setInt(1,5);
			prs.setString(2,"Anju");
			prs.setInt(3,5);
			prs.setString(4,"D");
			prs.executeUpdate();
			System.out.println("Inserted");
			
			con.close();
			prs.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
