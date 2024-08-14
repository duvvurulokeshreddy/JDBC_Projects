package com.servlet.usiing.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MobileJdbc extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{

		int mobileId= Integer.parseInt(req.getParameter("mobileId"));
		String mobileModel = req.getParameter("mobileModel");
		String mobileBrand = req.getParameter("mobileBrand");
		double mobilePrice= Double.parseDouble(req.getParameter("mobilePrice")); 

		Connection connection=null;
		PreparedStatement ps =null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobilemanagement","root","root");

			ps = connection.prepareStatement
					("insert into mobilemanagement.mobiletable (mobileId,mobileModel,mobileBrand,mobilePrice) values (?,?,?,?)");

			ps.setInt(1, mobileId);
			ps.setString(2, mobileModel);
			ps.setString(3, mobileBrand);
			ps.setDouble(4, mobilePrice);

			boolean execute = ps.execute();
			if(execute) {
				System.out.println("Not inserted records");
			}
			else {
				System.out.println("Inserted records");
			}

		} catch (Exception e) {

			e.printStackTrace();
		}finally {

			try {
				ps.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		resp.sendRedirect("index.jsp");
		
	}

	
}
//mobilemanagement.mobiletable
