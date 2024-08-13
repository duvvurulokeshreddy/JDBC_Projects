package org.all5steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class FetchUser {
	public static void main(String[] args) {
		//step 1 : loading and Regestering
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//step 2: establishing the connection
			String dbURL ="jdbc:mysql://localhost:3306/userdb?user=root&password=root";
			Connection connection =  DriverManager.getConnection(dbURL);
			
			//step 3: Creating the Statment and Executing the query
			Statement statemant = connection.createStatement();
			//execute the query
			String query = "select * from users";
			
			ResultSet resultset =statemant.executeQuery(query);
			
			//step 4: Process the data
			while(resultset.next()) {
				String id = resultset.getString("userId");
				String name = resultset.getString("userName");
				String email = resultset.getString("userEmail");
				
				System .out.println("userId: "+ id +", userName: "+ name + ",userEmail "+ email);
			
	}

}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
