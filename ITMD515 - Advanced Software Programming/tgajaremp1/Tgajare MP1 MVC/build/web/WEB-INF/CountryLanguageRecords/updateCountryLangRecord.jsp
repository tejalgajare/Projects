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
        <title>Update Country Language Record</title>
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
        <form action="<c:url value="/UpdateCountryLangRecord"/>" method="post">

            <table id="formtable">
                <h2>Update Record Form</h2>
                <tr>
                    <td><label for="CountryCode">Country Code:</label></td>
                    <td><input type="text" id="CountryCode" name="CountryCode" value="${CountryCode}" readonly="readonly"></td>
                </tr>
                <tr>
                    <td><label for="Language">Language:</label></td>
                    <td><input type="text" id="Language" name="Language" value="${Language}" readonly="readonly"></td>
                </tr>
                <tr>
                    <td><label for="IsOfficial">Is Language Official True/False:</label></td>
                    <td><input type="text" id="IsOfficial" name="IsOfficial" value="${IsOfficial}"></td>
                </tr>
                <tr>
                    <td><label for="Percentage">Percentage:</label></td>
                    <td><input type="text" id="Percentage" name="Percentage" value="${Percentage}"></td>
                </tr>
                <tr>

                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form>


    </body>
</html>