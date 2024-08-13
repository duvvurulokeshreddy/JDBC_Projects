package org.reddy.demoapp;
import java.lang.*;
public class LoadDemo {
public static void main(String[] args) {
	try {
		Class.forName("org.reddy.demoapp.Stu");
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}
}
