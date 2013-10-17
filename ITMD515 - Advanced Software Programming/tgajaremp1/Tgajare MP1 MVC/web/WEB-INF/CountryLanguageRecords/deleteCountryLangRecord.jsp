<%-- 
    Document   : deleteCountryRecord
    Created on : Sep 20, 2013, 3:09:43 PM
    Author     : Tejal
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Record</title>
          <link href="MP1_MVC_css.css" rel="stylesheet">
        <link href='http://fonts.googleapis.com/css?family=Strait' rel='stylesheet' type='text/css'>

    </head>
    <body>
        <h5><c:import url="/WEB-INF/CountryLanguageRecords/navigator.jsp"/></h5>
        <h1>Country record with code ${param.c_code} and language ${param.lang} deleted!</h1>
       
      
        
       <%-- <c:redirect url="/showCountryRecords"></c:redirect> --%>
       
    </body>
</html>
