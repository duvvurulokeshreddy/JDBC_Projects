package org.lokesh.registering;

import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;


class UsingRegisterDriver {
	public static void main(String[] args) {
		OracleDriver driver=new OracleDriver();
		try {
			DriverManager.registerDriver(driver);
			System.out.println("Successfully registered the driver");
		}
		catch(SQLException e) {
			
			e.printStackTrace();
		}
		

	}
}
