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
@WebServlet("/Process6")
public class Process6 extends HttpServlet {
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
    public Process6() {
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

			ResultSet rs5 = statement.executeQuery("Select * from EMP_CALENDAR");
			
			while(rs5.next())
			{
				
				int id = rs5.getInt("EMP_ID");
				//out.println(id);
			
				Date today = new Date(System.currentTimeMillis());
				Date today_5 = new Date(System.currentTimeMillis() + (120*60*60*1000));
				Date end = rs5.getDate("END_DATE");
			
				ResultSet rs4 =  statement2.executeQuery("Select * from EMPLOYEE where ID = '"+id+"' ");
				rs4.next();						
				String emp_name = rs4.getString("NAME");
				
				ResultSet rs3 =  statement3.executeQuery("Select * from PROJECT where EMP_ID = '"+id+"' ");
				rs3.next();						
				String proj = rs3.getString("PROJECT_NAME");
				
				if( ((end).compareTo(today)>=0) && ((end).compareTo(today_5)<=0))
	        	{
	        		out.println("This is last working week of " + emp_name + " on " + proj + " !");
	        		out.println("***Assign a new project from next week!!");
	        		
	        	}
				
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