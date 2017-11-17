<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>UserSite</title>

    <link rel="stylesheet" type="text/css" href="/css/notendasida.css?v=3">
    <link href="https://fonts.googleapis.com/css?family=Lobster|Shadows+Into+Light" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="Topheader">
<p class="welcome">Welcome! </p>
<p class = "loggedIn">You are logged in as: <b class="username">${username}</b></p>
</div>
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

<div class = "main">
    <div class="welcomeTxt">
        <h2>Nature calls!</h2>
        <p>Did you know that camping can reset your circadian clock?
        Read more <a href="https://health.usnews.com/health-news/news/articles/2013/08/01/camping-sets-body-clock-in-tune-with-nature" target="_blank">here</a></p>
        <p>Check out all the different camping sites Iceland has to offer and answer the call of nature!
        </p>
        <p>Don't forget to check the weather before your trip!</p>
        <p>Click <a href="en.vedur.is" target="_blank">here</a> for a 5 day forecast</p>
        <p>The weather in Iceland can be tricky so be prepared and plan ahead!</p>
        <p></p>

    </div>
    <div>
        ${TravelPlanMessage}
    </div>
    <div class="plans">
    <h2>List of TravelPlans</h2>
    <form action="/deleteTravelPlan" method = "post">
        <table class="table table-hover" border="1">
            <thead>
            <tr>
                <th>Name</th>
                <th>Delete</th>
            </tr>
            </thead>
            <c:forEach items="${travelplans}" var="travelplan">
                <tr>
                    <td> <button name="travelname" type ="submit" value="${travelplan.travelplanname}" onclick="form.action='onetravel'; method='get';"> ${travelplan.travelplanname}</button> </td>
                    <td><button class ="delete" name="planName" type = "submit" value = "${travelplan.travelplanname}"></button></td>
                </tr>
            </c:forEach>
        </table><br>
    </form>
    <form action="/newTravelPlan" method="get">
        <button class="btn btn-info" type="submit">New TravelPlan</button>
    </form>
    </div>
</div>

<script>
    function showPopupWindow() {
        window.open(action = "/newTravelPlan", "", "width=600,height=300");}
</script>
<script>
    $(document).ready(function () {
        $('.dropdown-toggle').dropdown();
    });
</script>
<div class="bottom-nav">
    Created By Diljá, Kristín, Ólöf og Sandra
</div>
</body>
</html>