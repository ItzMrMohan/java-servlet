<%-- 
    Document   : CreateuserForm
    Created on : 15-Sep-2022, 5:04:14 pm
    Author     : mohan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<hhtml>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../webapp/Style/NewUser.css" rel="stylesheet" >
    </head>
    <body>
        <p> ${doberror} </p>
        <p>${passerror}</p>
        <p>${pinerror}</p>
        <p>${doorerror}</p>
        <p>${sterror}</p>
        <p>${dterror}</p>
        <p>${vterror}</p>
        <p>${phoneerror}</p>
        <p>${mailerror}</p>
        
        <div id="newuser">
            
            <form action="newUser" method="POST">
                
                <div id="firstname">
                    <label id="fname1">First Name:</label><input id="fname2" type="text" name="fName" placeholder="Enter the First Name" required>
                </div><br>
                
                <div id="lastname">
                    <label id="lname1" >Last Name:</label><input id="lname2" type="text" name="lName" placeholder="Enter the Last Name" required>
                </div><br>
                
                <div id="gender">
                    <label id="gname">Gender:</label><input id="male" type="radio" name="gender" value="m" >Male<input id="female" type="radio" name="gender" value="f">Female<input id="others" type="radio" name="gender" value="o">Others
                </div><br>
                
                <div id="birthdate">
                    <label id="birth1">Date of Birth:</label><input id="birth2" type="date" name="dob" required >
                </div><br>
                
                <div id="cNumber">
                    <label id="phone1">Phone Number:</label><input id="phone2" type="text" name="contactNumber" placeholder="Enter the PhoneNumber" required> 
                </div><br>
                
                <div id="eMail">
                    <label id="mail1">Email ID:</label><input id="mail2" type="text" name="mail" placeholder="Enter the Email" required>
                </div><br>
                
                <div id="doorno">
                    <label id="door1">Door No:</label><input id="door2" type="text" name="doorno" placeholder="Enter the Door No" required>
                </div><br>
                
                <div id="street">
                    <label id="street1">Street</label><input id="street2" type="text" name="street" placeholder="Enter the Street Name" required>
                </div><br>
                
                <div id="villtown">
                    <label id="vill1">Village/Town</label><input id="vill2" type="text" name="vill/town" placeholder="Enter the Village/Town Name" required>
                </div><br>
                
                <div id="district">
                    <label id="dis1">District</label><input id="dis2" type="text" name="district" placeholder="Enter the District Name" required>
                </div><br>
                
                <div id="pincode">
                    <label id="pin1">Pincode</label><input id="pin2" type="text" name="pincode" placeholder="Enter the Pincode" required>
                </div><br>
                
                <div id="password1">
                    <label id="pass1">Password</label><input id="pass2" type="password" name="password" placeholder="Enter the Password" required>
                </div><br>
                
                <div id="repassword1">
                    <label id="repass1">Confirm Password</label><input id="repass2" type="password" name="confirmpass" placeholder="Enter the confirm Password" required>
                </div><br>
                
                <div id="button">
                    <button id="but1" type="submit">ADD USER</button>
                </div><br>
            </form>
        </div>
    </body>

</html>
