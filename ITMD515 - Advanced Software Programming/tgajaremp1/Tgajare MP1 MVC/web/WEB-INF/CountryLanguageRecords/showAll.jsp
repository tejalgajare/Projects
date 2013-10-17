<%-- 
    Document   : showAll
    Created on : Sep 21, 2013, 5:08:01 PM
    Author     : Tejal
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Country Language Records</title>
        <link href="MP1_MVC_css.css" rel="stylesheet">
        <link href='http://fonts.googleapis.com/css?family=Strait' rel='stylesheet' type='text/css'>

    </head>
    <body>
        <c:import url="/WEB-INF/CountryRecords/navigator.jsp"/>
        <h1>Country Language Records</h1>

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

                    <c:forEach items="${requestScope.records}" var="record">

                        <c:url value="/UpdateCountryLangRecord" var="update_url">
                            <c:param name="c_code" value="${record.countryCode}"/>
                            <c:param name="lang" value="${record.language}"/>
                        </c:url>
                        <c:url value="/DeleteCountryLangRecord" var="delete_url">
                            <c:param name="c_code" value="${record.countryCode}"/>
                            <c:param name="lang" value="${record.language}"/>
                        </c:url>

                        <tr class="data">
                            <td>${record.countryCode}</td>
                            <td>${record.language}</td>
                            <td>${record.isOfficial}</td>
                            <td><fmt:formatNumber type="percent" value="${record.percentage}"/></td>
                    <td><a href="${update_url}">Update</a></td>
                    <td><a href="${delete_url}">Delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
