<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>UserSite</title>
</head>

<body>

<h1>Add ${camp.campName} to travelPlan</h1>

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
