<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>UserSite</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<h1>Welcome! Here you can see your TravelPlan and make a TravelPlan! </h1>

    <ul>
        <li><a href="UserReviews">Reviews</a></li>
        <li><a href="">Travelplans</a></li>
        <li><a href="accountInfo">Account</a></li>
    </ul>


<h2>List of camps</h2>
<form action="addTravelitem" method="POST" >
<table border="1">

    <thead>
    <tr>
        <th>Name</th>
        <th>Date of Arrival</th>
        <th>How many Nights</th>
        <th>Choose Travelplan</th>
    </tr>
    </thead>

    <c:forEach items="${camps}" var="camp">
        <tr>

                <td name="campS"> ${camp.campName} </td>
                <td name="date"> <input type="Date" name="date"/> </td>
                <td>
                    <select name="nights">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                    </select>
                </td>
                <td>
                    <select name = "travel">
                        <c:forEach items="${travelplans}" var="travel">
                        <option value="travel">${travel.travelPlanName}</option>
                        </c:forEach>
                    </select>
                </td>
                <td>
                    <button type="submit" name="buttonid">Add to TravelPlan</button>
                </td>

        </tr>
    </c:forEach>


</table>
</form>
<h2>List of TravelPlans</h2>
<form action="/newTravelPlan" method = "get">
<table border="1">
    <thead>
    <tr>
        <th>Name</th>

    </tr>
    </thead>
    <c:forEach items="${travelplans}" var="travelplan">
        <tr>
            <td> ${travelplan.travelPlanName} </td>
            <td> ${travelplan.dateArrive}</td>
            <td> ${travelplan.dateDepart}</td>
            <td> ${travelplan.totalPrice}</td>
            <td> ${travelplan.totalNights}</td>
        </tr>
    </c:forEach>
</table>

<button type="button" onclick="showPopupWindow()">New TravelPlan</button>
</form>

<script>
    function showPopupWindow() {
        window.open(action = "/campsites/newTravelPlan", "", "width=600,height=300");}
</script>
</body>
</html>