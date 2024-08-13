package com;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class SecondStepProperties {

	public static void main(String[] args) {
		final String url="jdbc:mysql://localhost:3306";
		Properties properties=new Properties();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			FileReader file =new  FileReader("config/application.properties");
			properties.load(file);
			Connection conn=DriverManager.getConnection(url,properties);
			System.out.println(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
