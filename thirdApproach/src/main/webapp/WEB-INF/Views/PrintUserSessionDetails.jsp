<%-- 
    Document   : PrintUserSessionDetails
    Created on : 20-Apr-2022, 12:49:08 pm
    Author     : johns
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>body{
                background-image: url('https://d35fo82fjcw0y8.cloudfront.net/2018/10/09080841/Blog_header-e1551339784942.png');
                background-repeat: no-repeat;
                background-attachment: fixed;
                background-size: cover;

            }</style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <font color="white">  <title>Print User Session Data</title>
</head>
<body>
    <p align="right"><b>${user}</b>|${role}<br>
            <a href = "logout">Logout</a></p>
    <h1>PrintUser<font color="yellow">SessionDetails|</font></h1><br> Welcome to the EndPoint where you can print user session Details
    <br><font color = "orange">${sessions}</font>
    <% List<ArrayList<String>> wholeList = sessionDetails%>
    </font>
</body>
</html>
