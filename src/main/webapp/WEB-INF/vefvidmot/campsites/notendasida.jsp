<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>UserSite</title>
</head>
<body>
<h1>Welcome! Here you can see your TravelPlan and make a TravelPlan! </h1>

<h2>List of camps</h2>

<table border="1">
    <thead>
    <tr>
        <th>Name</th>
        <th>Date of Arrival</th>
        <th>How many Nights</th>
    </tr>
    </thead>
    <form action="/addTravelitem" method="get" >
    <c:forEach items="${camps}" var="camp">
        <tr>

                <td name="campS"> ${camp.campName} </td>
                <td name="date"> <input type="date" /> </td>
                <td> <select name="nights">
                    <option value="1night">1</option>
                    <option value="2night">2</option>
                    <option value="3night">3</option>
                    <option value="4night">4</option>
                </select> </td>
                <td>
                    <button type="submit"  name="buttonid">Add to TravelPlan</button>
                </td>

        </tr>
    </c:forEach>
    </form>

</table>
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
        </tr>
    </c:forEach>
    <c:forEach items="${travelplanItems}" var="travelplanItems">
        <td> ${travelplanItem.dateArrive} </td>
        <td> ${travelplanItem.dateDepart} </td>
        <td> ${travelplanItem.totalPrice} </td>
        <td> ${travelplanItem.totalNights} </td>

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