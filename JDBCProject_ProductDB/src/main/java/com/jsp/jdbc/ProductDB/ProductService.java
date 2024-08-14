package com.jsp.jdbc.ProductDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

public class ProductService {
	
    public static Connection config() {
    	Connection connection=null;
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdbjdbc","root","root");
    	}
    		catch (Exception e) {
				e.printStackTrace();
		 }
    	return connection;
    }
    public  boolean addProduct() {
    	if(config()!=null) {
    		try {
    			PreparedStatement preparedStatement=config().prepareStatement("insert into  projectdbjdbc.productdb values(?,?,?,?)");
    			Scanner sc=new Scanner(System.in);
    			System.out.println("Enter The productId");
    			preparedStatement.setInt(1, sc.nextInt());
    			System.out.println("Enter The productName");
    			preparedStatement.setString(2, sc.next());
    			System.out.println("Enter the Brand");
    			preparedStatement.setString(3, sc.next());
    			System.out.println("Enter the productPrice");
    			preparedStatement.setInt(4,sc.nextInt());
    			System.out.println("Data Inserted Successfully");
    			sc.close();
    			return preparedStatement.execute();
    			
    		}
    		catch (Exception e) {
				e.printStackTrace();
			}
    	}
    	return true;
    }
    public boolean findProductId() {
    	try {
        	PreparedStatement preparedStatement=config().prepareStatement("select * from  projectdbjdbc.productdb where productId=? ");
        	Scanner sc=new Scanner(System.in);
        	System.out.println("Enter The productName");
        	preparedStatement.setString(1,sc.next());
        	ResultSet resultSet = preparedStatement.executeQuery();
        	while(resultSet.next()) {
        		System.out.println("ProductId :"+resultSet.getInt("productId"));
        		System.out.println("ProductName :"+resultSet.getString("productName"));
        		System.out.println("ProductBrand :"+resultSet.getString("productBrand"));
        		System.out.println("ProductPrice :"+resultSet.getInt("productPrice"));
        		sc.close();
        	}
        	}
        	catch (Exception e) {
    			e.printStackTrace();
    		}
        	return false;
    	
    }
    
    public boolean findByName() {
    	try {
        	PreparedStatement preparedStatement=config().prepareStatement("select * from  projectdbjdbc.productdb where productName=? ");
        	Scanner sc=new Scanner(System.in);
        	System.out.println("Enter The productName");
        	preparedStatement.setString(1,sc.next());
        	ResultSet resultSet = preparedStatement.executeQuery();
        	while(resultSet.next()) {
        		System.out.println("ProductId :"+resultSet.getInt("productId"));
        		System.out.println("ProductName :"+resultSet.getString("productName"));
        		System.out.println("ProductBrand :"+resultSet.getString("productBrand"));
        		System.out.println("ProductPrice :"+resultSet.getInt("productPrice"));
        		sc.close();
        	}
        	}
        	catch (Exception e) {
    			e.printStackTrace();
    		}
    	
        	return true;
    }
    
    public boolean BetweenPrices(int x ,int y) {
    	try {
    		Connection connection = config();
    		Statement statement = connection.createStatement();
    		ResultSet rs = statement.executeQuery("select * from projectdbjdbc.productdb where productPrice between "+x +" And " +y);
    		while(rs.next()) {
    			int productId = rs.getInt("productId");
    			String productName=rs.getString("productName");
    			String productBrand=rs.getString("productBrand");
    			int productPrice=rs.getInt("productPrice");
    			System.out.println("ProductId : "+productId+" ProductName : "+productName+" productBrand : "+productBrand+" productPrice : "+productPrice);
    		}
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	return false;
    }
    
    public boolean updateProductPriceById(int productPrice ,int productId) {
    	try {
    		Connection connection=config();
    		Statement statement=connection.createStatement();
    		int rs=statement.executeUpdate("UPDATE projectdbjdbc.productdb SET productPrice = "+productPrice+" WHERE productId = "+productId);
    		System.out.println("Product Is Updated"+rs);
    	}
    	catch (Exception e) {
			e.printStackTrace();
		}
    	return false;
    }
    
    public boolean deleteProductById(int productId) {
    	try {
    		Connection con=config();
    		Statement statement = con.createStatement();
    		int rs=statement.executeUpdate("Delete from projectdbjdbc.productdb where productId= "+productId);
    		System.out.println("Product is Deleted"+rs);
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	return false;
    }
    
    public boolean findAllProduct() {
    	try {
    		Connection connection=config();
    		Statement statement=connection.createStatement();
    		ResultSet resultSet = statement.executeQuery("Select * from projectdbjdbc.productdb");
    		while(resultSet.next()) {
    			System.out.println("ProductId :"+resultSet.getInt("productId"));
        		System.out.println("ProductName :"+resultSet.getString("productName"));
        		System.out.println("ProductBrand :"+resultSet.getString("productBrand"));
        		System.out.println("ProductPrice :"+resultSet.getInt("productPrice"));
    		}
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	return false;
    }
    
     public boolean productByName(String productName) {
    	 try {
    	 Connection con=config();
    	 Statement stmt=con.createStatement();
    	 int rs=stmt.executeUpdate("Delete from projectdbjdbc.productdb where productName = '"+productName+"'");
 		System.out.println("Product is Deleted"+rs);
 		
    	 }
    	 catch(Exception e) {
    		 e.printStackTrace();
    	 }
    	return false;
     }
}
