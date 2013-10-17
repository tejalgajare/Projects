<%-- 
    Document   : createCountry
    Created on : Sep 20, 2013, 10:37:31 PM
    Author     : Tejal
This jsp creates a new record for the Country Table. The user is presented with
    a form to enter values.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       
        <title>Create Country Record</title>
        <link href="../../MP1_JSP_css.css" rel="stylesheet">
        <link href='http://fonts.googleapis.com/css?family=Strait' rel='stylesheet' type='text/css'>


    </head>
    <body>
        <h5><a href="index.jsp">Home</a>><a href="create.jsp">Create Records</a>>Create Country Record</h5>

        <c:choose>
            <c:when test="${pageContext.request.method == 'GET'}">
                <form action="createCountry.jsp" method="post">
               
                        <h2>Create Country Record Form</h2>
                        <table id="formtable">
                            <tr><td><label for="Code">Country Code:</label></td>
                                <td><input type="text" id="Code" name="Code"></td>
                            </tr>
                            <tr>
                                <td><label for="Name">Country Name:</label></td>
                                <td><input type="text" id="Name" name="Name"></td>
                            </tr>
                            <tr>
                                <td><label for="Continent">Continent:</label></td>
                                <td><input type="select" id="Continent" name="Continent"></td>

                            </tr>
                            <tr>
                                <td><label for="Region">Region:</label>
                                <td><input type="text" id="Region" name="Region"></td>
                            </tr>
                            <tr>
                                <td><label for="SurfaceArea">Surface Area:</label></td>
                                <td><input type="text" id="SurfaceArea" name="SurfaceArea"></td>
                            </tr>
                            <tr>
                                <td><label for="IndepYear">Independence Year:</label></td>
                                <td><input type="text" id="IndepYear" name="IndepYear"></td>
                            </tr>
                            <tr>
                                <td><label for="Population">Population:</label></td>
                                <td><input type="text" id="Population" name="Population"></td>
                            </tr>
                            <tr>
                                <td><label for="LifeExpectancy">Life Expectancy:</label></td>
                                <td><input type="text" id="LifeExpectancy" name="LifeExpectancy"></td>
                            </tr>
                            <tr>
                                <td><label for="GNP">GNP:</label></td>
                                <td><input type="text" id="GNP" name="GNP"></td>
                            </tr>
                            <tr>
                                <td><label for="GNPOld">GNPOld :</label></td>
                                <td><input type="text" id="GNPOld" name="GNPOld"></td>
                            </tr>
                            <tr>
                                <td><label for="LocalName">Local Name:</label></td>
                                <td><input type="text" id="LocalName" name="LocalName"></td>
                            </tr>
                            <tr>
                                <td><label for="GovernmentForm">Government Form: </label></td>
                                <td><input type="text" id="GovernmentForm" name="GovernmentForm"></td>
                            </tr>
                            <tr>
                                <td><label for="HeadOfState">Head Of State:</label></td>
                                <td><input type="text" id="HeadOfState" name="HeadOfState"></td>
                            </tr>
                            <tr>
                                <td> <label for="Capital">Capital:</label></td>
                                <td> <input type="text" id="Capital" name="Capital"></td>
                            </tr>
                            <tr>
                                <td><label for="Code2">Code 2:</label></td>
                                <td><input type="text" id="Code2" name="Code2"></td>
                            </tr>
                            <tr>

                                <td><input type="submit" value="Create"/></td></tr>

                        </table>


                   
                </form>
            </c:when>
            <c:when test="${pageContext.request.method == 'POST'}">
                <c:catch var ="catchException">
                    <sql:update dataSource="jdbc/tgajareMp1Jsp" var="result">
                        insert into Country values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)

                        <sql:param value="${param.Code}"/>
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

                    </sql:update>
                </c:catch>
                <c:choose>
                    <c:when test = "${catchException != null}">
                        <p>The exception is : ${catchException} <br />
                            There is an exception: ${catchException.message}</p>
                        <p><em>Tip: Country Code should be unique !</em></p>
                        <a href="createCountry.jsp">Go Back</a>
                    </c:when>  
                    <c:otherwise>
                        <c:redirect url="country.jsp"></c:redirect>
                    </c:otherwise>
                </c:choose>

            </c:when>
        </c:choose>
    </body>
</html>
