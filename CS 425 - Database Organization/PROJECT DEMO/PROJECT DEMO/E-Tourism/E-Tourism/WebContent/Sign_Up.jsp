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
  <div style="float:top"><a href ="Guest_Login.jsp"><u>HOME</u></a></div>
 
</div>
<body>
<form method="post" action="Sign_Up">
<table>
<tr>
<td>
Enter User-name : </td><td> <input type="text" name = "newuser" /></td></tr>
<tr>
<td>
Enter Password : </td><td> <input type="password" name = "newpwd" /></td></tr>
<tr>
<td>
Enter First Name : </td><td> <input type="text" name = "fname" /></td></tr>
<tr>
<td>
Enter Last Name : </td><td> <input type="text" name = "lname" /></td></tr>
<tr>
<td>
Enter Phone Number : </td><td> <input type="text" name = "phone" /></td></tr>
<tr>
<td>
Enter Address : </td><td> <input type="text" name = "address" /></td></tr>
<tr>
<td>
Enter Credit Card Number : </td><td> <input type="text" name = "creditno" /></td></tr>
<tr>
<td>
Enter Email : </td><td> <input type="text" name = "email" /></td></tr>
<tr>
<td>
Enter Date of Birth : (DD-MON-YY) </td><td> <input type="text" name = "dob" /></td></tr>
<tr>
<td><input type = "submit" value = "Register"/></td></tr>

</table>
</form>
</body>
</html>