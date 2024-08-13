package org.lokesh.registering;

import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;

class UsingForName {
	public static void main(String[] args) {
	Driver driver;
	try {
		driver =new Driver();
		DriverManager.registerDriver(driver);
		System.out.println("Successfully registred the MySQL driver");
	}
	catch(SQLException e) {
	e.printStackTrace();	
	}
	}

}
