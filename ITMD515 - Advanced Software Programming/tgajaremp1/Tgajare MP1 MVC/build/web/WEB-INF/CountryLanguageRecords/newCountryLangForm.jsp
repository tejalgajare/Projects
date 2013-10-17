<%-- 
    Document   : createCountry
    Created on : Sep 20, 2013, 10:37:31 PM
    Author     : Tejal
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Country Lang Record</title>
         <link href="MP1_MVC_css.css" rel="stylesheet">
        <link href='http://fonts.googleapis.com/css?family=Strait' rel='stylesheet' type='text/css'>


    </head>
    <body>

        <c:if test="${not empty violations}">
            <span style="color: red;">
                <ul>
                    <c:forEach items="${violations}" var="violation">
                        <li>${violation.message}</li>
                        </c:forEach>
                </ul>
            </span>
        </c:if>

        <form action="<c:url value="/NewCountryLangRecord"/>" method="post">

       <c:import url="/WEB-INF/CountryLanguageRecords/navigator.jsp"/>
                <h2>New Record Form</h2>
                 <table id="formtable">
                <tr>
                    <td>  <label for="CountryCode">Country Code:</label></td>
                    <td><input type="text" id="CountryCode" name="CountryCode"></td>
                </tr>
                <tr>
                   <td> <label for="Language">Language:</label></td>
                   <td> <input type="text" id="Language" name="Language"></td>
                </tr>
                <tr>
                  <td>  <label for="IsOfficial">Is Language Official True/False:</label></td>
                  <td>  <input type="text" id="IsOfficial" name="IsOfficial"></td>
                </tr>
                <tr>
                   <td> <label for="Percentage">Percentage:</label></td>
                  <td>  <input type="text" id="Percentage" name="Percentage"></td>
               </tr>
                <tr>

                    <td><input type="submit" value="Submit"/></td>
                </tr>
               
                 </table>
        </form>

        
    </body>
</html>
