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
<form method = "post" action= "Registered_User_Login.jsp">

<h3 align=\"Left\">Hello Registered User : ${uname} </h3>


<h4 align=\"Left\">Your Membership Status is :  ${status} </h4>
<h4 align=\"Left\">Your Reward Points : ${points}</h4>
 <%
 String uname= (String)request.getAttribute("uname");
 String status= (String)request.getAttribute("status");
 String points= (String)request.getAttribute("points");
 request.setAttribute("uname", uname);
 request.setAttribute("status", status);
 request.setAttribute("status", points);
 request.getRequestDispatcher("Registered_User_Login.jsp").forward(request, response);
 %>
 
 
<input type = "submit" value = "Continue"/><br><br></td>



</form>



</body>
</form>
</html>