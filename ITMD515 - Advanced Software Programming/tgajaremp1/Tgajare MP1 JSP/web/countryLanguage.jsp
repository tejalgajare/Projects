<%-- 
    Document   : countryLanguage
    Created on : Sep 20, 2013, 2:41:08 PM
    Author     : Tejal
This jsp helps in displaying all the records retrieved from the CountryLanguage table
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Country-Language Records</title>
        <link href="MP1_JSP_css.css" rel="stylesheet">
        <link href='http://fonts.googleapis.com/css?family=Strait' rel='stylesheet' type='text/css'>

    </head>
    <body>
        
        <h5><a href="index.jsp">Home</a>><a href="records.jsp">All Records</a>>Country-Language Records</h5>
       <h1>Country Language Records</h1>
        <sql:query dataSource="jdbc/tgajareMp1Jsp" var="records" sql="select * from CountryLanguage"></sql:query>
            <div id="tableRecords">      
                <table>
                    <thead>
                        <tr id="tableRecords_th">
                            <th>CountryCode</th>
                            <th>Language</th>
                            <th>IsOfficial</th>
                            <th>Percentage</th>
                            <th>Update Record</th>
                            <th>Delete Record</th>
                        </tr>
                    </thead>
                    <tbody>

                    <c:forEach items="${records.rows}" var="row">

                        <c:url value="/updateCountryLanguageRecord.jsp" var="update_url">
                            <c:param name="c_code" value="${row.CountryCode}"/>
                            <c:param name="lang" value="${row.Language}"/>
                        </c:url>
                        <c:url value="/deleteCountryLanguageRecord.jsp" var="delete_url">
                            <c:param name="c_code" value="${row.CountryCode}"/>
                            <c:param name="lang" value="${row.Language}"/>
                        </c:url>

                        <tr class="data">
                            <td>${row.CountryCode}</td>
                            <td>${row.Language}</td>
                            <td>${row.IsOfficial}</td>
                            <td><fmt:formatNumber type="percent" value="${row.Percentage}"/></td>
                            <td><a href="${update_url}">Update</a></td>
                            <td><a href="${delete_url}">Delete</a></td>

                        </tr>
                    </c:forEach>
                </tbody>
        </div>
    </table>
</body>
</html>
