<%-- 
    Document   : createCountryLanguage
    Created on : Sep 20, 2013, 10:41:54 PM
    Author     : Tejal
This jsp creates a new record for the CountryLanguage Table. The user is presented with
    a form to enter values.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Country Language Record</title>
        <link href="MP1_JSP_css.css" rel="stylesheet">
        <link href='http://fonts.googleapis.com/css?family=Strait' rel='stylesheet' type='text/css'>

    </head>
    <body>
        <h5><a href="index.jsp">Home</a>><a href="create.jsp">Create Records</a>>Create Country Language Record</h5>

        <c:choose>
            <c:when test="${pageContext.request.method == 'GET'}">

                <form action="createCountryLanguage.jsp" method="post">

                    <h2>Create Country-Language Record Form</h2>
                    <table id="formtable">
                        <tr><td><label for="CountryCode">Country Code:</label></td>
                            <td><input type="text" id="CountryCode" name="CountryCode"></td>
                        </tr>
                        <tr>
                            <td><label for="Language">Language:</label></td>
                            <td><input type="text" id="Language" name="Language"></td>
                        </tr>
                        <tr>
                            <td><label for="IsOfficial">Is Language Official True/False:</label></td>
                            <td><input type="text" id="IsOfficial" name="IsOfficial"></td>
                        </tr>
                        <tr>
                            <td><label for="Percentage">Percentage:</label></td>
                            <td><input type="text" id="Percentage" name="Percentage"></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="submit"/></td></tr>
                    </table>
                </form>
            </c:when>
            <c:when test="${pageContext.request.method == 'POST'}">
                <c:catch var ="catchException">
                    <sql:update dataSource="jdbc/tgajareMp1Jsp" var="result">
                        insert into CountryLanguage values(?,?,?,?) 
                        <sql:param value="${param.CountryCode}"/>
                        <sql:param value="${param.Language}"/>
                        <sql:param value="${param.IsOfficial}"/>
                        <sql:param value="${param.Percentage}"/>

                    </sql:update>
                </c:catch>
                <c:choose>
                    <c:when test = "${catchException != null}">
                        <p>The exception is : ${catchException} <br />
                            There is an exception: ${catchException.message}</p>
                        <p><em>Tip: Please enter unique country code and language!</em></p>
                        <a href="createCountryLanguage.jsp">Go Back</a>
                    </c:when>  
                    <c:otherwise>
                        <c:redirect url="countryLanguage.jsp"></c:redirect>
                    </c:otherwise>
                </c:choose>

            </c:when>
        </c:choose>
    </body>
</html>
