<%-- 
    Document   : PrintUserData
    Created on : 20-Apr-2022, 12:27:20 pm
    Author     : johns
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>body{
                background-image: url('https://miro.medium.com/max/763/1*9PQi52PdOVSohB-vs1-q6g.png');
                background-repeat: no-repeat;
                background-attachment: fixed;
                background-size: cover;

            }</style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Print User Data</title>
    </head>
    <body>
        <p align="right"><b>${user}</b>|${role}<br>
            <a href = "logout">Logout</a></p>
        <h1>Print<font color="red">UserData|</font></h1><br> Welcome to the EndPoint where you can print all user Data<br>
        Name: <font color="orange">${e_name}</font><br>
        Mobile Number:<font color="orange"> ${e_mob}</font><br>
        Email ID:<font color="orange"> ${e_email}</font><br>
        UserID: <font color="orange">${e_id}</font>
    </body>
</html>
