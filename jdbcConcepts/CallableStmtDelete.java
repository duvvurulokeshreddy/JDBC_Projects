package jdbcConcepts;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class CallableStmtDelete {
	public static void main(String[] args) {
		final String url="jdbc:mysql://localhost:3306/jdbcconcepts";
		final String userName="root";
		final String password="root";
		Connection conn=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(url, userName, password);
			CallableStatement statement=conn.prepareCall("call studentDelete(?)");
			statement.setInt(1, 108);
			boolean result=statement.execute();
			if(result==false) {
				System.out.println("Data Deleted Sucessfully");
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
	 * CREATE DEFINER=`root`@`localhost` PROCEDURE `studentDelete`(IN p_studentId INT)
BEGIN
    DELETE FROM studentinformation WHERE studentId = p_studentId;
END
	 */

}
