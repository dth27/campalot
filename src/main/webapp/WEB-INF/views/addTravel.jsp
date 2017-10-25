<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>UserSite</title>
    <link rel="stylesheet" type="text/css" href="/css/testing.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>

<h1>Add ${camp.campName} to travelPlan</h1>
<nav class="navbar navbar-inverse" data-spy="affix" data-offset-top="197">
    <ul class="nav navbar-nav">
        <li><a href="listofcamps">All campsites</a></li>
        <li><a href="">My travelplans</a></li>
        <li><a href="UserReviews">User Reviews</a></li>
        <li><a href="accountInfo">My account</a></li>
    </ul>
</nav>
<div>
<label><b>Username:</b></label>
<input type="text" placeholder="Enter Username" name="uname" required>

<label><b>Name TravelPlan</b></label>
    <select>
        <c:forEach items="${travelplans}" var="travelplan">
            <option>${travelplan.travelPlanName}</option>
        </c:forEach>
    </select>
</div>

<div>
    <button onclick="showPopupWindow()" type="button" id="myPopup">New TravelPlan</button>

<button type="submit", method="POST">Add to travelPlan</button>
</div>

</body>

<script>
    function showPopupWindow() {
        var myWindow = window.open(action = "/campsites/newTravelPlan", "", "width=600,height=300");}
</script>

</html>
