<%-- 
    Document   : country
    Created on : Sep 20, 2013, 2:39:01 PM
    Author     : Tejal
This jsp helps in displaying all the records retrieved from the Country table
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Country Records</title>
        <link href="MP1_JSP_css.css" rel="stylesheet">
        <link href='http://fonts.googleapis.com/css?family=Strait' rel='stylesheet' type='text/css'>

    </head>
    <body>
        
        <h5><a href="index.jsp">Home</a>><a href="records.jsp">All Records</a>>Country Records</h5>
        <h1>Country Records</h1>
        <sql:query dataSource="jdbc/tgajareMp1Jsp" var="records" sql="select * from Country"></sql:query>
         <div id="tableRecords">    
        <table>
                <thead>
                    <tr id="tableRecords_th">
                        <th>Code</th>
                        <th>Name</th>
                        <th>Continent</th>
                        <th>Region</th>
                        <th>SurfaceArea</th>
                        <th>IndepYear</th>
                        <th>Population</th>
                        <th>LifeExpectancy</th>
                        <th>GNP</th>
                        <th>GNPOld</th>
                        <th>LocalName</th>
                        <th>GovernmentForm</th>
                        <th>HeadOfState</th>
                        <th>Capital</th>
                        <th>Code2</th>
                        <th>Update Record</th>
                        <th>Delete Record</th>
                    </tr>
                </thead>
                <tbody>

                <c:forEach items="${records.rows}" var="row">

                    <c:url value="/updateCountryRecord.jsp" var="update_url">
                        <c:param name="CountryCode" value="${row.code}"/>
                    </c:url>
                    <c:url value="/deleteCountryRecord.jsp" var="delete_url">
                        <c:param name="CountryCode" value="${row.code}"/>
                    </c:url>

                    <tr class="data">
                        <td>${row.code}</td>
                        <td>${row.Name}</td>
                        <td>${row.Continent}</td>
                        <td>${row.Region}</td>
                        <td>${row.SurfaceArea}</td>
                        <td>${row.IndepYear}</td>
                        <td>${row.Population}</td>
                        <td>${row.LifeExpectancy}</td>
                        <td>${row.GNP}</td>
                        <td>${row.GNPOld}</td>
                        <td>${row.LocalName}</td>
                        <td>${row.GovernmentForm}</td>
                        <td>${row.HeadOfState}</td>
                        <td>${row.Capital}</td>
                        <td>${row.Code2}</td>
                        <td><a href="${update_url}">Update</a></td>
                        <td><a href="${delete_url}">Delete</a></td>

                    </tr>
                </c:forEach>
            </tbody>
         </div>
        </table>
    </body>
</html>
