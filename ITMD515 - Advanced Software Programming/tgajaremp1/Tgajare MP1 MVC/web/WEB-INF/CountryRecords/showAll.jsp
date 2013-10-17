<%-- 
    Document   : showAll
    Created on : Sep 21, 2013, 5:08:01 PM
    Author     : Tejal
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Country Records</title>
         <link href="MP1_MVC_css.css" rel="stylesheet">
        <link href='http://fonts.googleapis.com/css?family=Strait' rel='stylesheet' type='text/css'>

    </head>
    <body>
         <c:import url="/WEB-INF/CountryRecords/navigator.jsp"/>
         <h1>Country Records</h1>
      
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

                <c:forEach items="${requestScope.records}" var="record">

                    <c:url value="/UpdateCountryRecord" var="update_url">
                        <c:param name="UCountryCode" value="${record.code}"/>
                        
                    </c:url>
                    <c:url value="/DeleteCountryRecord" var="delete_url">
                        <c:param name="CountryCode" value="${record.code}"/>
                    </c:url>

                    <tr class="data">
                        <td>${record.code}</td>
                        <td>${record.name}</td>
                        <td>${record.continent}</td>
                        <td>${record.region}</td>
                        <td>${record.surfaceArea}</td>
                        <td>${record.indepYear}</td>
                        <td>${record.population}</td>
                        <td>${record.lifeExpectancy}</td>
                        <td>${record.vGNP}</td>
                        <td>${record.vGNPOld}</td>
                        <td>${record.localName}</td>
                        <td>${record.governmentForm}</td>
                        <td>${record.headOfState}</td>
                        <td>${record.capital}</td>
                        <td>${record.code2}</td>
                        <td><a href="${update_url}">Update</a></td>
                        <td><a href="${delete_url}">Delete</a></td>
                        
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        </div>
    </body>
</html>
