package partice;

import java.io.FileReader;
import java.util.Properties;

public class PerfectDemo {
	
	public static void main(String[] args) {
		Properties properties=new Properties();
		
		try {
			FileReader reader=new FileReader("config/application.properties");
			properties.load(reader);
			String driver=properties.getProperty("driver");
			Class.forName(driver);
			System.out.println("Successfully loaded and register");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
