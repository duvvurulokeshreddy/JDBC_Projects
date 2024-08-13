package com;

public class LoadingMain {
	
	public static void main(String[] args) {
		try {
		Class.forName("com.Loading");
		System.out.println("Raju");
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
	}

}
