<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="C:\Users\Aditya\workspace\E-Tourism\style.css">
<title>Login Page</title>
<div id="header"><h1 align="center">E-TOURISM</h1></div>
</head>

<body onload=resetall() >
<div class="login_templ">


	<form method = "post" action= "Welcome">
	<table>
	<tr><td>	Username : </td><td> <input type="text" name = "uname" /></td></tr>
	<tr><td>	Password :</td><td>  <input type="password" name = "pwd" /></td></tr>
	<tr><td>	Role     :</td><td> 
	
	<select name="role" >
	              <option selected value="default"> Please select an option </option>
			      <option value="user">User</option>
                  <option value="Director">Director</option>
                  <option value="CEO">CEO</option>
                  <option value="VP Marketing">VP Marketing</option>
    </select> 
		</td></tr>
		<tr><td></td><td> <input type = "submit" value = "Login"/> <INPUT type="reset" onClick="this.form.reset()" ></td></tr>
		 <tr></tr>
		 <tr><td> Login as a <a href="Guest_Login.jsp"><u>Guest</u></a></td></tr>
	</table>
	
	</form>
</body>
</html>