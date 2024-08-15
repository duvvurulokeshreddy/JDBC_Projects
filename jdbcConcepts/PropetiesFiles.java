package jdbcConcepts;

import java.io.FileReader;
import java.util.Properties;

public class PropetiesFiles {
	
	public static void main(String[] args) {
		Properties p=new Properties();
		try {
			FileReader reader=new FileReader("config/application.properties");
			p.load(reader);
			String userName=p.getProperty("userName");
			System.out.println("The User_Name is : "+userName);
			String password=p.getProperty("password");
			System.out.println("The Password of User is : "+password);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
