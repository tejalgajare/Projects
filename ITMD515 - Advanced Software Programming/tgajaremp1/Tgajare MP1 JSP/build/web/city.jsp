<%-- 
    Document   : city
    Created on : Sep 20, 2013, 2:39:10 PM
    Author     : Tejal

    This jsp helps in displaying all the reocrds retrieved from the City table
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="MP1_JSP_css.css" rel="stylesheet">
        <link href='http://fonts.googleapis.com/css?family=Strait' rel='stylesheet' type='text/css'>
        <title>City Records</title>
    </head>
    <body>
        
        <h5><a href="index.jsp">Home</a>><a href="records.jsp">All Records</a>><a href="city.jsp">City Records</a></h5>
       <h1>City Records</h1>
        <sql:query dataSource="jdbc/tgajareMp1Jsp" var="records" sql="select * from City"></sql:query>
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

                <c:forEach items="${records.rows}" var="row">

                    <c:url value="/updateCityRecord.jsp" var="update_url">
                        <c:param name="city_id" value="${row.ID}"/>
                    </c:url>
                    <c:url value="/deleteCityRecord.jsp" var="delete_url">
                        <c:param name="city_id" value="${row.ID}"/>
                    </c:url>

                    <tr class="data">
                        <td>${row.ID}</td>
                        <td>${row.Name}</td>
                        <td>${row.CountryCode}</td>
                        <td>${row.District}</td>
                      
                        <td><fmt:formatNumber groupingUsed="true" value="${row.Population}"/></td> 
                        <td><a href="${update_url}">Update</a></td>
                        <td><a href="${delete_url}">Delete</a></td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>
        </div>
    </body>
</html>
