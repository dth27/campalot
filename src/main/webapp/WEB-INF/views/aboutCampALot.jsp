<%--
  Created by IntelliJ IDEA.
  User: Kristín María
  Date: 15.11.2017
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>About Camp'A'Lot</title>
    <link rel="stylesheet" type="text/css" href="/css/testing2.css?v=1">
    <link rel="stylesheet" type="text/css" href="/css/style.css?v=1">
    <link href="https://fonts.googleapis.com/css?family=Lobster|Shadows+Into+Light" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

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
                            <li><a href="#">About Camp'A'Lot</a></li>
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
<br><br>
<h2>About Camp'A'Lot</h2>

<b>Camp'A'Lot was created by four young women studying computer science, Diljá, Kristín, Ólöf and Sandra.
    The idea came to them in the classroom as they were deciding on what their next project should be.
    They thought that since the travel industry in Iceland had grown tremendously for the past few years
    that a project within the travel industry would be a successful idea. Many people come to Iceland
    to travel around the country and see it's beautiful nature. Unfortunately for them, the demand for
    hotel rooms all over Iceland has increased significantly resulting in higher prices. Therefore more and more
    people are choosing to travel around the country by camping! On the Camp'A'Lot site you can see
    information for all campsites in Iceland in one place and plan your camping trip around Iceland.
    We have included prices, activities, campsite service and nearby attractions to make the trip planning
    easier for you. We hope that this helps you plan your trip to Iceland!
</b>
</body>
</html>
