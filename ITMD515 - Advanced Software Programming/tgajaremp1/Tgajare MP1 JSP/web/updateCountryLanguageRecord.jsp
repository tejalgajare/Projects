<%-- 
    Document   : updateCountryLanguageRecord
    Created on : Sep 20, 2013, 4:38:55 PM
    Author     : Tejal
This jsp updates a record for the CountryLanguage Table. The user is presented with
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
        <h5><a href="index.jsp">Home</a>><a href="records.jsp">All Records</a>><a href="countryLanguage.jsp">Country Language Records</a>>Update Country-Language Record</h5>
        <h1>Updating Country Language Record with country code ${param.c_code} having  ${param.lang} Language</h1>
        <c:choose>
            <c:when test="${pageContext.request.method == 'GET'}">

                <form action="updateCountryLanguageRecord.jsp" method="post">

                    <c:choose>
                        <c:when test="${not empty param.c_code && not empty param.lang}">
                            <h2>Update Country-Language Record Form</h2>

                            <sql:query var="result" dataSource="jdbc/tgajareMp1Jsp">
                                SELECT * FROM CountryLanguage where CountryCode = ? and Language = ?
                                <sql:param value="${param.c_code}"/>
                                <sql:param value="${param.lang}"/>
                            </sql:query>

                            <c:set var="crecord" value="${result.rows[0]}"/>
                        </c:when>
                    </c:choose>

                    <table id="formtable">
                        <tr><td><label for="CountryCode">Country Code:</label></td>
                            <td><input type="text" id="CountryCode" name="CountryCode" value="${crecord.CountryCode}" readonly="readonly"></td>
                        </tr>
                        <tr>
                            <td><label for="Language">Language:</label></td>
                           <td> <input type="text" id="Language" name="Language" value="${crecord.Language}" readonly="readonly"></td>
                         </tr>
                        <tr>
                           <td> <label for="IsOfficial">Is Language Official True/False:</label></td>
                           <td> <input type="text" id="IsOfficial" name="IsOfficial" value="${crecord.IsOfficial}"></td>
                         </tr>
                        <tr>
                          <td>  <label for="Percentage">Percentage:</label></td>
                          <td>  <input type="text" id="Percentage" name="Percentage" value="${crecord.Percentage}"></td>
                         </tr>
                        <tr>

                       <td> <input type="submit" value="submit"/></td>
                    </tr>
                    </table>
                </form>
            </c:when>
            <c:when test="${pageContext.request.method == 'POST'}">
                <sql:update dataSource="jdbc/tgajareMp1Jsp" var="result">
                    update CountryLanguage set 
                    IsOfficial = ?,
                    Percentage = ?
                    where CountryCode = ? and Language = ?
                    <sql:param value="${param.IsOfficial}"/>
                    <sql:param value="${param.Percentage}"/>
                    <sql:param value="${param.CountryCode}"/>
                    <sql:param value="${param.Language}"/>
                </sql:update>

                <c:redirect url="countryLanguage.jsp"></c:redirect>
            </c:when>
        </c:choose>
    </body>
</html>
