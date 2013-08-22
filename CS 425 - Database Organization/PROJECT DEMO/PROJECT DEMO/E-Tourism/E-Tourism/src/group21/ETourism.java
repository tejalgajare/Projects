package group21;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ETourism
 */
@WebServlet("/Welcome")
public class ETourism extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection=null;
	private Statement statement;
	private Statement statement1;
	ResultSet rs;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public ETourism() {
        super();
        
    }
    /**
     * Method to get the Welcome from the form and output the result
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("uname");
		String password = request.getParameter("pwd");
		String roletype = request.getParameter("role");
		out.println(roletype);
		try
		{
				
			
			Class.forName("oracle.jdbc.OracleDriver");
			connection=DriverManager.getConnection
			("jdbc:oracle:thin:@fourier.cs.iit.edu:1521:orcl","schandak","sayalics425");
		
			statement=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			statement1=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			if(roletype.equals("user"))
			{
			ResultSet rs = statement.executeQuery("Select * from Registered_User where username = '"+username+"' and password='"+password+"'");
			rs.last();
			int noofrows = rs.getRow();
				
			if(noofrows == 0)
			{
				
				out.println("<h4> Invalid Username / Password </h4>");
							
			}
		
			else
			{
				
				request.setAttribute("uname", username);
				HttpSession session = request.getSession(true);
				request.setAttribute("session", session);
				request.setAttribute("status", rs.getString("Membership_Status"));
				request.setAttribute("points", rs.getString("Current_Reward_Points"));
				request.getRequestDispatcher("Registered_User_Login.jsp").forward(request, response);
				
						   
			}
			
			}
			else if(roletype.equals("Director"))
			{
				
				ResultSet rs1 = statement.executeQuery("Select * from Employee where username = '"+username+"' and password='"+password+"'");
				rs1.last();
				int noofrows = rs1.getRow();
					out.println(noofrows);
				if(noofrows == 0)
				{
					
					out.println("<h4> Invalid Username / Password </h4>");
								
				}
			
				else
				{
					request.setAttribute("uname", username);
					HttpSession session = request.getSession(true);
					request.setAttribute("session", session);
					request.getRequestDispatcher("Director.jsp").forward(request, response);
					
							   
				}
				
				
			}
			
			
			else if(roletype.equals("VP Marketing"))
			{
				
				ResultSet rs1 = statement.executeQuery("Select * from Employee where username = '"+username+"' and password='"+password+"'");
				rs1.last();
				int noofrows = rs1.getRow();
					
				if(noofrows == 0)
				{
					
					out.println("<h4> Invalid Username / Password </h4>");
								
				}
			
				else
				{
					request.setAttribute("uname", username);
					HttpSession session = request.getSession(true);
					request.setAttribute("session", session);
					request.getRequestDispatcher("Marketing.jsp").forward(request, response);
					
							   
				}
				
				
			}
			
			
			else if(roletype.equals("CEO"))
			{
				
				ResultSet rs1 = statement.executeQuery("Select * from Employee where username = '"+username+"' and password='"+password+"'");
				rs1.last();
				int noofrows = rs1.getRow();
					
				if(noofrows == 0)
				{
					
					out.println("<h4> Invalid Username / Password </h4>");
								
				}
			
				else
				{
					request.setAttribute("uname", username);
					HttpSession session = request.getSession(true);
					request.setAttribute("session", session);
					request.getRequestDispatcher("Admin_Login.jsp").forward(request, response);
					
							   
				}
				
				
			}
			else out.println("heeeeeee");
			
			
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
		      } 
		      catch (SQLException e) 
		      {
		    	e.printStackTrace();  
		      }
		      
		  }
}}

