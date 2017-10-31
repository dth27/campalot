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


</div>

<form action="/newAccount" method="post">

    <div class="error" style="color: red">
        ${userError}
        ${PwError}
        ${PwNotLegal}
        ${usernameNotLegal}
    </div>

    <div class="maincontainer">


        <label for="email"><b>Email</b></label><br>
        <input type="email" placeholder="Enter Email" name="email" required id="email"><br>

        <label for="username"><b>Username</b></label><br>
        <input type="text" placeholder="Enter Username" name="username" required id="username"><br>
        <label for="pw1"><b>Password</b></label><br>
        <input type="password" placeholder="Enter Password" name="pw1" required id="pw1"><br>
        <label for="pw2"><b>Re-enter password</b></label><br>
        <input type="password" placeholder="Enter Password" name="pw2" required id="pw2"><br><br>

        <button type="submit" method="POST" action="campsites/newAccount">submit</button>


    </div>
</form>
</body>
</html>
