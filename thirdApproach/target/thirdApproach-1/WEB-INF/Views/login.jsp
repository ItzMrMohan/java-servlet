<%-- 
    Document   : login
    Created on : 01-Apr-2022, 1:11:34 pm
    Author     : johns
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <%String filePath = getServletContext().getRealPath("/WEB-INF/Views/login.png");%>
        <style>
    body {
      background-image: url("https://img.freepik.com/free-vector/business-presentation-banner-with-blue-geometric-shape_1017-32330.jpg?w=2000");
      background-repeat: no-repeat;
      background-attachment: fixed;
      background-size: cover;
    }
    </style>
    </head>
    
   
<body bg>
    <center><br><br><br><br>
        <font color="green"><h2>${usrcrt}</h2></font>
        <font color="red"><h2>${error}</h2></font>
        <font color="blue"><h2>${unauth}</h2></font>
        <font color="red"><h2>${wrongOTP}</h2></font>
        <font color="brown"><h2>${oldSession}</h2></font>
    <h1>Login</h1>
<form action="dbvalidate" method="POST" autocomplete="off">
    Enter Username: <input type="text" name="username"/><br><br>
    Password: <input type="password" name="password"/><br><br>
    <input type="submit" value="Login"/><br><br>
</form>
<br>
<form action="createUser" method="GET">
    <input type="submit" value="Click to Create user"/>
</form><br><br>
</center>
    <script type="text/javascript">
        window.history.forward();
        function noBack() {
            window.history.forward();
        }
        </script>
</body>
    
</html>
