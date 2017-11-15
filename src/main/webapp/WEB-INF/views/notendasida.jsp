<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>UserSite</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css?v=2">
    <link rel="stylesheet" type="text/css" href="/css/notendasida.css" />
    <link href="https://fonts.googleapis.com/css?family=Lobster|Shadows+Into+Light" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h1>Welcome! </h1>
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
<div class = "main">
    <div class="welcomeTxt">
        <p>Well logged in ${user}</p>
        <p> On CampALot you can survey all the different
            camping areas that Iceland has to offer. </p>
    </div>
    <div>
        ${TravelPlanMessage}
    </div>
    <h2>List of camps</h2>

    <h2>List of TravelPlans</h2>
    <form action="/deleteTravelPlan" method = "POST">
        <table border="1">
            <thead>
            <tr>
                <th>Name</th>
                <th>Delete</th>
            </tr>
            </thead>
            <c:forEach items="${travelplans}" var="travelplan">
                <tr>
                    <td> ${travelplan.travelplanname} </td>
                    <td><button class = "delete" name="planName" type = "submit" value = "${travelplan.travelplanname}"></button></td>
                </tr>
            </c:forEach>
        </table><br><br>
    </form>
    <form action="/newTravelPlan" method="get">
        <button type="submit">New TravelPlan</button>
    </form>
</div>

<script>
    function showPopupWindow() {
        window.open(action = "/newTravelPlan", "", "width=600,height=300");}
</script>
<div class="bottom-nav">
    Created By Diljá, Kristín, Ólöf og Sandra
</div>
</body>
</html>