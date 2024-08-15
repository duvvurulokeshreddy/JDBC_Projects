package jdbcConcepts;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class CallableStmtUpdate {

	public static void main(String[] args) {
		final String url="jdbc:mysql://localhost:3306/jdbcconcepts";
		final String userName="root";
		final String password="root";
		Connection conn=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(url, userName, password);
			CallableStatement statement=conn.prepareCall("call studentUpdate(?,?)");
			statement.setInt(1, 106);
			statement.setString(2, "Anju");
			boolean result=statement.execute();
			if(result==false) {
				System.out.println("Data Updated Sucessfully");
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
	 CREATE DEFINER=`root`@`localhost` PROCEDURE `studentUpdate`(IN p_studentId INT, IN p_studentName VARCHAR(45))
			BEGIN
			    UPDATE studentinformation
			    SET studentName = p_studentName
			    WHERE studentId = p_studentId;
			END
	*/
}
