package group21;

import java.io.IOException;
import java.util.*;
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
@WebServlet("/Query1")
public class Query1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection=null;
	private Statement statement;
	private Statement statement1;
	ResultSet rs;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public Query1() {
        super();
        
    }
    /**
     * Method to get the Welcome from the form and output the result
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String attr_name = request.getParameter("attr_name");
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			connection=DriverManager.getConnection
			("jdbc:oracle:thin:@fourier.cs.iit.edu:1521:orcl","schandak","sayalics425");
		
			statement=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			statement1=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			String newLine = System.getProperty("line.separator");//This will retrieve line separator dependent on OS.

			ResultSet rs = statement.executeQuery("Select * from ATTRACTION where NAME = '"+attr_name+"'");
			rs.last();
			int attr_id = rs.getInt("ID");
			
			ResultSet rs1 = statement1.executeQuery("Select * from Discussion_Forum where ATTRACTION_ID = '"+attr_id+"' ");
			
			out.println();
			   out.println("<Table border=\"1\">");
			   out.println("<TR>");
			   out.println("<TD>CITY :</TD>");
			   out.println("<TD>Attraction :</TD>");
			   out.println("<TD>THREAD TITLE :</TD>");
			   out.println("<TD>COMMENT DESCRIPTION :</TD>");
			   out.println("</TR>");
			
			while(rs1.next())
			{
				
				out.println("<TR>");
				   out.println("<TD>"+  rs1.getString("CITY") + "</TD>");
				   out.println("<TD>" + attr_name + "</TD>");
				   out.println("<TD>" + rs1.getString("THREAD_TITLE") + "</TD>");
				   out.println("<TD>" + rs1.getString("COMMENT_DESCRIPTION") + "</TD>");
				   out.println("</TR>");
				
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
}
}