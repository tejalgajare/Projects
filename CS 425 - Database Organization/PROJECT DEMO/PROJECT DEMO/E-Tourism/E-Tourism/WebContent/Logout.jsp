<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logged out Successfully</title>
</head>
<body>
<%  
session = request.getSession(false);

if(session!=null)
{
session.invalidate();
}
RequestDispatcher rd=request.getRequestDispatcher("Welcome.jsp");
rd.forward(request, response);



%>

<!--  a href="Welcome.jsp"><u>Click to Login Again</u></a> </h3></div>-->
</body>
</html>