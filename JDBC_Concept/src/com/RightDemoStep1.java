package com;

public class RightDemoStep1 {
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Updated Sucessfully !!!");
		} 
			catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	}