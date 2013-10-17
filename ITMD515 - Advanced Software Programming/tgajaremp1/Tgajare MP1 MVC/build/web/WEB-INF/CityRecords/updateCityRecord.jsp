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
        <title>Update City Record</title>
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

        <form action="<c:url value="/UpdateCityRecord"/>" method="post">

           <c:import url="/WEB-INF/CityRecords/navigator.jsp"/>
           <table id="formtable">
                <h2>Update Record Form</h2>
                <tr>
                    <td> <label for="ID">City ID:</label></td> 
                    <td> <input type="text" id="ID" name="ID" value="${ID}" readonly="readonly"></td> 
                </tr>
                <tr>
                    <td> <label for="Name">City Name:</label></td> 
                    <td> <input type="text" id="Name" name="Name" value="${Name}"></td> 
                </tr>
                <tr>
                   <td>  <label for="CountryCode">Country Code:</label></td> 
                   <td>  <input type="text" id="CountryCode" name="CountryCode" value="${CountryCode}"></td> 
                </tr>
                <tr>
                   <td>  <label for="District">District:</label></td> 
                   <td>  <input type="text" id="District" name="District" value="${District}"></td> 
               </tr>
                <tr>
                    <td> <label for="Population">Population:</label></td> 
                    <td> <input type="text" id="Population" name="Population" value="${Population}"></td> 
                </tr>
                <tr>

                <td> <input type="submit" value="Submit"/></td> 
           </tr>
           </table>
        </form>

        
    </body>
</html>
