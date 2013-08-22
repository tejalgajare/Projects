package group21;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.PrintWriter;
import group21.welcome;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Update_Info
 */
@WebServlet("/Update_Info")
public class Update_Info extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection=null;
	private Statement statement;
	private Statement statement1;
	ResultSet rs;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public Update_Info() {
        super();
        
    }
    /**
     * Method to get the Welcome from the form and output the result
     */
    
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		long phone = Long.parseLong(request.getParameter("phone"));
		
		group21.welcome w=new group21.welcome();
		String username2=w.getUsername();
		
		try
		{
				
			
			Class.forName("oracle.jdbc.OracleDriver");
			connection=DriverManager.getConnection
			("jdbc:oracle:thin:@fourier.cs.iit.edu:1521:orcl","schandak","sayalics425");
		
			statement=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			statement1=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			
			
			ResultSet rs1=statement1.executeQuery("UPDATE REGISTERED_USER SET PHONE="+phone+" where USERNAME ='"+username2+"'");
			
			ResultSet rs2=statement1.executeQuery("Select * from REGISTERED_USER where USERNAME ='"+username2+"'");
			
				out.println();
			   out.println("<Table border=\"1\">");
			   out.println("<TR>");
			   out.println("<TD>Fisrt Name :</TD>");
			   out.println("<TD>Last Name :</TD>");
			   out.println("<TD>Phone :</TD>");
			   out.println("<TD>Address :</TD>");
			   out.println("<TD>Email ID :</TD>");
			   out.println("<TD>Membership Status :</TD>");
			   out.println("<TD>Current Reward Points :</TD>");			   
			   out.println("</TR>");
			  
			while(rs2.next())
			{
			   
			   out.println("<TR>");
			   out.println("<TD>"+  rs2.getString(3) + "</TD>");
			   out.println("<TD>" + rs2.getString(4) + "</TD>");
			   out.println("<TD>" + rs2.getString(5) + "</TD>");
			   out.println("<TD>" + rs2.getString(6) + "</TD>");
			   out.println("<TD>" + rs2.getString(8) + "</TD>");
			   out.println("<TD>" + rs2.getString(10) + "</TD>");
			   out.println("<TD>" + rs2.getString(11) + "</TD>");			   
			   out.println("</TR>");
			   out.println("</Table>");
			
			}
				
			
		   //request.getRequestDispatcher("Success_Update_Info.jsp").forward(request, response);
			
		}
		catch (SQLException e) 
		{
		      throw new 
		      ServletException("Servlet Could not display records.", e);
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 finally 
		 {
		      try 
		      {
		    	  if(statement != null) 
		    	  {
		    		  statement.close();
		    		  statement = null;
		    	  }
		        if(connection != null) 
		        {
		        	connection.close();
		        	connection = null;
		        }
		        if(statement1 != null) 
		    	  {
		    		  statement1.close();
		    		  statement1 = null;
		    	  }
		        
		      } 
		      catch (SQLException e) 
		      {
		    	e.printStackTrace();  
		      }
		     
		  }
}}

