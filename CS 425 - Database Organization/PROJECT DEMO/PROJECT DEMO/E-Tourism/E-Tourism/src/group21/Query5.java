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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
 
/**
 * Servlet implementation class ETourism
 */
@WebServlet("/Query5")
public class Query5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection=null;
	private Statement statement;
	private Statement statement1;
	private Statement statement2;
	private Statement statement3;
	private Statement statement4;
	ResultSet rs;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public Query5() {
        super();
        
    }
    /**
     * Method to get the Welcome from the form and output the result
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String staff = request.getParameter("staff");
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			connection=DriverManager.getConnection
					("jdbc:oracle:thin:@fourier.cs.iit.edu:1521:orcl","schandak","sayalics425");
				
			statement=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			statement1=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			statement2=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			statement3=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			statement4=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

				ResultSet rs5 = statement.executeQuery("Select * from ATTRACTION where MIN_STAFF >= '"+staff+"'");
				out.println();
				out.println("<Table border=\"1\">");
				out.println("<TR>");
				out.println("<TD>ATTRACTION NAME :</TD>");
				out.println("<TD>ENOUGH STAFF :</TD>");
				out.println("</TR>");
				while(rs5.next())
				{
					   out.println("<TR>");
					   out.println("<TD>"+  rs5.getString("NAME") + "</TD>");
					   out.println("<TD>" + rs5.getString("MIN_STAFF") + "</TD>");
				}
				
				
				ResultSet rs55 = statement2.executeQuery("Select * from ATTRACTION where MIN_STAFF < '"+staff+"'");
				out.println();
				out.println("<Table border=\"1\">");
				out.println("<TR>");
				out.println("<TD>ATTRACTION NAME :</TD>");
				out.println("<TD>STAFF NEEDED :</TD>");
				out.println("</TR>");
				while(rs55.next())
				{
					   out.println("<TR>");
					   out.println("<TD>"+  rs55.getString("NAME") + "</TD>");
					   out.println("<TD>" + rs55.getString("MIN_STAFF") + "</TD>");
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