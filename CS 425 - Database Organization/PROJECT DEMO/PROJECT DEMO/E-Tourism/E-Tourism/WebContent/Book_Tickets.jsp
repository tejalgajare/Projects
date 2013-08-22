<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <%@page language="java" import="java.util.*" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="C:\Users\Aditya\workspace\E-Tourism\style.css">
<title>Book Tickets</title>
<div id="header"><h1 align="center">E-TOURISM</h1></div>
<div>
  <div style="float:top"><a href ="Guest_Login.jsp"><u>HOME</u></a></div>

</div>

<h4 align=\"Left\">To book a ticket you need to get Registered : 
<a align="Left" href="Sign_Up_Before_Booking.jsp"><u>Sign Up</u></a></h4></br></br></br>

</head>
<body>


 
<% 


String attraction= request.getParameter("option_attr");
String itinerary= request.getParameter("option_it"); 
String strViewPage="Query4.jsp";
int a1_id=Integer.parseInt(attraction);
int itr1_id=Integer.parseInt(attraction);
group21.welcome w44= new group21.welcome();
w44.setAttr(a1_id);	
w44.setitr(itr1_id);
/*
if(attraction!=null)
{
	
	int a_id=Integer.parseInt(attraction);
	group21.welcome w2= new group21.welcome();
	w2.setAttr(a_id);	
	
	//request.getRequestDispatcher(strViewPage).forward(request, response);
	
}
if(itinerary!=null)
{
	int itr_id=Integer.parseInt(itinerary);
	group21.welcome w4= new group21.welcome();
	w4.setitr(itr_id);
	//request.getRequestDispatcher(strViewPage).forward(request, response);	
}



/*
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class query4 extends HttpServlet {
public void doGet(HttpServletRequest req, HttpServletResponse res)
        throws IOException {
ServletOutputStream out = res.getOutputStream();

res.setContentType("text/html");
out.println(req.getAttribute("selected_attraction_id"));
out.println(req.getAttribute("selected_itinerary_id"));
        }
}*/

%>




</body>
</form>
</html>