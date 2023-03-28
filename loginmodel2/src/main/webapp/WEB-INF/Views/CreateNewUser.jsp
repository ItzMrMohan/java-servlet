<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
</head>
<style>
body {
    background-image: url('https://previews.123rf.com/images/gubcio/gubcio1303/gubcio130300274/18439404-filling-document-form-paperwork-office-business.jpg');
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-size: cover;
  }</style>
<body>
    <blockquote>
        <h1>Create New User</h1>
    <form action="/create" method="POST" autocomplete="off">
        Username: <input type="text" name="username"/><br><br>
        Email: <input type="email" name="email"/><br><br>
        Phone: <input type="text" name="phone"/><br><br>
        Address: <input type="text" name="address"/><br><br>
        Password: <input type="password" name="password"/><br><br>
        <input type="submit" value="Create User"/>
    </blockquote>
    </form>
</body>
</html>