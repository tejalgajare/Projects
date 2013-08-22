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


<body>

 
<% 

group21.welcome w45= new group21.welcome();
int attraction= w45.getAttr();

int itinerary= w45.getitr();
String strViewPage="Query4.jsp";

out.println(attraction);
request.getRequestDispatcher(strViewPage).forward(request, response);
/*if(attraction!=0)
{
	
	//int a_id=Integer.parseInt(attraction);
	//group21.welcome w2= new group21.welcome();
	//w2.setAttr(a_id);	
	
	request.getRequestDispatcher(strViewPage).forward(request, response);
	
}
if(itinerary!=0)
{
	//int itr_id=Integer.parseInt(itinerary);
	//group21.welcome w4= new group21.welcome();
	//w4.setitr(itr_id);
	request.getRequestDispatcher(strViewPage).forward(request, response);	
}
/*
request.setAttribute("selected_attraction_id",attraction);
request.setAttribute("selected_itinerary_id",itinerary);
String strViewPage="query4.java";
RequestDispatcher dispatcher = request.getRequestDispatcher(strViewPage);
if (dispatcher != null){
dispatcher.forward(request, response);
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