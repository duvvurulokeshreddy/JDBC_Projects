package jdbcConcepts;

public class ForNameMethod {
	
	public static void main(String[] args) {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Loading The forName Method");
		}
		catch(Exception e) {
			e.getMessage();
		}
	}

}
