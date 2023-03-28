<%-- 
    Document   : login.jsp
    Created on : 01-Apr-2022, 12:15:28 pm
    Author     : mohan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><font color="red">${error}</font></h1>
        <h1 align=" center">Login Page</h1><br>
        <form action="userRoles" method="GET" align="Center" autocomplete="off" >
            
            <label for="uname"><b>USERNAME<b></label>
            <input type="text" placeholder="Enter Username" name="uname" required autocomplete="off"><br><br>
            
            <label for="psw"><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="psw" required><br><br>
            
            <button type="submit" align="center">Login</button><br><br>
        </form>
        <form action="newuser" method="GET">
            <button type="submit" align="center">Create new user</button><br><br>
        </form>
        
    </body>
</html>
