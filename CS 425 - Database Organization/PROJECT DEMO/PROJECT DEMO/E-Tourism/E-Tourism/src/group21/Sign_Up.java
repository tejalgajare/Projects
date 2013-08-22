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


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Guest_Register
 */
@WebServlet("/Sign_Up")
public class Sign_Up extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection=null;
	private Statement statement;
	private Statement statement1;
	ResultSet rs;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public Sign_Up() {
        super();
        
    }
    /**
     * Method to get the Welcome from the form and output the result
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String user_name = request.getParameter("newuser");
		String password = request.getParameter("newpwd");
		String firstname = request.getParameter("fname");
		String lastname = request.getParameter("lname");
		int phone = Integer.parseInt(request.getParameter("phone"));
		String address = request.getParameter("address");
		int creditcardno = Integer.parseInt(request.getParameter("creditno"));
		String email = request.getParameter("email");
		String dob = request.getParameter("dob");
		int flag=0;
		try
		{
				
			
			Class.forName("oracle.jdbc.OracleDriver");
			connection=DriverManager.getConnection
			("jdbc:oracle:thin:@fourier.cs.iit.edu:1521:orcl","schandak","sayalics425");
		
			statement=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			statement1=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			ResultSet rs1=statement1.executeQuery("Select * from Registered_User");
			rs1.last();
			int last = rs1.getRow();
			last++;
					
					
			String query="Insert into REGISTERED_USER (USERNAME,PASSWORD,FIRST_NAME,LAST_NAME,PHONE,ADDRESS,CREDIT_CARD_NUM,EMAIL_ID,DOB,MEMBERSHIP_STATUS,CURRENT_REWARD_POINTS,RECENT_ACTIVITY,USER_ID) values ('"+user_name+"','"+password+"','"+firstname+"','"+lastname+"',"+phone+",'"+address+"',"+creditcardno+",'"+email+"','"+dob+"','Silver',0,0,"+last+")";
			statement.executeQuery(query);
			flag=1;
			ResultSet rs= statement.executeQuery("Select * from Registered_User where USER_ID=" + last);
			rs.next();
			String uname=rs.getString("USERNAME");
			String membership=rs.getString("Membership_Status");
			String points=rs.getString("Current_Reward_Points");
			
			request.setAttribute("uname", uname);
			request.setAttribute("flag", flag);
			request.setAttribute("status", membership);
			request.setAttribute("points", points);
		    request.getRequestDispatcher("Guest_is_Registered.jsp").forward(request, response);
			
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

