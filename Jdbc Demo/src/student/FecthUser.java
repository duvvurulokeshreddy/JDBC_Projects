package student;
import java.sql.DriverManager;
import java.util.*;
import java.sql.*;
public class FecthUser {
	public void fecth(int eid) {
		final String dql="SELECT * FROM studentdb.student where studentId = "+eid;
		final String URL="jdbc:mysql://localhost:3306?user=root&password=root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(URL);
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(dql);
			if(rs.next()) 
			{
				int id=rs.getInt("studentId");
				String name=rs.getString("studentName");
				int clas=rs.getInt("studentClass");
				String sec=rs.getString("studentSec");
				System.out.println(" Id "+id+" "+"Name "+name+" "+"Class"+clas+" "+"Sec"+sec);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the eId");
		int eid=sc.nextInt();
		new FecthUser().fecth(eid);
		sc.close();
	}

}
