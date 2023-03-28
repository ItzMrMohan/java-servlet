<%-- 
    Document   : Home
    Created on : 20-Sep-2022, 11:40:28 am
    Author     : mohan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        .avatar {
            vertical-align: middle;
            width: 200px;
            position: absolute;
            height: 200px;
            border-radius: 100;
            /*opacity: 0.8;*/
            top: 16%;
            right: 83%;
        }
        #heading{
            position: absolute;
            left: 43%;
            top: 2%;
        }
        #upload{
            position: absolute;
            width: 2%;
            left: 130px;
            top: 38%;
            cursor: pointer;
           
            border-radius: 2px;  
            color: #fff;

            
        }
        #upload:hover{
            background-image: linear-gradient(90deg, #00C0FF 0%, #FFCF00 49%, #FC4F4F 80%, #00C0FF 100%);
            animation:slidebg 5s linear infinite;
         }

        html,
        body {
            margin: 0;
            padding: 0;
            width: 100%;
            height: 100vh;
            display: flex;
            flex-direction: row;
            justify-content: center;
            align-items: center;
            background: #ccc;
        }

        .glow-on-hover {
            width: 88px;
            height: 39px;
            border: none;
            outline: none;
            right: 700%;
            color: #f8f8f8;
            background: #471dd3;
            cursor: pointer;
            position: relative;
            z-index: 0;
            border-radius: 10px;
        }

        .glow-on-hover:before {
            content: '';
            background: linear-gradient(45deg, #ff0000, #ff7300, #fffb00, #48ff00, #00ffd5, #002bff, #7a00ff, #ff00c8, #ff0000);
            position: absolute;
            top: -2px;
            left:-2px;
            background-size: 400%;
            z-index: -1;
            filter: blur(5px);
            width: calc(100% + 4px);
            height: calc(100% + 4px);
            animation: glowing 20s linear infinite;
            opacity: 0;
            transition: opacity .3s ease-in-out;
            border-radius: 10px;
        }

        .glow-on-hover:active {
            color: #000
        }

        .glow-on-hover:active:after {
            background: transparent;
        }

        .glow-on-hover:hover:before {
            opacity: 1;
        }

        .glow-on-hover:after {
            z-index: -1;
            content: '';
            position: absolute;
            width: 100%;
            height: 100%;
            background: #111;
            left: 0;
            top: 0;
            border-radius: 10px;
        }

        @keyframes glowing {
            0% { background-position: 0 0; }
            50% { background-position: 400% 0; }
            100% { background-position: 0 0; }
        }

    </style>
    <script>
        
        function nxtImg(){
            window.location.href="profile";
        }
    </script>
    <body>
        
        
        <form action="profile" method="GET">
            
            <h1 id="heading">HELLO ${profileName}</h1>
            <img src="http://127.0.0.1:8887/${UUID}.JPG" height="200" width="200" id="def" alt="Avatar" class="avatar" >

            <button class="glow-on-hover" type="button" onclick="nxtImg()" style="  font-family: fantasy ;font-size:large ">UPLOAD!!!</button>

        </form>
            
    </body>
</html>
