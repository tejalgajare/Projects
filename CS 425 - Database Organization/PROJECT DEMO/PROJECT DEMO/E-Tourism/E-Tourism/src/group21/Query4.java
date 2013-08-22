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
@WebServlet("/Query4")
public class Query4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection=null;
	private Statement statement;
	private Statement statement1;
	private Statement statement2;
	private Statement statement3;
	private Statement statement4;
	private Statement statement5;
	private Statement statement6;
	private Statement statement7;
	private Statement statement55;
	private Statement statement65;
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public Query4() {
        super();
        
    }
    /**
     * Method to get the Welcome from the form and output the result
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		group21.welcome w3= new group21.welcome();
		
		int attr_id = w3.getAttr();
		
		int id= w3.getitr();
		
		String quantity = request.getParameter("qty");
		
		String ticket_date_str = request.getParameter("ticket_date");
		
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			connection=DriverManager.getConnection
			("jdbc:oracle:thin:@fourier.cs.iit.edu:1521:orcl","schandak","sayalics425");
		
			statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			statement1=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			statement2=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			statement3=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			statement4=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			statement5=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			statement6=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			statement7=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			statement55=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			statement65=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		
			if(attr_id!=0)
			{
				ResultSet rs5 = statement.executeQuery("Select * from Attraction where ID ='"+attr_id+"'");
				rs5.next();
				int owner = rs5.getInt("OWNERSHIP");
				int ticket_id = rs5.getInt("TICKET");
				String attraction = rs5.getString("NAME");
								
				ResultSet rs1 = statement.executeQuery("Select * from Tickets where TICKET_ID = '"+ticket_id+"' ");
				rs1.next();
				int price = rs1.getInt("PRICE");
							
				int qty = Integer.parseInt(quantity) ;
				int sale = qty * price;
				
				int reward = (qty * 5) + 5;		//rewards given to user	
				
				
				ResultSet rs23 = statement55.executeQuery("Select * from REGISTERED_USER where USERNAME = 'rickypowell'");
				rs23.next();
				int current_reward = rs23.getInt("CURRENT_REWARD_POINTS");
				int used_reward = (int)Math.ceil(current_reward/10);
				String email=rs23.getString("Email_ID");
				
				int paid_amt = sale-used_reward; //amount paid by customer
				
				ResultSet rs2 = statement.executeQuery("Select * from CALCULATE_SALE where OWNERSHIP_ID = '"+owner+"' ");
				rs2.next();
				int old_sale = rs2.getInt("SALE");
				
				int new_sale = old_sale + sale;
				
				String Query1 = "UPDATE CALCULATE_SALE SET SALE = '"+new_sale+"' where OWNERSHIP_ID = '"+owner+"'";
				statement.execute(Query1);
				
				rs2 = statement.executeQuery("Select * from TICKETS where TICKET_ID = '"+ticket_id+"' and VALID_DATE = '"+ticket_date_str+"' ");
				rs2.next();
				int old_qty = rs2.getInt("QUANTITY");
				if(old_qty == 0)
				{
					out.println("Tickets for " + attraction + " on " + ticket_date_str + " have already been sold out!! Please book tickets for some other day!");
				}
				else
				{
				int iqty = Integer.parseInt(quantity);
				int final_qty = old_qty - iqty;
				String Query2 = "UPDATE TICKETS SET QUANTITY = '"+final_qty+"' where TICKET_ID = '"+ticket_id+"' and VALID_DATE = '"+ticket_date_str+"' ";
				statement.execute(Query2);
				while(iqty > 0)
				{
					String Query3 = "INSERT INTO COMPLETE_PURCHASE_HISTORY(TICKET_NUMBER, PRICE, USER_ID) VALUES(TICKET_NUMBER.nextval, '"+price+"', 'sayali')";
					statement.execute(Query3);
					iqty--;		
				}
				out.println(qty + " tickets have been booked for " + attraction + " !!");
				
				out.println("CONGRATULATIONS!! You have been awarded with " + reward + " Reward points!!");
				}
				
				ResultSet rs22 = statement.executeQuery("Select * from POINTS where USERNAME = 'rickypowell'");
				rs22.next();
				int earned = rs22.getInt("EARNED");
				if(sale >= used_reward)
				{
					paid_amt = sale - used_reward;
					current_reward = reward;
					//out.println(current_reward);
					int orig = earned + reward;
					String Query25 = "UPDATE POINTS SET EARNED = '"+orig+"' where USERNAME = 'rickypowell'";
					statement.execute(Query25);
					if(orig>=1500)
					{
						String Query28 = "UPDATE REGISTERED_USER SET MEMBERSHIP_STATUS = 'PLATINUM' where USERNAME = 'rickypowell'";
						statement.execute(Query28);
						String Query29 = "UPDATE POINTS SET STATUS = 'PLATINUM' where USERNAME = 'rickypowell'";
						statement.execute(Query29);
					}
					else if(orig>=750 && orig<1500)
					{
						String Query28 = "UPDATE REGISTERED_USER SET MEMBERSHIP_STATUS = 'GOLD' where USERNAME = 'rickypowell'";
						statement.execute(Query28);
						String Query29 = "UPDATE POINTS SET STATUS = 'PLATINUM' where USERNAME = 'rickypowell'";
						statement.execute(Query29);
					}
					else if(orig>=0 && orig<750)
					{
						String Query28 = "UPDATE REGISTERED_USER SET MEMBERSHIP_STATUS = 'SILVER' where USERNAME = 'rickypowell'";
						statement.execute(Query28);
						String Query29 = "UPDATE POINTS SET STATUS = 'PLATINUM' where USERNAME = 'rickypowell'";
						statement.execute(Query29);
					}
					String Query26 = "UPDATE REGISTERED_USER SET CURRENT_REWARD_POINTS = '"+current_reward+"' where USERNAME = 'rickypowell'";
					statement.execute(Query26);
					out.println("Total ticket price to be paid is $" + paid_amt + " !!");
				}
				else if(sale < used_reward)
				{
					paid_amt = 0;
					current_reward = reward + used_reward - sale;
					//out.println(current_reward);
					int orig = earned + reward;
					String Query25 = "UPDATE POINTS SET EARNED = '"+orig+"' where USERNAME = 'rickypowell'";
					statement.execute(Query25);
					if(orig>=1500)
					{
						String Query28 = "UPDATE REGISTERED_USER SET MEMBERSHIP_STATUS = 'PLATINUM' where USERNAME = 'rickypowell'";
						statement.execute(Query28);
						String Query29 = "UPDATE POINTS SET STATUS = 'PLATINUM' where USERNAME = 'rickypowell'";
						statement.execute(Query29);
					}
					else if(orig>=750 && orig<1500)
					{
						String Query28 = "UPDATE REGISTERED_USER SET MEMBERSHIP_STATUS = 'GOLD' where USERNAME = 'rickypowell'";
						statement.execute(Query28);
						String Query29 = "UPDATE POINTS SET STATUS = 'PLATINUM' where USERNAME = 'rickypowell'";
						statement.execute(Query29);
					}
					else if(orig>=0 && orig<750)
					{
						String Query28 = "UPDATE REGISTERED_USER SET MEMBERSHIP_STATUS = 'SILVER' where USERNAME = 'rickypowell'";
						statement.execute(Query28);
						String Query29 = "UPDATE POINTS SET STATUS = 'PLATINUM' where USERNAME = 'rickypowell'";
						statement.execute(Query29);
					}
					String Query26 = "UPDATE REGISTERED_USER SET CURRENT_REWARD_POINTS = '"+current_reward+"' where USERNAME = 'rickypowell'";
					statement.execute(Query26);
					out.println("Total ticket price to be paid is $" + paid_amt + " !!");
				}
				
				String Query19 = "INSERT INTO COMPLETE_PURCHASE_HISTORY(TICKET_NUMBER, PRICE, USER_ID) VALUES(TICKET_NUMBER.nextval, '"+price+"', 'sayali')";
				statement.execute(Query19);
				
			}	
				//--------------------------------------------------------------------------
			if(id!=0)
			{	
				
				ResultSet rs6 = statement2.executeQuery("Select * from ITINERARY where ITINERARY_ID ='"+id+"'");
				rs6.next();
				
				String first = rs6.getString("ATT_FIRST");
				String second = rs6.getString("ATT_SECOND");
				String third = rs6.getString("ATT_THIRD");
				String itr_name = rs6.getString("ATTRACTIONS_MULTI");
				
				ResultSet rs7 = statement2.executeQuery("Select * from Attraction where NAME ='"+first+"'");
				rs7.next();
				int owner = rs7.getInt("OWNERSHIP");
				
				int ticket_id = rs7.getInt("TICKET");
								
				ResultSet rs8 = statement3.executeQuery("Select * from Tickets where TICKET_ID = '"+ticket_id+"' ");
				rs8.last();
				int price = rs8.getInt("PRICE");
				
				int qty = Integer.parseInt(quantity) ;
				int sale1 = qty * price;
								
				ResultSet rs9 = statement3.executeQuery("Select * from CALCULATE_SALE where OWNERSHIP_ID = '"+owner+"' ");
				rs9.next();
				int old_sale = rs9.getInt("SALE");
				
				int new_sale = old_sale + sale1;
				
				String Query1 = "UPDATE CALCULATE_SALE SET SALE = '"+new_sale+"' where OWNERSHIP_ID = '"+owner+"'";
				statement.execute(Query1);
				
				ResultSet rs2 = statement.executeQuery("Select * from TICKETS where TICKET_ID = '"+ticket_id+"' and VALID_DATE = '"+ticket_date_str+"' ");
				rs2.next();
				int old_qty = rs2.getInt("QUANTITY");
				
				if(old_qty == 0)
				{
					out.println("Tickets for " + first + " on " + ticket_date_str + " have already been sold out!! Please book tickets for some other day!");
				}
				else
				{
				int iqty = Integer.parseInt(quantity);
				int final_qty = old_qty - iqty;
				String Query2 = "UPDATE TICKETS SET QUANTITY = '"+final_qty+"' where TICKET_ID = '"+ticket_id+"' and VALID_DATE = '"+ticket_date_str+"' ";
				statement.execute(Query2);
				while(iqty > 0)
				{
					String Query3 = "INSERT INTO COMPLETE_PURCHASE_HISTORY(TICKET_NUMBER, PRICE, USER_ID) VALUES(TICKET_NUMBER.nextval, '"+price+"', 'sayali')";
					statement.execute(Query3);
					iqty--;		
				}
				}
				
				
			    //----------------------------------------------------------------
				
				ResultSet rs11 = statement5.executeQuery("Select * from Attraction where NAME ='"+second+"'");
				rs11.next();
				owner = rs11.getInt("OWNERSHIP");
				
				ticket_id = rs11.getInt("TICKET");
								
				ResultSet rs12 = statement5.executeQuery("Select * from Tickets where TICKET_ID = '"+ticket_id+"' ");
				rs12.last();
				price = rs12.getInt("PRICE");
							
				qty = Integer.parseInt(quantity) ;
				int sale3 = qty * price;

				
				
				ResultSet rs13 = statement5.executeQuery("Select * from CALCULATE_SALE where OWNERSHIP_ID = '"+owner+"' ");
				rs13.next();
				old_sale = rs13.getInt("SALE");
				
				new_sale = old_sale + sale3;
				
				Query1 = "UPDATE CALCULATE_SALE SET SALE = '"+new_sale+"' where OWNERSHIP_ID = '"+owner+"'";
				statement.execute(Query1);
				
				rs2 = statement.executeQuery("Select * from TICKETS where TICKET_ID = '"+ticket_id+"' and VALID_DATE = '"+ticket_date_str+"' ");
				rs2.next();
				old_qty = rs2.getInt("QUANTITY");
				
				if(old_qty == 0)
				{
					out.println("Tickets for " + second + " on " + ticket_date_str + " have already been sold out!! Please book tickets for some other day!");
				}
				else
				{
					int iqty = Integer.parseInt(quantity);
					int final_qty = old_qty - iqty;
				String Query2 = "UPDATE TICKETS SET QUANTITY = '"+final_qty+"' where TICKET_ID = '"+ticket_id+"' and VALID_DATE = '"+ticket_date_str+"' ";
				statement.execute(Query2);
				while(iqty > 0)
				{
					String Query3 = "INSERT INTO COMPLETE_PURCHASE_HISTORY(TICKET_NUMBER, PRICE, USER_ID) VALUES(TICKET_NUMBER.nextval, '"+price+"', 'sayali')";
					statement.execute(Query3);
					iqty--;		
				}
				}
				//------------------------------------------------------------------------
				
				ResultSet rs5 = statement6.executeQuery("Select * from Attraction where NAME ='"+third+"'");
				rs5.next();
				owner = rs5.getInt("OWNERSHIP");
				
				ticket_id = rs5.getInt("TICKET");
								
				ResultSet rs1 = statement7.executeQuery("Select * from Tickets where TICKET_ID = '"+ticket_id+"' ");
				rs1.last();
				price = rs1.getInt("PRICE");
							
				qty = Integer.parseInt(quantity) ;
				int sale2 = qty * price;
				
				rs2 = statement7.executeQuery("Select * from CALCULATE_SALE where OWNERSHIP_ID = '"+owner+"' ");
				rs2.next();
				old_sale = rs2.getInt("SALE");
				
				new_sale = old_sale + sale2;
				
				Query1 = "UPDATE CALCULATE_SALE SET SALE = '"+new_sale+"' where OWNERSHIP_ID = '"+owner+"'";
				statement.execute(Query1);

				rs2 = statement.executeQuery("Select * from TICKETS where TICKET_ID = '"+ticket_id+"' and VALID_DATE = '"+ticket_date_str+"' ");
				rs2.next();
				old_qty = rs2.getInt("QUANTITY");
				
				if(old_qty == 0)
				{
					out.println("Tickets for " + third + " on " + ticket_date_str + " have already been sold out!! Please book tickets for some other day!");
				}
				else
				{
					int iqty = Integer.parseInt(quantity);
					int final_qty = old_qty - iqty;
				String Query2 = "UPDATE TICKETS SET QUANTITY = '"+final_qty+"' where TICKET_ID = '"+ticket_id+"' and VALID_DATE = '"+ticket_date_str+"' ";
				statement.execute(Query2);
				while(iqty > 0)
				{
					String Query3 = "INSERT INTO COMPLETE_PURCHASE_HISTORY(TICKET_NUMBER, PRICE, USER_ID) VALUES(TICKET_NUMBER.nextval, '"+price+"', 'sayali')";
					statement.execute(Query3);
					iqty--;		
				}
				
				

				ResultSet rs33 = statement65.executeQuery("Select * from REGISTERED_USER where USERNAME = 'rickypowell'");
				rs33.next();
				int current_reward = rs33.getInt("CURRENT_REWARD_POINTS");
				int used_reward = (int)Math.ceil(current_reward/10);
				String email=rs33.getString("Email_ID");
				int reward= (qty*5) + 5;
				int total = (sale1+sale2+sale3);
				int paid_amt = total - used_reward; //amount paid by customer*/
				
				
										out.println("Your ticket package has been booked for " + itr_name + " for " + qty + " persons!!");
										out.println("CONGRATULATIONS!! You have been awarded with " + reward + " Reward points!!");
										out.println("Your ticket confirmation will be sent to : " + email );
										
										ResultSet rs22 = statement.executeQuery("Select * from POINTS where USERNAME = 'rickypowell'");
										rs22.next();
										int earned = rs22.getInt("EARNED");
										if(total >= used_reward)
										{
											paid_amt = total - used_reward;
											current_reward = reward;
											//out.println(current_reward);
											int orig = earned + reward;
											String Query25 = "UPDATE POINTS SET EARNED = '"+orig+"' where USERNAME = 'rickypowell'";
											statement.execute(Query25);
											if(orig>=1500)
											{
												String Query28 = "UPDATE REGISTERED_USER SET MEMBERSHIP_STATUS = 'PLATINUM' where USERNAME = 'rickypowell'";
												statement.execute(Query28);
												String Query29 = "UPDATE POINTS SET STATUS = 'PLATINUM' where USERNAME = 'rickypowell'";
												statement.execute(Query29);
											}
											else if(orig>=750 && orig<1500)
											{
												String Query28 = "UPDATE REGISTERED_USER SET MEMBERSHIP_STATUS = 'GOLD' where USERNAME = 'rickypowell'";
												statement.execute(Query28);
												String Query29 = "UPDATE POINTS SET STATUS = 'PLATINUM' where USERNAME = 'rickypowell'";
												statement.execute(Query29);
											}
											else if(orig>=0 && orig<750)
											{
												String Query28 = "UPDATE REGISTERED_USER SET MEMBERSHIP_STATUS = 'SILVER' where USERNAME = 'rickypowell'";
												statement.execute(Query28);
												String Query29 = "UPDATE POINTS SET STATUS = 'PLATINUM' where USERNAME = 'rickypowell'";
												statement.execute(Query29);
											}
											String Query26 = "UPDATE REGISTERED_USER SET CURRENT_REWARD_POINTS = '"+current_reward+"' where USERNAME = 'rickypowell'";
											statement.execute(Query26);
											out.println("Total ticket price to be paid is $" + paid_amt + " !!");
										}
										else if(total < used_reward)
										{
											paid_amt = 0;
											current_reward = reward + used_reward - total;
											//out.println(current_reward);
											int orig = earned + reward;
											String Query25 = "UPDATE POINTS SET EARNED = '"+orig+"' where USERNAME = 'rickypowell'";
											statement.execute(Query25);
											if(orig>=1500)
											{
												String Query28 = "UPDATE REGISTERED_USER SET MEMBERSHIP_STATUS = 'PLATINUM' where USERNAME = 'rickypowell'";
												statement.execute(Query28);
												String Query29 = "UPDATE POINTS SET STATUS = 'PLATINUM' where USERNAME = 'rickypowell'";
												statement.execute(Query29);
											}
											else if(orig>=750 && orig<1500)
											{
												String Query28 = "UPDATE REGISTERED_USER SET MEMBERSHIP_STATUS = 'GOLD' where USERNAME = 'rickypowell'";
												statement.execute(Query28);
												String Query29 = "UPDATE POINTS SET STATUS = 'PLATINUM' where USERNAME = 'rickypowell'";
												statement.execute(Query29);
											}
											else if(orig>=0 && orig<750)
											{
												String Query28 = "UPDATE REGISTERED_USER SET MEMBERSHIP_STATUS = 'SILVER' where USERNAME = 'rickypowell'";
												statement.execute(Query28);
												String Query29 = "UPDATE POINTS SET STATUS = 'PLATINUM' where USERNAME = 'rickypowell'";
												statement.execute(Query29);
											}
											String Query26 = "UPDATE REGISTERED_USER SET CURRENT_REWARD_POINTS = '"+current_reward+"' where USERNAME = 'rickypowell'";
											statement.execute(Query26);
											out.println("Total ticket price to be paid is $" + paid_amt + " !!");
										}
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