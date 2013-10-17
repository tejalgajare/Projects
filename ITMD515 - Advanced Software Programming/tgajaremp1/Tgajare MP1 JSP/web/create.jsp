<%-- 
    Document   : create.jsp
    Created on : Sep 20, 2013, 10:16:28 PM
    Author     : Tejal
    This jsp is used as the main menu page to navigate the user through creation of new 
    records either in Country, City or CountryLanguage Tables
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link href="MP1_JSP_css.css" rel="stylesheet">
        <link href='http://fonts.googleapis.com/css?family=Strait' rel='stylesheet' type='text/css'>
     
        <title>Create Record</title>
    </head>
    <body>
        
        <h5><a href="index.jsp">Home</a>><a href="create.jsp">Create Records</a></h5>
        <h1>Create Records</h1>
        <div>
            <ul id="menu">
                <li><a href="createCountry.jsp">Create Country Records</a></li>
                <li><a href="createCity.jsp">Create City Records</a></li>
                <li><a href="createCountryLanguage.jsp">Create Country-Language Records</a></li>
            </ul>
        </div>
    </body>
</html>
