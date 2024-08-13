package com;

import java.io.FileReader;
import java.util.Properties;

public class Demo {

	public static void main(String[] args) {

		Properties properties=new Properties();

		try {
			FileReader reader=new FileReader("config/application.properties");
			properties.load(reader);
			String userName=properties.getProperty("userName");
			System.out.println("UserName : "+userName);
			String password=properties.getProperty("password");
			System.out.println("Password : "+password);
			System.out.println();
			Class.forName(properties.getProperty("dbDriver"));
			System.out.println("The Updated Sucess");
		}
		catch (Exception e) {
			e.printStackTrace();
		}


	}

}
