<%-- 
    Document   : index
    Created on : Sep 20, 2013, 12:06:37 PM
    Author     : Tejal
This is the main welcome page where the user is first avigated to as soon as the project is run.
This page offers navigation options for displaying the records/creating new records
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="MP1_JSP_css.css" rel="stylesheet">
        <link href='http://fonts.googleapis.com/css?family=Strait' rel='stylesheet' type='text/css'>
        <title>JSP Mini Project 1</title>
    </head>
    <body>
        <h1>Mini Project 1 : <strong>JSP</strong></h1>
        <div>
            <ul id="menu">
                <li><a href="records.jsp" class="link">Show Records</a></li>
                <li><a href="create.jsp" class="link">New Record</a></li>
                <li><a href="extras/MP1README.pdf" class="link" target="_blank">Read Me</a></li>
            </ul>
        </div>
    </body>
</html>
