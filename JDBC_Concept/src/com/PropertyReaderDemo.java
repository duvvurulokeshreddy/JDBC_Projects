package com;

import java.io.FileReader;
import java.util.Properties;

public class PropertyReaderDemo {
	
	public static void main(String[] args) {
		Properties properties=new Properties();
		
		try {
			FileReader reader=new FileReader("config/application.properties");
			properties.load(reader);
			String userName=properties.getProperty("userName");
			System.out.println("The Name Of The User Is : "+userName);
			String password=properties.getProperty("password");
			System.out.println("The Password of the User Is : "+password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
