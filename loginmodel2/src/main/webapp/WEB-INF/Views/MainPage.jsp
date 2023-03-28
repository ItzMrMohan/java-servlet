<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to DBFetacher</title>
<style>
    body {
      background-image: url('https://blog.cloudflare.com/content/images/2021/11/image1-13.png');
      background-repeat: no-repeat;
      background-attachment: fixed;
      background-size: cover;
    }
</style>
</head>
<body>
    
    <h1>Welcome, ${name}</h1>
<form action="fetch" method="GET">
    <input type="submit" value="Fetch all Data"/><br><br>
</form>
<form action="fetch" method="POST">
    Enter text to filter FirstName: <br><br><input type="text" name="username"/>
    <br><br>
    <input type="submit" value="Fetch Particular Data"/>
</form>

</body>
</html>