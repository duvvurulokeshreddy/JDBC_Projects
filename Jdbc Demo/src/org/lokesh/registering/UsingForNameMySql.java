package org.lokesh.registering;

class UsingForNameMySql {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Successfully registred the MySQL driver");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
