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
 * Servlet implementation class view_customer
 */
@WebServlet("/view_customer")
public class view_customer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection=null;
	private Statement statement;
	private Statement statement1;
	ResultSet rs;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public view_customer() {
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
			
		try
		{
				
			
			Class.forName("oracle.jdbc.OracleDriver");
			connection=DriverManager.getConnection
			("jdbc:oracle:thin:@fourier.cs.iit.edu:1521:orcl","schandak","sayalics425");
		
			statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			statement1=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			
			//ResultSet rs = statement.executeQuery("Select * from Registered_User where username = '"+username+"'");
			ResultSet rs = statement.executeQuery("Select * from Registered_User");
			rs.last();
			int noofrows = rs.getRow();
			//out.println(noofrows);
			if(noofrows == 0)
			{
				
				out.println("<h4> Invalid Username / Password </h4>");
							
			}
		
			else
			{
				
				//out.println("<form method = \"post\" action= \"Admin_Update.jsp\">");
				out.println("<h3>Detailed Customer Information :</h3>" ); 
				out.println("<form method = \"post\" action= \"Admin_Update.jsp\">");
				out.println("<Table border=\"1\">");
				out.println("<TR>");
				out.println("<TD><B> Choice to Update </B></TD>");
				out.println("<TD><B> SR NO </B></TD>");
				out.println("<TD><B> Username </B></TD>");
				out.println("<TD><B> Password </B></TD>");
				out.println("<TD><B> First Name </B></TD>");
				out.println("<TD><B> Last Name </B></TD>");
				out.println("<TD><b> Phone </TD></b>");
				out.println("<TD><b> Address </TD></b>");
				out.println("<TD><b> Credit Card Details </TD></b>");
				out.println("<TD><b> Email ID </TD></b>");
				out.println("<TD><b> Date of Birth </TD></b>");
				out.println("<TD><b> Membership Status </TD></b>");
				out.println("<TD><b> Current Reward Points </TD></b>");
				out.println("<TD><b> User ID </TD></b>");
				out.println("</TR><BR>");
				int j=1;
				
				
				rs.beforeFirst();
				
				while(rs.next())
				{
								   
				   out.println("<TR>");
				   out.println("<TD><input type=\"radio\" name=\"choice\" value=\"" + rs.getString(13) + "\"\"></TD>");
				   out.println("<TD>" + j + "</TD>");
				   out.println("<TD>" + rs.getString(1) + "</TD>");
				   out.println("<TD>" + rs.getString(2) + "</TD>");
				   out.println("<TD>" + rs.getString(3) + "</TD>");
				   out.println("<TD>" + rs.getString(4) + "</TD>");
				   out.println("<TD>" + rs.getString(5) + "</TD>");
				   out.println("<TD>" + rs.getString(6) + "</TD>");
				   out.println("<TD>" + rs.getString(7) + "</TD>");
				   out.println("<TD>" + rs.getString(8) + "</TD>");		
				   out.println("<TD>" + rs.getString(9) + "</TD>");	
				   out.println("<TD>" + rs.getString(10) + "</TD>");	
				   out.println("<TD>" + rs.getString(11) + "</TD>");	
				   out.println("<TD>" + rs.getString(13) + "</TD>");	
				 
				   out.println("</TR>");
				   j++;
				}
				out.println("</Table><br><br>");
				out.println("<input type = \"submit\" value = \"Click to Update Info\"/>");
				out.println("<a href = \"Admin_Login.jsp\"><u>HOME</u></a>");
				out.println("</form>");			   
			}
			
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

