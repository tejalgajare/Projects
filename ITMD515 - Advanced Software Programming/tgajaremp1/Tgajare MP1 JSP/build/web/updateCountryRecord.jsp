<%-- 
    Document   : updateCountryRecord
    Created on : Sep 20, 2013, 4:37:49 PM
    Author     : Tejal
This jsp updates a record for the Country Table. The user is presented with
    a form containing the existing values which could be updated after form submission.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Record</title>
          <link href="MP1_JSP_css.css" rel="stylesheet">
        <link href='http://fonts.googleapis.com/css?family=Strait' rel='stylesheet' type='text/css'>

    </head>
    <body>
        <h5><a href="index.jsp">Home</a>><a href="records.jsp">All Records</a>><a href="country.jsp">Country Records</a>>Update Country Record</h5>
        <h1>Updating record with code ${param.CountryCode}</h1>

        <c:choose>
            <c:when test="${pageContext.request.method == 'GET'}">
                <!-- if it is a GET, read the data and render update form -->
                <form action="updateCountryRecord.jsp" method="post">

                    <c:choose>
                        <c:when test="${not empty param.CountryCode}">
                            <h2>Update Country Record Form</h2>

                            <sql:query var="result" dataSource="jdbc/tgajareMp1Jsp">
                                SELECT * FROM Country where code = ?

                                <sql:param value="${param.CountryCode}"/>
                            </sql:query>

                            <c:set var="crecord" value="${result.rows[0]}"/>
                        </c:when>
                    </c:choose>
                    <table id="formtable">
                        <tr>
                            <td> <label for="Code">Country Code</label></td>
                            <td><input type="text" id="Code" name="Code" value="${crecord.Code}" readonly="readonly"></td>
                       </tr>
                        <tr>
                           <td> <label for="Name">Country Name:</label></td>
                           <td> <input type="text" id="Name" name="Name" value="${crecord.Name}"></td>
                       </tr>
                        <tr>
                            <td><label for="Continent">Continent:</label></td>
                            <td><input type="text" id="Continent" name="Continent" value="${crecord.Continent}"></td>
                        </tr>
                        <tr>
                           <td> <label for="Region">Region:</label></td>
                           <td> <input type="text" id="Region" name="Region" value="${crecord.Region}"></td>
                        </tr>
                        <tr>
                           <td> <label for="SurfaceArea">Surface Area:</label></td>
                           <td> <input type="text" id="SurfaceArea" name="SurfaceArea" value="${crecord.SurfaceArea}"></td>
                        </tr>
                        <tr>
                           <td> <label for="IndepYear">Independence Year:</label></td>
                           <td> <input type="text" id="IndepYear" name="IndepYear" value="${crecord.IndepYear}"></td>
                       </tr>
                        <tr>
                           <td> <label for="Population">Population:</label></td>
                           <td> <input type="text" id="Population" name="Population" value="${crecord.Population}"></td>
                       </tr>
                        <tr>
                           <td> <label for="LifeExpectancy">Life Expectancy:</label></td>
                           <td> <input type="text" id="LifeExpectancy" name="LifeExpectancy" value="${crecord.LifeExpectancy}"></td>
                       </tr>
                        <tr>
                           <td> <label for="GNP">GNP:</label></td>
                           <td> <input type="text" id="GNP" name="GNP" value="${crecord.GNP}"></td>
                        </tr>
                        <tr>
                           <td> <label for="GNPOld">GNPOld :</label></td>
                           <td> <input type="text" id="GNPOld" name="GNPOld" value="${crecord.GNPOld}"></td>
                        </tr>
                        <tr>
                            <td><label for="LocalName">Local Name:</label></td>
                           <td> <input type="text" id="LocalName" name="LocalName" value="${crecord.LocalName}"></td>
                        </tr>
                        <tr>
                            <td><label for="GovernmentForm">Government Form: </label></td>
                            <td><input type="text" id="GovernmentForm" name="GovernmentForm" value="${crecord.GovernmentForm}"></td>
                        </tr>
                        <tr>
                            <td><label for="HeadOfState">Head Of State:</label></td>
                            <td><input type="text" id="HeadOfState" name="HeadOfState" value="${crecord.HeadOfState}"></td>
                        </tr>
                        <tr>
                            <td><label for="Capital">Capital:</label></td>
                            <td><input type="text" id="Capital" name="Capital" value="${crecord.Capital}"></td>
                        </tr>
                        <tr>
                           <td> <label for="Code2">Code 2:</label></td>
                           <td> <input type="text" id="Code2" name="Code2" value="${crecord.Code2}"></td>
                        </tr>
                        <tr>
                        <td><input type="submit" value="submit"/></td>
                        </tr>
                    </table>
                </form>
            </c:when>
            <c:when test="${pageContext.request.method == 'POST'}">
                <sql:update dataSource="jdbc/tgajareMp1Jsp" var="result">
                    update Country set 
                    Name = ?,
                    Continent = ?,
                    Region = ?,
                    SurfaceArea = ?,
                    IndepYear = ?,
                    Population = ?,
                    LifeExpectancy = ?,
                    GNP = ?,
                    GNPOld = ?,
                    LocalName = ?,
                    GovernmentForm = ?,
                    HeadOfState = ?,
                    Capital = ?,
                    Code2 = ?
                    where Code = ?
                    <sql:param value="${param.Name}"/>
                    <sql:param value="${param.Continent}"/>
                    <sql:param value="${param.Region}"/>
                    <sql:param value="${param.SurfaceArea}"/>
                    <sql:param value="${not empty param.IndepYear ? param.IndepYear : null }"/>
                    <sql:param value="${param.Population}"/>
                    <sql:param value="${not empty param.LifeExpectancy ? param.LifeExpectancy : null }"/>
                    <sql:param value="${param.GNP}"/>
                    <sql:param value="${not empty param.GNPOld ? param.GNPOld : null }"/>
                    <sql:param value="${param.LocalName}"/>
                    <sql:param value="${param.GovernmentForm}"/>
                    <sql:param value="${param.HeadOfState}"/>
                    <sql:param value="${param.Capital}"/>
                    <sql:param value="${param.Code2}"/>
                    <sql:param value="${param.Code}"/>
                </sql:update>

                <c:redirect url="country.jsp"></c:redirect>
            </c:when>
        </c:choose>
    </body>
</html>
