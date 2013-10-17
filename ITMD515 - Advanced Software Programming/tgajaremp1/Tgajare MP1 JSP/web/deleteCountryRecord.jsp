<%-- 
    Document   : deleteCountryRecord
    Created on : Sep 20, 2013, 3:09:43 PM
    Author     : Tejal
This jsp deletes a record from the Country Table depending on the user's selected record.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Record</title>
         <link href="MP1_JSP_css.css" rel="stylesheet">
        <link href='http://fonts.googleapis.com/css?family=Strait' rel='stylesheet' type='text/css'>

    </head>
    <body>
     <h5><a href="index.jsp">Home</a>><a href="records.jsp">All Records</a>><a href="country.jsp">Country Records</a>>Delete Country Record</h5>
        <h1>Deleting country record with code ${param.CountryCode}</h1>
       
       <sql:update dataSource="jdbc/tgajareMp1Jsp" sql="delete from Country where code = ?">
            <sql:param value="${param.CountryCode}"></sql:param>
        </sql:update>
        
        <c:redirect url="/country.jsp"></c:redirect>
       
    </body>
</html>
