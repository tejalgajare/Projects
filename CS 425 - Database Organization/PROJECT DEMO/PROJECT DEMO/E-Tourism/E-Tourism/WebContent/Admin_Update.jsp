<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="C:\Users\Aditya\workspace\E-Tourism\style.css">
<title>Enter Details</title>
<div id="header"><h1 align="center">E-TOURISM</h1></div>

</head>
<body>
<form method="post" action="Admin_Update">

<%int choice= Integer.parseInt(request.getParameter("choice"));

group21.welcome w5= new group21.welcome();
w5.setAdminChoice(choice);	

%>

<b>Enter the field to be updated :- </b><br>
(USERNAME,PASSWORD,FIRST_NAME,LAST_NAME,PHONE,ADDRESS,CREDIT_CARD_NUM,EMAIL_ID,DOB,MEMBERSHIP_STATUS,CURRENT_REWARD_POINTS)<br><br>
<input type="text" name = "field_name" /><br><br><br>
Enter new value for the field : <input type="text" name = "field_value" /><br><br><br>
<input type = "submit" value = "Update"/><br><br></td>
</form>
</body>
</html>