package student;
import java.sql.*;
public class PreparedFetch {
	public static void main(String[] args) {
		final String dql="Select * from studentdb.student where studentId=?";
		final String URL="jdbc:mysql://localhost:3306?user=root&password=root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(URL);
			PreparedStatement prs=con.prepareStatement(dql);
			prs.setInt(1,5);
			ResultSet rs=prs.executeQuery();
			System.out.println("Done");
			if(rs.next()) {
				System.out.print(rs.getInt("studentId"));
				System.out.print(rs.getString("studentName"));
				System.out.print(rs.getInt("studentClass"));
				System.out.println(rs.getString("studentSec"));
				//System.out.println("id "+id+" name "+name+" Class "+clas+" Sec "+sec );
			}
			System.out.println("==========");
			prs.setInt(1,3);
			rs=prs.executeQuery();
			
			while(rs.next()) {
				int id=rs.getInt("studentId");
				String name=rs.getString("studentName");
				int clas=rs.getInt("studentClass");
				String sec=rs.getString("studentSec");
				System.out.print("id "+id+" name "+name+" Class "+clas+" Sec "+sec );
				
			}
		}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
