<%-- 
    Document   : deleteCountryLanguageRecord
    Created on : Sep 20, 2013, 3:10:18 PM
    Author     : Tejal
This jsp deletes a record from the CountryLanguage Table depending on the user's selected record.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="MP1_JSP_css.css" rel="stylesheet">
        <link href='http://fonts.googleapis.com/css?family=Strait' rel='stylesheet' type='text/css'>

        <title>Delete Record</title>
    </head>
    <body>
         <h5><a href="index.jsp">Home</a>><a href="records.jsp">All Records</a>><a href="countryLanguage.jsp">Country-Language Records</a>>Delete Country-Language Record</h5>
        <h1>Deleting record with country code ${param.c_code} having  ${param.lang} Language</h1>
       
       <sql:update dataSource="jdbc/tgajareMp1Jsp" sql="delete from CountryLanguage where CountryCode = ? and Language = ?">
            <sql:param value="${param.c_code}"></sql:param>
            <sql:param value="${param.lang}"></sql:param>
        </sql:update>
        
        <c:redirect url="/countryLanguage.jsp"></c:redirect>
  
    </body>
</html>
