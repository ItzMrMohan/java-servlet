<%-- 
    Document   : MainPage
    Created on : 01-Apr-2022, 1:43:18 pm
    Author     : johns
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Roles and Permissions</title>
        <style>
            body.Admin{
                background-image: url('data:image/jpeg;base64,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');
                background-repeat: no-repeat;
                background-attachment: fixed;
                background-size: cover;

            }
            body.Developer{
                background-image: url('https://static.vecteezy.com/system/resources/thumbnails/002/016/085/original/colorful-gradient-background-free-video.jpg');
                background-repeat: no-repeat;
                background-attachment: fixed;
                background-size: cover;
            }
            body.Employee{
                background-image: url('https://cdn.pixabay.com/photo/2021/08/02/22/41/background-6517956__340.jpg');
                background-repeat: no-repeat;
                background-attachment: fixed;
                background-size: cover;
            }
            body.User{
                background-image: url('https://img.freepik.com/free-vector/green-tones-gradient-background_23-2148376167.jpg?w=2000');
                background-repeat: no-repeat;
                background-attachment: fixed;
                background-size: cover;
            }
            body.External_User{
                background-image: url('data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBwgICggICAgHBwcHCAoHBwcHCA8ICQcKFREWFhUREx8YHSggGCYlJxMTITEhJSkrLi4uFx8zODMsNygtLisBCgoKDQ0NDw8NFSsZFRkrKy03NysrKy0tKy0tKysrKysrKystNysrKysrNysrKysrKysrKysrKysrKysrKysrK//AABEIALcBEwMBIgACEQEDEQH/xAAaAAEBAQADAQAAAAAAAAAAAAAAAQIDBAUH/8QAHhABAQEBAAICAwAAAAAAAAAAAAEREgIhYXExUYH/xAAaAQEBAQEBAQEAAAAAAAAAAAABAAIDBQYE/8QAGBEBAQEBAQAAAAAAAAAAAAAAAAEREgL/2gAMAwEAAhEDEQA/APtSA/Bi0QGsOppQOHUCo1ItEVK3DoioZD1UBK3IdEVGjolKjWFUEMhDURqQyqgjeNy6qCacK6lBqQiUKcSaASJfyqEgBT00KPFx5uiBWpDqANSESiU4gEakRSojch0QK3i0EqNTydKCNcmUqGprWNghrWNAia1jUUE1Y2qGhxJQCQoIoKiIAU9JAeTjydNSgcMogVrldJQRueT0ItQ4pRBK3I1olVlqeTqpTUbkKUKjUjULUTRrHSABbkQAtyAgiAIgCQIqKAIgBT0EVHnY8ToKIWtVNEOHQoEpQRqRCFG5DqIqNxqVKCUyNxEBrHTygULoIom5UALSCoiAIgFRQBEASACnfCj8LwhAR0BDi0qFDIZRFRuQ6lKFaaZqVan7LUEoVqOsZKoW4iKF1lQBEATcqComhFCkAREURQURQBJ3jSj8j58BKiAhwlAakOoAShQpjUrNRULp5QoUusRFFrcQVFrcAFraCi0yoGC1vRKodKCh1M4LgtKC4mHSB7Fpd0CPz4+fEoHEgUJAEUBKSFCkxlFZqdvKpViJ1EqpU1ABNyoKJtAVaUDDE1ABNagoigqYtR6RcFpQUWl2gGXz+iKiJoBQAigFJQtEqakRBE7eVQpU6wRRFAA1AAukAA0AJAGJrQMMGtCKLSguItSYqhLsAB86JVQtwAREVKkJVZtLS38MVbUTp5iConWAAbAE0IomogoNaiGKDWkUUa0goNSC4YNalQxRa1qGKKUpgodTmE010fPAampqRRnS1NLqams2lqRrUTUtTc8qiaJ0kDQDpABNCpFZ0gA0gehnSAJuVQARQBMBUUFwwaZUGs+Uw61qC4LVq2p19OPpL5P08vE5cmm/Lj6Ojy1PLel8tcfSWrGp5b1LWdNjLcjemsbDU3I0M6ugyKamgrcVWVFpUgMaVEUEBYtKYouDUi4NSDWpWVi4DWtTDGpCRno6g1/FwdJjFa5XIOkzg1kF0nn9nYPTefJDs7BEvkTyBE6OgZrUXTQYrUX2aAK6SgKWtAc6VlUBURYARFBkquIArFwGalkXAZK4YDNK4uIMW0rIvP0gtpXPpAZ1P//Z');
                background-repeat: no-repeat;
                background-attachment: fixed;
                background-size: cover;
            }
            button.API {
  background-color: #c41449; /* Green */
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  cursor: pointer;
}
button.API:hover{
    box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
    cursor: pointer;
}
        </style>
    </head>
    <body class="${role}" onload="${role}()">
        <p align="right"><b>${user}</b>|${role}<br>
            <a href = "logout">Logout</a></p>
    <center>   
        <h1>Welcome Dear ${user} </h1>
        ${list}
        <br><br><br>

        <button id="create" onclick="allowCreate()">Create</button>
        <button id="save" onclick="allowSave()">Save</button>
        <button id="submit"onclick="allowSubmit()">Submit</button>
        <button id="approve" onclick="allowApprove()">Approve</button>
        <button id="authorize" onclick="allowAuthorize()">Authorize</button>
        <br>
        <br>
        <button class="API" id="APIButton1" onclick="function1()">First API</button>
        <button class="API" id="APIButton2" onclick="function2()">Second API</button>

        <font color="green"> <p id="comment"></p></font>
    </center>


    <script type="text/javascript">

        function allowCreate() {
            document.getElementById("comment").innerHTML = 'Record created';
        }
        function allowSave() {
            document.getElementById("comment").innerHTML = 'Record Saved';
        }
        function allowSubmit() {
            document.getElementById("comment").innerHTML = 'Record submitted';
        }
        function allowApprove() {
            document.getElementById("comment").innerHTML = 'Record Approved';
        }
        function allowAuthorize() {
            document.getElementById("comment").innerHTML = 'Record Authorized';
        }
        function Developer() {
            document.getElementById("authorize").style.visibility = 'hidden';
        }
        function Employee() {
            document.getElementById("authorize").style.visibility = 'hidden';
            document.getElementById("approve").style.visibility = 'hidden';
        }
        function User() {
            document.getElementById("authorize").style.visibility = 'hidden';
            document.getElementById("approve").style.visibility = 'hidden';
            document.getElementById("submit").style.visibility = 'hidden';
        }
        function External_User() {
            document.getElementById("authorize").style.visibility = 'hidden';
            document.getElementById("approve").style.visibility = 'hidden';
            document.getElementById("submit").style.visibility = 'hidden';
            document.getElementById("save").style.visibility = 'hidden';
        }
        
        function function1(){
            location.href='print';
        }
        function function2(){
            location.href='printSession';
        }

    </script>

</body>
</html>
