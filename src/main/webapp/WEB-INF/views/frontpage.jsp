<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Welcome</title>
    <link rel="stylesheet" type="text/css" href="/css/frontpage.css?v=2">
    <link href="https://fonts.googleapis.com/css?family=Lobster|Shadows+Into+Light" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="banner">
    <img class = "front-logo" src="/css/logo3.png" alt="Dispute Bills">
</div>
<div class="main-container" id="main-container">
    <div class="information-container">
        <h1 class="fronttxt">Welcome to the Camp'A'Lot homepage</h1>
        <p>Here you can sign in. This site helps you to plan your travels around Iceland.
            We have ${camps} campsites with information on our site.</p>
        <br><br>

            <h3>Check out the Campsites:</h3>

        <form method = "get" action="listofcamps" class="frontpageForm">
            <div style="text-align:center">
                <input class ="btn btn-info" type="submit" value="All campsites"><br><br>
            </div>
        </form>

    </div>
    <div class="col-sm-12 col-md-10 col-md-offset-1">
    <div class="login-container">
        <form action="login" method="post">
            <fieldset>
                <legend>Log in:</legend>
                Username:<br>
                <input type="text" placeholder="Enter username" name="uname" required><br>
                Password:<br>
                <input type="password" placeholder="Enter password" name="psw" required><br><br>
                <button type="submit" method="POST" action="login">Login</button>
                <input type="checkbox" checked="checked"> Remember me <br><br>
                <span class="psw">Forgot <a href="#">password?</a></span>
                <button onclick="showPopupWindow()" type="button">Sign up!</button>
            </fieldset>

            <p class = "error" style="color:red;">${error}</p>

        </form>
    </div>
    </div>
</div>

<div class="bottom-nav">
    Created By Diljá, Kristín, Ólöf og Sandra
</div>
<script>
    function showPopupWindow() {
        var myWindow = window.open(action = "newAccountSite", "", "width=600,height=400");
    }
</script>

</body>
</html>
