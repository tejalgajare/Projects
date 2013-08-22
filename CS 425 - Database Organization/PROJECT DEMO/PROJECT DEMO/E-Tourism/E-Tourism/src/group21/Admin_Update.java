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
 * Servlet implementation class Admin_Update
 */
@WebServlet("/Admin_Update")
public class Admin_Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection=null;
	private Statement statement;
	private Statement statement1;
	ResultSet rs;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_Update() {
        super();
        
    }
    /**
     * Method to get the Welcome from the form and output the result
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		group21.welcome w6= new group21.welcome();
		int choice=w6.getAdminChoice();
		String field_name = request.getParameter("field_name");
		String field_value = request.getParameter("field_value");
		
		
		try
		{
				
			
			Class.forName("oracle.jdbc.OracleDriver");
			connection=DriverManager.getConnection
			("jdbc:oracle:thin:@fourier.cs.iit.edu:1521:orcl","schandak","sayalics425");
		
			statement=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			statement1=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			if(field_name.equals("USERNAME"))
			{
				ResultSet rs1=statement1.executeQuery("UPDATE REGISTERED_USER SET USERNAME='"+field_value+"' where USER_ID ="+choice);
				rs1.next();
				out.println("<h4> Field Updated!!! </h4>");
				out.println("<a href = \"Admin_Login.jsp\"><u>HOME</u></a>");
			}
			else if(field_name.equals("PASSWORD"))
			{
				ResultSet rs1=statement1.executeQuery("UPDATE REGISTERED_USER SET PASSWORD='"+field_value+"' where USER_ID ="+choice);
				rs1.next();
				out.println("<h4> Field Updated!!! </h4>");
				out.println("<a href = \"Admin_Login.jsp\"><u>HOME</u></a>");
			}
			else if(field_name.equals("FIRST_NAME"))
			{
				ResultSet rs1=statement1.executeQuery("UPDATE REGISTERED_USER SET FIRST_NAME='"+field_value+"' where USER_ID ="+choice);
				rs1.next();
				out.println("<h4> Field Updated!!! </h4>");
				out.println("<a href = \"Admin_Login.jsp\"><u>HOME</u></a>");
			}
			else if(field_name.equals("LAST_NAME"))
			{
				ResultSet rs1=statement1.executeQuery("UPDATE REGISTERED_USER SET LAST_NAME='"+field_value+"' where USER_ID ="+choice);
				rs1.next();
				out.println("<h4> Field Updated!!! </h4>");
				out.println("<a href = \"Admin_Login.jsp\"><u>HOME</u></a>");
			}
			else if(field_name.equals("PHONE"))
			{
				Long field_value1=Long.parseLong(field_value);
				ResultSet rs1=statement1.executeQuery("UPDATE REGISTERED_USER SET PHONE="+field_value1+" where USER_ID ="+choice);
				rs1.next();
				out.println("<h4> Field Updated!!! </h4>");
				out.println("<a href = \"Admin_Login.jsp\"><u>HOME</u></a>");
			}
			else if(field_name.equals("ADDRESS"))
			{
				
				ResultSet rs1=statement1.executeQuery("UPDATE REGISTERED_USER SET ADDRESS='"+field_value+"' where USER_ID ="+choice);
				rs1.next();
				out.println("<h4> Field Updated!!! </h4>");
				out.println("<a href = \"Admin_Login.jsp\"><u>HOME</u></a>");
			}
			else if(field_name.equals("CREDIT_CARD_NUM"))
			{
				
				ResultSet rs1=statement1.executeQuery("UPDATE REGISTERED_USER SET CREDIT_CARD_NUM='"+field_value+"' where USER_ID ="+choice);
				rs1.next();
				out.println("<h4> Field Updated!!! </h4>");
				out.println("<a href = \"Admin_Login.jsp\"><u>HOME</u></a>");
			}
			else if(field_name.equals("EMAIL_ID"))
			{
				
				ResultSet rs1=statement1.executeQuery("UPDATE REGISTERED_USER SET EMAIL_ID='"+field_value+"' where USER_ID ="+choice);
				rs1.next();
				out.println("<h4> Field Updated!!! </h4>");
				out.println("<a href = \"Admin_Login.jsp\"><u>HOME</u></a>");
			}
			else if(field_name.equals("DOB"))
			{
				
				ResultSet rs1=statement1.executeQuery("UPDATE REGISTERED_USER SET DOB='"+field_value+"' where USER_ID ="+choice);
				rs1.next();
				out.println("<h4> Field Updated!!! </h4>");
				out.println("<a href = \"Admin_Login.jsp\"><u>HOME</u></a>");
			}
			else if(field_name.equals("MEMBERSHIP_STATUS"))
			{
				
				ResultSet rs1=statement1.executeQuery("UPDATE REGISTERED_USER SET MEMBERSHIP_STATUS='"+field_value+"' where USER_ID ="+choice);
				rs1.next();
				out.println("<h4> Field Updated!!! </h4>");
				out.println("<a href = \"Admin_Login.jsp\"><u>HOME</u></a>");
			}
			else if(field_name.equals("CURRENT_REWARD_POINTS"))
			{
				int points=Integer.parseInt(field_value);
				ResultSet rs1=statement1.executeQuery("UPDATE REGISTERED_USER SET CURRENT_REWARD_POINTS="+points+" where USER_ID ="+choice);
				rs1.next();
				out.println("<h4> Field Updated!!! </h4>");
				out.println("<a href = \"Admin_Login.jsp\"><u>HOME</u></a>");
			}
			else
			{
				out.println("<h4>Incorrect Field</h4>");
			out.println("<a href = \"Admin_Login.jsp\"><u>HOME</u></a>");
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

