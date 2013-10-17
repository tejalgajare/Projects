<%-- 
    Document   : showAll
    Created on : Sep 21, 2013, 5:08:01 PM
    Author     : Tejal
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>City Records</title>
        <link href="MP1_MVC_css.css" rel="stylesheet">
        <link href='http://fonts.googleapis.com/css?family=Strait' rel='stylesheet' type='text/css'>

    </head>
    <body>
         <c:import url="/WEB-INF/CityRecords/navigator.jsp"/>
         <h1>City Records</h1>
       
       <div id="tableRecords"> 
            <table>
                <thead>
                    <tr id="tableRecords_th">
                        <th>ID</th>
                        <th>Name</th>
                        <th>CountryCode</th>
                        <th>District</th>
                        <th>Population</th>
                     
                        <th>Update Record</th>
                        <th>Delete Record</th>
                        
                    </tr>
                </thead>
                <tbody>

                <c:forEach items="${requestScope.records}" var="record">

                    <c:url value="/UpdateCityRecord" var="update_url">
                        <c:param name="ID" value="${record.vID}"/>
                        
                    </c:url>
                    <c:url value="/DeleteCityRecord" var="delete_url">
                        <c:param name="ID" value="${record.vID}"/>
                    </c:url>

                    <tr class="data">
                        <td>${record.vID}</td>
                        <td>${record.name}</td>
                        <td>${record.countryCode}</td>
                        <td>${record.district}</td>
                      
                        <td><fmt:formatNumber groupingUsed="true" value="${record.population}"/></td>
                        <td><a href="${update_url}">Update</a></td>
                        <td><a href="${delete_url}">Delete</a></td>
                        
                        
                    </tr>
                </c:forEach>
            </tbody>
        </table>
       </div>
    </body>
</html>
