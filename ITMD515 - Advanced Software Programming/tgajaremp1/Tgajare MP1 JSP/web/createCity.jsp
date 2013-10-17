<%-- 
    Document   : createCity
    Created on : Sep 20, 2013, 10:37:43 PM
    Author     : Tejal
    This jsp creates a new record for the City Table. The user is presented with
    a form to enter values.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create City Record</title>
        <link href="MP1_JSP_css.css" rel="stylesheet">
        <link href='http://fonts.googleapis.com/css?family=Strait' rel='stylesheet' type='text/css'>

    </head>
    <body>
        <h5><a href="index.jsp">Home</a>><a href="create.jsp">Create Records</a>>Create City Records</h5>

        <c:choose>
            <c:when test="${pageContext.request.method == 'GET'}">
                <form action="createCity.jsp" method="post">
                  

                        <h2>Create City Record Form</h2>
                        <table id="formtable">
                            <tr><td><label for="ID">City ID:</label></td>
                                <td><input type="text" id="ID" name="ID"></td>
                       </tr>
                        <tr>
                            <td><label for="Name">City Name:</label></td>
                            <td><input type="text" id="Name" name="Name"></td>
                        </tr>
                        <tr>
                           <td> <label for="CountryCode">Country Code:</label></td>
                            <td><input type="text" id="CountryCode" name="CountryCode"></td>
                        </tr>
                        <tr>
                           <td> <label for="District">District:</label></td>
                           <td> <input type="text" id="District" name="District"></td>
                       </tr>
                        <tr>
                            <td><label for="Population">Population:</label></td>
                            <td><input type="text" id="Population" name="Population"></td>
                        </div></tr>
                        <tr>

                        <td><input type="submit" value="submit"/></td>
                        </tr>
                        </table>
                   
                </form>
            </c:when>
            <c:when test="${pageContext.request.method == 'POST'}">
                <c:catch var ="catchException">
                    <sql:update dataSource="jdbc/tgajareMp1Jsp" var="result">
                        insert into City values(?,?,?,?,?) 
                        <sql:param value="${param.ID}"/>
                        <sql:param value="${param.Name}"/>
                        <sql:param value="${param.CountryCode}"/>
                        <sql:param value="${param.District}"/>
                        <sql:param value="${param.Population}"/>    
                    </sql:update>
                </c:catch>
                <c:choose>
                    <c:when test = "${catchException != null}">
                        <p>The exception is : ${catchException} <br />
                            There is an exception: ${catchException.message}</p>
                        <p><em>Tip: Please enter unique city ID and existing country code!</em></p>
                        <a href="createCity.jsp">Go Back</a>
                    </c:when>  
                    <c:otherwise>
                        <c:redirect url="city.jsp"></c:redirect>
                    </c:otherwise>
                </c:choose>
            </c:when>
        </c:choose>
    </body>
</html>
