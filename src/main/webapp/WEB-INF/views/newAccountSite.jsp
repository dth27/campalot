<%--
  Created by IntelliJ IDEA.
  User: Dottedsocks
  Date: 14/09/2017
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>New Account</title>
    <link rel="stylesheet" type="text/css" href="/css/testing.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<h1>New Account</h1>

<form action="/newAccount" method="post">

    <div class="container">
        <label><b>Email</b></label>
        <input type="email" placeholder="Enter Email" name="email" required>

        <label><b>Username</b></label>
        <input type="text" placeholder="Enter Username" name="username" required>
        <label><b>Password</b></label>
        <input type="text" placeholder="Enter Password" name="pw1" required>
        <label><b>Password</b></label>
        <input type="text" placeholder="Enter Password" name="pw2" required>

        <button type="submit" method="POST" action="campsites/newAccount">submit</button>


    </div>

</form>

</body>
</html>
