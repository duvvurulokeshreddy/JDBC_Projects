package partice;

public class ForNameMethod {

	public static void main(String[] args) {
//		System.out.println("Hello");
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Step one Creates Scessfully !!! ");
		}
		catch(Exception e) {
			System.out.println("Data");
		}
	}
}
