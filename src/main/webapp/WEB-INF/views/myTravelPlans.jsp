<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>TravelPlans</title>
    <spring:url value="/css/campinf.css" var="crunchifyCSS"/>
    <link href="${crunchifyCSS}" rel="stylesheet"/>
</head>
<body>
<h1>Welcome! Here you can see your TravelPlan and make a TravelPlan! </h1>
<nav id="navbar">
    <ul>
        <li><a href="listofcamps">All campsites</a></li>
        <li><a href="myTravelplans">My travelplans</a></li>
        <li><a href="UserReviews">User reviews</a></li>
        <li><a href="accountInfo">My account</a></li>
    </ul>
</nav>

<h2>List of TravelPlans</h2>
<form action="/newTravelPlan" method="get">
    <table border="1">
        <thead>
        <tr>
            <th>Name</th>
        </tr>
        </thead>
        <c:forEach items="${travelplans}" var="travelplan">
            <tr>
                <td> ${travelplan.travelplanname} </td>
            </tr>
        </c:forEach>
    </table>
</form>
<form action="/newTravelPlan" method="get">
    <button type="submit">New TravelPlan</button>
</form>
</body>
</html>