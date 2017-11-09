<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<br>
<head>
    <title>Information</title>
    <link rel="stylesheet" type="text/css" href="/css/campInfoLook.css?v=1">
    <link href="https://fonts.googleapis.com/css?family=Lobster|Cabin" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h1>Information about ${campinfo.campname}</h1>
<p class = "loggedIn">You are logged in as: <b class="username">${username}</b></p>
<div class="container-fluid">
    <nav class="navbar navbar-light" style="background-color: #445C80" data-spy="affix" data-offset-top="197">
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
                    <li><a href="myTravelplans">My Travelplans</a></li>
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
<br>
<div id="texti">
    <h2>Name</h2>
    ${campinfo.campname}

    <div id="description">
        <h2>Description</h2>
        ${campinfo.description}
        <h3 id="adress">Address</h3>
        ${campinfo.campaddress}
        ${campinfo.campzip}
        <h3 id="contactinfo">Contact information</h3>
        ${campinfo.campemail}
        ${campinfo.campphone}
        ${campinfo.campwebsite}
    </div>
    <h3>Average Rating</h3>
    ${campinfo.averagerating}

    <h3>Give a rating</h3>
    <form action="giveRating" method="POST">
        <select name="rating">
            <option value="0">0</option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4" >4</option>
            <option value="5" >5</option>
            <option value="6" >6</option>
            <option value="7" >7</option>
            <option value="8" >8</option>
            <option value="9" >9</option>
            <option value="10" >10</option>
        </select>
        <button name="campName2" value="${campinfo.campname}" s>OK</button>
    </form>

    <h3>All Ratings</h3>
    <form action="/allratings" method="POST">
        <button name="allrat" value="${campinfo.campname}">
            See all ratings
        </button>
    </form>

    <h2>Reviews</h2>
    <form action="review" method="POST" >
        <table border="1">
            <thead>
            <tr>
                <th>Review</th>
                <th>Author</th>
            </tr>
            </thead>
            <c:forEach items="${reviews}" var="r" >
                <tr>
                    <td>  ${r.review} </td>
                    <td> ${r.username} </td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <button name="campName" value="${campinfo.campname}" type="submit">Give a review</button>
    </form>
        <h2>Do you want to visit ${campinfo.campname}?</h2>
        <h3>Add it to your travelplan!</h3>
        <form action="/addToPlan" method="post">
            <button name="Campname" value="${campinfo.campname}" type="submit">
                Add to my plan
            </button>
        </form>
</div>
<div class="bottom-nav">
    Created By Diljá, Kristín, Ólöf og Sandra
</div>
</body>
</html>