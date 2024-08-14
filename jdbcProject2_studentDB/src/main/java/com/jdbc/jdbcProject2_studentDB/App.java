package com.jdbc.jdbcProject2_studentDB;


public class App 
{
    public static void main( String[] args )
    {
    	StudentService s=new StudentService();
    	//so.addStudent();
    	//s.findStudentById();
//    	s.findStudentByName("Loki");
    	//s.findStudentBetweenAge(25,65);
    	//s.findAllStudent();
    	//s.deleteStudentById(106);
    	//s.updateStudentByAge(10,107);
    	s.deleteStudentByName("uday");
    }
}
