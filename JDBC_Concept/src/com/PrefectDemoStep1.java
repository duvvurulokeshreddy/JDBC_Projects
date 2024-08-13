package com;

import java.io.FileReader;
import java.util.Properties;

public class PrefectDemoStep1 {

	public static void main(String[] args) {
		Properties prop=new Properties();
		try {
			FileReader file =new  FileReader("config/application.properties");
			prop.load(file);
			Class.forName(prop.getProperty("dbDriver"));
			System.out.println("Update");

		}
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
	}
}
