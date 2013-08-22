<%@page import="group21.welcome"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="C:\Users\Aditya\workspace\E-Tourism\style.css">
<title>Sign up form</title>
</head>
<div id="header"><h1 align="center">E-TOURISM</h1></div>
<div>
  <div style="float:top"><a href ="Registered_User_Login.jsp"><u>HOME</u></a></div>
 
</div>
<body>
<%

String us=(String)session.getAttribute("username");
group21.welcome w= new group21.welcome();
w.setName(us);

 %>
 
<form method="post" action="Update_Info">
Enter New Phone Number : <input type="text" name = "phone" /><br><br>
<input type = "submit" value = "Click to Update"/>
</form>

