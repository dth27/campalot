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
    <c:forEach items="${camps}" var="camp">
        <tr>
            <form action="addTravelitem" method="get" >
                <td name="campS"> ${camp.campName} </td>
                <td name="date"> <input type="date" /> </td>
                <td> <select name="nights">
                    <option value="1night">1</option>
                    <option value="2night">2</option>
                    <option value="3night">3</option>
                    <option value="4night">4</option>
                </select> </td>
                <td>
                    <button type="button"  name="buttonid">Add to TravelPlan</button>
                </td>
            </form>
        </tr>
    </c:forEach>
</table>
<h2>List of TravelPlans</h2>
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
</table>
<button onclick="showPopupWindow()" type="button" id="myPopup">New TravelPlan</button>
<script>
    function showPopupWindow() {
        var myWindow = window.open(action = "/campsites/newTravelPlan", "", "width=600,height=300");}
</script>
</body>
</html>