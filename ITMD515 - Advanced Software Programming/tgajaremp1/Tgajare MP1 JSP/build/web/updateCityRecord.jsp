<%-- 
    Document   : updateCityRecord
    Created on : Sep 20, 2013, 4:38:30 PM
    Author     : Tejal
This jsp updates a record for the City Table. The user is presented with
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
        <h5><a href="index.jsp">Home</a>><a href="records.jsp">All Records</a>><a href="city.jsp">City Records</a>>Update City Record</h5>
        <h1>Updating city record with ID ${param.city_id}</h1>
        <c:choose>
            <c:when test="${pageContext.request.method == 'GET'}">
                <form action="updateCityRecord.jsp" method="post">
                   
                        <c:choose>
                            <c:when test="${not empty param.city_id}">
                                <h2>Update City Record Form</h2>

                                <sql:query var="result" dataSource="jdbc/tgajareMp1Jsp">
                                    SELECT * FROM City where ID = ?

                                    <sql:param value="${param.city_id}"/>
                                </sql:query>

                                <c:set var="crecord" value="${result.rows[0]}"/>
                            </c:when>
                        </c:choose>

                       <table id="formtable">
                           <tr><td><label for="ID">City ID:</label></td>
                               <td><input type="text" id="ID" name="ID" value="${crecord.ID}" readonly="readonly"></td>
                        </tr>
                        <tr>
                           <td> <label for="Name">City Name:</label></td>
                           <td> <input type="text" id="Name" name="Name" value="${crecord.Name}"></td>
                        </tr>
                        <tr>
                            <td><label for="CountryCode">Country Code:</label></td>
                           <td> <input type="text" id="CountryCode" name="CountryCode" value="${crecord.CountryCode}"></td>
                        </tr>
                        <tr>
                           <td> <label for="District">District:</label></td>
                            <td><input type="text" id="District" name="District" value="${crecord.District}"></td>
                        </tr>
                        <tr>
                           <td> <label for="Population">Population:</label></td>
                           <td> <input type="text" id="Population" name="Population" value="${crecord.Population}"></td>
                        </tr>
                        <tr>

                        <td><input type="submit" value="submit"/></td>
                        </tr>
                        
                       </table>
                </form>
            </c:when>
            <c:when test="${pageContext.request.method == 'POST'}">
                <c:catch var ="catchException">
                    <sql:update dataSource="jdbc/tgajareMp1Jsp" var="result">
                        update City set 
                        Name = ?,
                        CountryCode = ?,
                        District = ?,
                        Population = ?

                        where ID = ?
                        <sql:param value="${param.Name}"/>
                        <sql:param value="${param.CountryCode}"/>
                        <sql:param value="${param.District}"/>
                        <sql:param value="${param.Population}"/>

                        <sql:param value="${param.ID}"/>
                    </sql:update>
                </c:catch>
                <c:choose>
                    <c:when test = "${catchException != null}">
                        <p>The exception is : ${catchException} <br />
                            There is an exception: ${catchException.message}</p>
                        <p><em>Tip: Please enter correct/existing country code!</em></p>
                        <a href="city.jsp">Goto City Records</a>
                    </c:when>  
                    <c:otherwise>
                        <c:redirect url="city.jsp"></c:redirect>
                    </c:otherwise>
                </c:choose>
            </c:when>
        </c:choose>
    </body>
</html>
