<%-- 
    Document   : Manager.jsp
    Created on : 01-Apr-2022, 12:13:05 pm
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
        <h1>Hello World!</h1>
        <form action="details" method="GET">
            <button type="submit" align="center">ProjectDetails</button><br><br>
        </form>
        <form action="statics" method="GET">
            <button type="submit" align="center">Statics</button><br><br>
        </form>
        <form action="employee" method="GET">
            <button type="submit" align="center">EmployeeDetails</button><br><br>
        </form>

    </body>
</html>
