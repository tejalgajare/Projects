package group21;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class Guest_Register
 */
@WebServlet("/Book_Tickets")
public class Book_Ticket extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection=null;
	private Statement statement;
	private Statement statement1;
	ResultSet rs;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public Book_Ticket() {
        super();
        
    }
    /**
     * Method to get the Welcome from the form and output the result
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String city = request.getParameter("city");
		
		
		try
		{
				
			
			Class.forName("oracle.jdbc.OracleDriver");
			connection=DriverManager.getConnection
			("jdbc:oracle:thin:@fourier.cs.iit.edu:1521:orcl","schandak","sayalics425");
		
			statement=connection.createStatement();
			statement1=connection.createStatement();
			
			
			ResultSet rs = statement.executeQuery("Select * from Attraction where city ='"+ city+"'");
			out.println("<form method = \"post\" action= \"Book_Tickets.jsp\">");
			out.println("<h3>Attractions in " + city + "</h3>" ); 
			
			out.println("<Table border=\"1\">");
			out.println("<TR>");
			out.println("<TD><B> Choice </B></TD>");
			out.println("<TD><B> ID </B></TD>");
			out.println("<TD><B> Name </B></TD>");
			out.println("<TD><b> Address </TD></b>");
			out.println("<TD><b> Phone </TD></b>");
			out.println("<TD><b> Start Hours </TD></b>");
			out.println("<TD><b> End Hours </TD></b>");
			out.println("<TD><b> Email </TD></b>");
			out.println("<TD><b> Best Times </TD></b>");
			out.println("<TD><b> Description </TD></b>");
			out.println("</TR><BR>");
			int j=1;
			while(rs.next())
			{
			   out.println();
			   
			   out.println("<TR>");
			   out.println("<TD><input type=\"radio\" name=\"option_attr\" value=\"" + rs.getString(1) + "\"\"></TD>");
			   out.println("<TD>" + j + "</TD>");
			   out.println("<TD>" + rs.getString(2) + "</TD>");
			   out.println("<TD>" + rs.getString(4) + "</TD>");
			   out.println("<TD>" + rs.getString(5) + "</TD>");
			   out.println("<TD>" + rs.getString(6) + "</TD>");
			   out.println("<TD>" + rs.getString(7) + "</TD>");
			   out.println("<TD>" + rs.getString(8) + "</TD>");
			   out.println("<TD>" + rs.getString(9) + "</TD>");
			   out.println("<TD>" + rs.getString(17) + "</TD>");
			   out.println("</TR>");
			   j++;
			}
			out.println("</Table><br><br>");
			
			out.println("<h3>Recommended Itinerary </h3>" ); 
			
			out.println("<Table border=\"1\">");
			out.println("<TR>");
			out.println("<TD><B> Choice </B></TD>");
			out.println("<TD><B> ID </B></TD>");
			out.println("<TD><b> Start Time </TD></b>");
			out.println("<TD><b> End Time </TD></b>");
			out.println("<TD><b> Covered Attractions</TD></b>");
			out.println("</TR><BR>");
			ResultSet rs1 = statement1.executeQuery("Select * from Itinerary where city ='"+ city+"'");
			int i=1;
			while(rs1.next())
			{
			   out.println();
			   out.println("<TR>");
			   out.println("<TD><input type=\"radio\" name=\"option_it\" value=\"" + rs1.getString(1) + "\"\"></TD>");
			   out.println("<TD>" + i + "</TD>");
			   out.println("<TD>" + rs1.getString(2) + "</TD>");
			   out.println("<TD>" + rs1.getString(3) + "</TD>");
			   out.println("<TD>" + rs1.getString(4) + "</TD>");
			   out.println("</TR>");
			   i++;
			}
			out.println("</Table><br><br>");
			out.println("<input type = \"submit\" value = \"Book Tickets\"/>");
			out.println("<input type = \"reset\" value = \"Clear\"/>");
			out.println("<a href = \"Guest_Login.jsp\"><u>Go Back</u></a>");
			out.println("</form>");			
			
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

