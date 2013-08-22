<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" href="C:\Users\Aditya\workspace\E-Tourism\style.css">
<title>Welcome</title>
<div id="header"><h1 align="center">E-TOURISM</h1></div>
<div id="header"><h3 align="Right">Hello Guest !</h3></div>
<div id="welcome">Become a member of E-Tourism: <a align="Right" href="Sign_Up.jsp"><u>Sign Up Now</u></a></div>
</head>
<body>
<form method = "post" action= "Guest_Login">
<table>
<tr>

<td><b>
1.View Attractions</b>
</td></tr>
<tr><td>
<select name="city" >
	              <option selected value="default"> City </option>
			      <option value="Chicago">Chicago</option>
                  <option value="New York">New York</option>
                  <option value="San Diego">San Diego</option>                
                 
</select>
<input type = "submit" value = "View Attractions"/><br><br></td>
</tr>


<tr><td>
<b>2.<a href="Query1.jsp">View discussions/comments from a specific discussion thread</a></b> 
</td></tr>
<tr><td>
<b>3.<a href="Query2.jsp">View discussions/comments from all discussion threads</a></b> 
</td></tr>
</table>
</form>

</body>
</html>