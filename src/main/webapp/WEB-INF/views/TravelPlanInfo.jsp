<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TravelPlan info</title>
    <link rel="stylesheet" type="text/css" href="/css/myTravelplansLook.css">
    <link href="https://fonts.googleapis.com/css?family=Lobster|Shadows+Into+Light" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
</head>
<body>
<h1>Your travelplan</h1>

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
                <a class="navbar-brand" href="forsida"><img src="/css/logo3.png" alt="Dispute Bills">
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
                        </ul>
                    </li>
                </ul>
            </div>
            <!--/.nav-collapse -->
        </div>
        <!--/.container-fluid -->
    </nav>
</div>
<div class ="maincontainer">
    <div class="textContainer">
        <h2>Your Travelplans!</h2>
        <p>Wow you've got a lot! Check them out and edit them by pressing the name</p>
        <p>You can always add new items to your travelplan by clicking on the Campsite in the menu</p>
        <p>more...</p>
    </div>
    <div class="formContainer">
    <form method="get" action="/onetravel">
        <table class="plan-table" border="1">
         <thead>
         <tr>
             <th>User</th>
             <th>Travelplan</th>

         </tr>
        </thead>
            <c:forEach var="travelitems" items="${travelplanitems}">
                <tr>
                    <td>${travelitems.username}</td>
                    <td><button name="travelname" value="${travelitems.travelplanname}">${travelitems.travelplanname}</button></td>
                </tr>
            </c:forEach>
        </table>
    </form>
    </div>

<p class = "loggedIn">You are logged in as: <b class="username">${username}</b></p>
<form method="get" action="/onetravel">
    <table border="1">
       <thead>
       <tr>
           <th>User</th>
            <th>Travelplan</th>

       </tr>
       </thead>
        <c:forEach var="travelitems" items="${travelplanitems}">
        <tr>
            <td><button>${travelitems.username}</button></td>
            <td><button name="travelname" value="${travelitems.travelplanname}">${travelitems.travelplanname}</button></td>
        </tr>
    </c:forEach>
</table>
</form>
<div class="bottom-nav">
    Created By Diljá, Kristín, Ólöf og Sandra
</div>
</body>
</html>
