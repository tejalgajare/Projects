<%-- 
    Document   : index
    Created on : Sep 21, 2013, 3:26:59 PM
    Author     : Tejal
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
        <link href="MP1_MVC_css.css" rel="stylesheet">
        <link href='http://fonts.googleapis.com/css?family=Strait' rel='stylesheet' type='text/css'>

    </head>
    <body>
        <h1>Mini Project 1 : <strong>MVC</strong></h1>
        <div>
            <ul id="menu">
                <li><a href="<c:url value="/showCountryRecords"/>">Show Country Records</a></li>
                <li><a href="<c:url value="/NewCountryRecord"/>">New Country Records</a></li>
                <li><a href="<c:url value="/showCityRecords"/>">Show City Records</a></li>
                <li><a href="<c:url value="/NewCityRecord"/>">New City Records</a></li>
                <li><a href="<c:url value="/showCountryLanguageRecords"/>">Show Country Language Records</a></li>
                <li><a href="<c:url value="/NewCountryLangRecord"/>">New Country Language Records</a></li>
                <li><a href="">Javadocs</a></li>
            </ul>
        </div>
    </body>
</html>
