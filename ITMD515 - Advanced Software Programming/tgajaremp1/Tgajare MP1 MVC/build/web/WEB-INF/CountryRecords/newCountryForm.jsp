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
        <title>Create Country Record</title>
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
    <c:import url="/WEB-INF/CountryRecords/navigator.jsp"/>
        <form action="<c:url value="/NewCountryRecord"/>" method="post">


            <h2>New Record Form</h2>
            <table id="formtable">
                <tr>
                    <td><label for="Code">Country Code:</label></td>
                    <td><input type="text" id="Code" name="Code" value="${record.code}" ${not empty record.code ? 'readonly="readonly"' : ''}></td>
                </tr>
                <tr>
                    <td><label for="Name">Country Name:</label></td>
                    <td><input type="text" id="Name" name="Name" value="${record.Name}"></td>
                </tr>
                <tr>
                    <td><label for="Continent">Continent:</label></td>
                    <td><input type="select" id="Continent" name="Continent" value="${record.Continent}"></td>

                </tr>
                <tr>
                    <td><label for="Region">Region:</label></td>
                    <td><input type="text" id="Region" name="Region" value="${record.Region}"></td>
                </tr>
                <tr>
                    <td><label for="SurfaceArea">Surface Area:</label></td>
                    <td><input type="text" id="SurfaceArea" name="SurfaceArea" value="${record.SurfaceArea}"></td>
                </tr>
                <tr>
                    <td><label for="IndepYear">Independence Year:</label></td>
                    <td><input type="text" id="IndepYear" name="IndepYear" value="${record.IndepYear}"></td>
                </tr>
                <tr>
                    <td><label for="Population">Population:</label></td>
                    <td><input type="text" id="Population" name="Population" value="${record.Population}"></td>
                </tr>
                <tr>
                    <td><label for="LifeExpectancy">Life Expectancy:</label></td>
                    <td><input type="text" id="LifeExpectancy" name="LifeExpectancy" value="${record.LifeExpectancy}"></td>
                </tr>
                <tr>
                    <td><label for="GNP">GNP:</label></td>
                    <td><input type="text" id="GNP" name="GNP" value="${record.GNP}"></td>
                </tr>
                <tr>
                    <td><label for="GNPOld">GNPOld :</label></td>
                    <td><input type="text" id="GNPOld" name="GNPOld" value="${record.GNPOld}"></td>
                </tr>
                <tr>
                    <td><label for="LocalName">Local Name:</label></td>
                    <td><input type="text" id="LocalName" name="LocalName" value="${record.LocalName}"></td>
                </tr>
                <tr>
                    <td><label for="GovernmentForm">Government Form: </label></td>
                    <td><input type="text" id="GovernmentForm" name="GovernmentForm" value="${record.GovernmentForm}"></td>
                </tr>
                <tr>
                    <td><label for="HeadOfState">Head Of State:</label></td>
                    <td><input type="text" id="HeadOfState" name="HeadOfState" value="${record.HeadOfState}"></td>
                </tr>
                <tr>
                    <td><label for="Capital">Capital:</label></td>
                    <td><input type="text" id="Capital" name="Capital" value="${record.Capital}"></td>
                </tr>
                <tr>
                    <td><label for="Code2">Code 2:</label></td>
                    <td><input type="text" id="Code2" name="Code2" value="${record.Code2}"></td>
                </tr>
                <tr>

                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form>

        
    </body>
</html>
