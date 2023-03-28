<%-- 
    Document   : Profile
    Created on : 15-Sep-2022, 2:45:46 pm
    Author     : mohan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
        .avatar {
            vertical-align: middle;
            position: absolute;
            left: 44%;
            width: 250px;
            height: 250px;
            bottom: 52%;
            border-radius: 100;
            
            border: solid;
            border-color: #000000;
        }
        #file{
            position: absolute;
            left: 56%;
            bottom: 48%;
            width: 2%;
            cursor: grab;
        }
        #heading{
            position: absolute;
            left: 47%;
            font-weight: bold;
            font-size: 140%;
        }
        #cancel{
            position: absolute;
            left: 46%;
            top: 49%;
            font-size: 110%;
            width: 2%;
            cursor: grab;
            
        }
        .image-upload>input {
            display: none;
        }
        #upload{
            position: absolute;
            width: 2%;
            left: 51%;
            top: 49%;
            cursor: grab;
        }
        .confirmImg>button{
           display: none; 
        }
        #confirmImage{
            position: absolute;
            width: 2%;
            left: 57%;
            top: 49%;
            cursor: grab;
        }
        #confirm{
            position: absolute;
            left: 56%;
            bottom: 48%;
            width: 2%;
            cursor: grab;
        }
        </style>
        
        
        <script>
            
            function previewImage(){
                var file = document.getElementById("file").files;
                console.log(file);
                if(file.length >0){
                    var fileReader = new FileReader();
                    
                    fileReader.onload = function(event){
                         document.getElementById("preview").setAttribute("src",event.target.result);
                         
                    };
                    fileReader.readAsDataURL(file[0]);
                }
            }
           
            
            
            
            
            function cancel(){
                window.location.href= "home";
            }
//            function addImg(){
//                var input = document.getElementById('file').appendChild(input);
//                input.type="file";
//                alert("Hello Boss");
//            }
            
        </script>
    </head>
    <body>
             <p id="heading">CHANGE PROFILE</p>
        <form action="profile" Method="POST" enctype='multipart/form-data'>
               
                <img src="http://127.0.0.1:8887/${UUID}.JPG" id="preview" class="avatar" />
                <div class="image-upload"> 
                    <label for='file'>
                        <img src="Image/add-photo.png" id="upload" />
                    </label>
                    <input type="file" name="file" id ="file" value="" accept="image/*" onchange="previewImage()">
                </div>
                <div class="confirmImg">
                    <label for="confirm" ><img src="Image/check-mark.png" id="confirmImage" /></label>
                    <button id="confirm" name="confirm" type="submit"></button>
                </div>
        </form>
        <!--<button id="loginbutton" type="submit" onclick="conFirm()">Cancel</button>-->
        <img src="Image/failure.png" alt="alt" id="cancel" onclick="cancel()"/>
        
        
        
        
    </body>
</html>
