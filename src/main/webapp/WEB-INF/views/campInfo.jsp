<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<br>
<head>
    <title>Information</title>
    <link rel="stylesheet" type="text/css" href="/css/testing.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h1>Information about ${campinfo.campname}</h1>
<nav class="navbar navbar-inverse" data-spy="affix" data-offset-top="197">
    <ul class="nav navbar-nav">
        <li><a href="listofcamps">All campsites</a></li>
        <li><a href="">My travelplans</a></li>
        <li><a href="UserReviews">User Reviews</a></li>
        <li><a href="accountInfo">My account</a></li>
    </ul>
</nav>
<br>
    <h3>Name</h3>
    ${campinfo.campname}
    <h3>Rating</h3>

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

    <h3>Average Rating</h3>
    ${campinfo.averagerating}

    <h3>All Ratings</h3>
    <form action="/allratings" method="POST">
        <button name="allrat" value="${campinfo.campname}">
            See all ratings
        </button>
    </form>

    <h2>Description</h2>
    ${campinfo.description}
    <h3 id="adress">Adress</h3>
    ${campinfo.campaddress}
    ${campinfo.campzip}
    <h3 id="contactinfo">Contact info</h3>
    ${campinfo.campemail}
    ${campinfo.campphone}
    ${campinfo.campwebsite}

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

<h2>Add this camp to your TravelPlan!</h2>
<form action="/addToPlan" method="get">
    <button name="Campname" value="${campinfo.campname}" type="submit">
        Add to TravelPlan
    </button>
</form>
</body>
</html>