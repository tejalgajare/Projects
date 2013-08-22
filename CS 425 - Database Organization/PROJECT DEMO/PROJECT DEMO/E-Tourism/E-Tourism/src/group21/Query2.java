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
@WebServlet("/Query2")
public class Query2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection=null;
	private Statement statement;
	private Statement statement1;
	ResultSet rs;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public Query2() {
        super();
        
    }
    /**
     * Method to get the Welcome from the form and output the result
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			connection=DriverManager.getConnection
			("jdbc:oracle:thin:@fourier.cs.iit.edu:1521:orcl","schandak","sayalics425");
		
			statement=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			statement1=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			//String newLine = System.getProperty("line.separator");//This will retrieve line separator dependent on OS.
						
			ResultSet rs = statement.executeQuery("Select * from Discussion_Forum order by SR_NO");
			rs.first();
			int thread_start = rs.getInt("THREAD_ID");
					
			rs.last();
			int thread_end = rs.getInt("THREAD_ID"); //Maximum thread id
						
		
			out.println();
			   out.println("<Table border=\"1\">");
			   out.println("<TR>");
			   out.println("<TD>CITY :</TD>");
			   out.println("<TD>Attraction :</TD>");
			   out.println("<TD>THREAD TITLE :</TD>");
			   out.println("<TD>COMMENT DESCRIPTION :</TD>");
			   out.println("</TR>");
			while(thread_start <= thread_end)
			{
				
				int attr_id = 0;
				ResultSet rs1 = statement1.executeQuery("Select * from Discussion_Forum where thread_id = '"+thread_start+"' ");	
				while(rs1.next())
				{
					attr_id = rs1.getInt("ATTRACTION_ID");
				}
				
				int no = 1;
				ResultSet rs3 = statement.executeQuery("Select count(*) from Discussion_Forum where thread_id = '"+thread_start+"' ");
				rs3.next();
				int no1 = rs3.getInt(1);
				
				
					ResultSet rs2 = statement.executeQuery("Select * from Attraction where id = '"+attr_id+"' ");
					rs2.first();
					String attr_name = rs2.getString("NAME");
					
					ResultSet rs4 = statement1.executeQuery("Select * from Discussion_Forum where thread_id = '"+thread_start+"' ");
					while(rs4.next())
					{ 
						   out.println("<TR>");
						   out.println("<TD>"+  rs4.getString("CITY") + "</TD>");
						   out.println("<TD>" + attr_name + "</TD>");
						   out.println("<TD>" + rs4.getString("THREAD_TITLE") + "</TD>");
						   out.println("<TD>" + rs4.getString("COMMENT_DESCRIPTION") + "</TD>");
						   out.println("</TR>");
						 
					}
				thread_start++;
			}
			  out.println("</Table>");
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