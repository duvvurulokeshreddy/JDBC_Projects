package org.lokesh.registering;

import  java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadingPropertiesFile {
	public static void main(String[] args) {
		try {
			FileReader reader=new FileReader("config/app.properties");
			Properties props=new Properties();
			props.load(reader);
			String driver =props.getProperty("driver");
			Class.forName(driver);
			System.out.println("Successfully loaded and register the MySQL Driver");
		}
		catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
