<%-- 
    Document   : NewUser
    Created on : 04-Apr-2022, 1:59:22 pm
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
    
        <form action="newuser" autocomplete="off" align="center">
            
            <h><b>Creating New User</b></h><br><br>
            
            
            <label for="uname"><b>USERNAME<b></label>
            <input type="text" placeholder="Enter Username" name="uname" required><br><br>
            
            <label for="upass"><b>PASSWORD<b></label>
            <input type="text" placeholder="Enter Password" name="upass" required ><br><br>
            
            <label for="udob">DOB</label>
            <input type="date" placeholder="Enter DOB" name="udob" required><br><br>
            
            <label for="uCurrentAddress"><b>Current Address<b></label>
            <input type="text" placeholder="Enter Current Address" name="uCurrentAddress" required ><br><br>
            
            <label for="uPermenantAddress"><b>Permenant Address<b></label>
            <input type="text" placeholder="Enter permenant Address" name="uPermenantAddress" required ><br><br>
            
            <label for="mobileno"><b>Mobile No<b></label>
            <input type="Bigint" placeholder="Mobileno" name="mobileno" required><br><br>
            
            <label for="qualification"><b>Qualification<b></label>
            <input type="text" name="qualification" required><br><br>
            
            <label for="mail"><b>Email ID<b></label>
            <input type="text" name="mail" required><br><br>
            
            <button type="submit" align="center">Submit</button><br><br>
            
        </form>
    </body>
</html>
