<%-- 
    Document   : Login
    Created on : 16-Sep-2022, 11:50:32 am
    Author     : mohan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="Style/FirstPage.css" rel="stylesheet" >
    </head>
    <body>
        
        <p class="notify">${errorMessage}</p>  
        <p class="notify">${signup}</p>
        <p class="notify">${validPass}</p>
        <p class="notify">${success}</p>
        
        <div id="bg">
            
            <form action="home" id="firstpage" method="POST">
                
                <div id="username">
                    <label id="namelabel"><b>Username</b></label>
                    <input id="namebox" type="text" placeholder="Enter Username" name="uname" required><br>
                </div>
                <div id="password">
                    <label id="passlabel"><b>Password</b></label>
                    <input id="passbox" type="password" placeholder="Enter Password" name="psw" required><br>  
                </div>
                <span id="button1">
                    <button id="loginbutton" type="submit">Login</button>
                </span>
                <p id="para" > Create New Account Click here...<a href="newUser">Sign Up</a></p>
                
            </form>
        </div>
    </body>
</html>
