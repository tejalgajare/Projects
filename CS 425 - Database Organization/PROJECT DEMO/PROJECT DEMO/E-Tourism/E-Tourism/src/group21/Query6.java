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
@WebServlet("/Query6")
public class Query6 extends HttpServlet {
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
    public Query6() {
        super();
        
    }
    /**
     * Method to get the Welcome from the form and output the result
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String director = request.getParameter("director");
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
			
			
				
				ResultSet rs5 = statement.executeQuery("Select * from Employee where NAME ='"+director+"'");
				rs5.next();
				int id = rs5.getInt("ID");
				//out.println(id);
											
				ResultSet rs1 = statement.executeQuery("Select * from Staffing_Needed where DIRECTOR = '"+id+"' ");
				//
				while(rs1.next())
				{
					//int no = rs1.getRow();
						
				int emp = rs1.getInt("EMP_ID");
				
				ResultSet rs4 =  statement2.executeQuery("Select * from EMPLOYEE where ID = '"+emp+"' ");
				rs4.next();						
				String emp_name = rs4.getString("NAME");
				
				//out.println(emp);
				ResultSet rs3 = statement1.executeQuery("Select * from EMP_CALENDAR where EMP_ID = '"+emp+"' ");
				rs3.next();		
				Date start = rs3.getDate("START_DATE");
				Date end = rs3.getDate("END_DATE");

				rs = statement4.executeQuery("Select * from Staffing_Needed where EMP_ID = '"+emp+"' ");
				rs.next();
				int attr_id = rs.getInt("ATTRACTION_ID");
				
				ResultSet rs6 = statement3.executeQuery("Select * from Attraction where ID = '"+attr_id+"' ");
				rs6.next();
				String attr_name = rs6.getString("NAME");
				
				Date today_1 = new Date(System.currentTimeMillis() -(24*60*60*1000));
				
				Date today_2 = new Date(System.currentTimeMillis() -(48*60*60*1000));
				
	        	if( ((today_2).compareTo(start)>=0) && ((today_2).compareTo(end)<=0) && ((today_1).compareTo(start)>=0) && ((today_1).compareTo(end)<=0))
	        	{
	        		out.println(emp_name + " has worked the last two days at Attraction: " + attr_name + " under Director: " +director+ "!!");
	        		
	        	}
	        	else if(((today_2).compareTo(start)>=0) && ((today_2).compareTo(end)<=0))
	        	{
	        		out.println(emp_name + " has worked on " + today_2 + "at Attraction: " + attr_name + " under Director: " +director+ "!!");
	        		
	        	}
	        	else if(((today_1).compareTo(start)>=0) && ((today_1).compareTo(end)<=0))
	        	{
	        		out.println(emp_name + " has worked on " + today_1 + "at Attraction: " + attr_name + " under Director: " +director+ "!!");
	        		
	        	}
	        	else
	        	{
			        		out.println(emp_name + " has not worked the last two days!!");
			        
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