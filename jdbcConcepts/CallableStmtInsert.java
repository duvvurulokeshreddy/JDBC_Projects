package jdbcConcepts;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class CallableStmtInsert {

	public static void main(String[] args) {
		final String url="jdbc:mysql://localhost:3306/jdbcconcepts";
		final String userName="root";
		final String password="root";
		Connection conn=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(url, userName, password);
			CallableStatement statement=conn.prepareCall("call student(?,?,?,?)");
			statement.setInt(1, 108);
			statement.setString(2, "Venky");
			statement.setInt(3, 7643146);
			statement.setString(4, "Guntur");
			boolean result=statement.execute();
			if(result==false) {
				System.out.println("Data Inserted Sucessfully");
			}
			else {
				System.out.println("Data Not Generated");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(conn!=null) {
				try {
					conn.close();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/*
	 
	 CREATE DEFINER=`root`@`localhost` PROCEDURE `student`(studentId int ,studentName varchar(45),studentPhoneNumber int ,studentAddress varchar(45))
BEGIN
		insert into studentinformation values(studentId,studentName,studentPhoneNumber,studentAddress);
END
	 
	 */
}
