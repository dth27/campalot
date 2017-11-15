<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<br>
<head>
    <title>Information</title>
    <link rel="stylesheet" type="text/css" href="/css/help.css?v=2">
    <link href="https://fonts.googleapis.com/css?family=Lobster|Cabin" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h1>Help</h1>
<p class = "loggedIn">You are logged in as: <b class="username">${username}</b></p>
<div class="container-fluid">
    <nav class="navbar navbar-light" style="background-color:#42453D" data-spy="affix" data-offset-top="197">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="goToNotendasida"><img src="/css/logo3.png" alt="Dispute Bills">
                </a>
            </div>
            <div id="navbar1" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="listofcamps">Campsites</a></li>
                    <li><a href="getTravelItems">My Travelplans</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Info<span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="accountInfo">My information</a></li>
                            <li><a href="UserReviews">My reviews</a></li>
                            <li class="divider"></li>
                            <li class="dropdown-header">About</li>
                            <li><a href="aboutCampALot">About Camp'A'Lot</a></li>
                            <li><a href="help">Help</a></li>
                        </ul>
                    </li>
                </ul>
                <a class = "right" href = "logOut">Log out</a>
            </div>
            <!--/.nav-collapse -->
        </div>
        <!--/.container-fluid -->
    </nav>
</div>
<br>
<div class = "howto">
    <h1>How to ...</h1>

    <h2>How to make a new travelplan:</h2>
    <p>
        1. Make sure that you are logged in.<br>
        2. Click on our logo.<br>
        3. You will see a button called "New Travelplan", click on it.<br>
        4. Name your travelplan and press submit.<br>
        <br>
        after these steps, your travelplan should be ready.
    </p>

    <h2>How to add camp to your travelplan:</h2>
    <p>
        1. Make sure that you are logged in.<br>
        1. click on campsites.<br>
        2. Select a campsite.<br>
        3. Press the button "Add to my plan".<br>
        4. Fill in required information.<br>
        5. Press "Add to Travelplan".<br>
        <br>
        After these steps, the camp should be in your travelplan.
    </p>

    <h2>How to change password:</h2>
    <p>
        1. Make sure that you are logged in.<br>
        2. Click on info.<br>
        3. Select my information.<br>
        4. Press "Change password".<br>
        5. Fill in required information.<br>
        6. Press "Change password".<br>
        <br>
        After these setps, your password should be changed.
        <br>
        <br>
        <br>
        <br>
    </p>

</div>


<div class="bottom-nav">
    Created By Diljá, Kristín, Ólöf og Sandra
</div>
</body>
</html>