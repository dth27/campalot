<%--
  Created by IntelliJ IDEA.
  User: Dottedsocks
  Date: 19/10/2017
  Time: 09:38
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Camp to TravelPlan</title>
    <link rel="stylesheet" type="text/css" href="/css/testing.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<form action="addTravelitem" method="post" >
<h1>Add ${campinfo.campname} to my travelplan</h1>
<nav class="navbar navbar-inverse" data-spy="affix" data-offset-top="197">
    <ul class="nav navbar-nav">
        <li><a href="listofcamps">All campsites</a></li>
        <li><a href="">My travelplans</a></li>
        <li><a href="UserReviews">User Reviews</a></li>
        <li><a href="accountInfo">My account</a></li>
    </ul>
</nav>
</form>
<form action="addTravelitem" method="POST" >
    <table border="1">

        <thead>
        <tr>
            <th>Name</th>
            <th>From</th>
            <th>To</th>
            <th>Choose Travelplan</th>
        </tr>
        </thead>

            <tr>
                <td name="camps" value="${camp.campname}"> ${camp.campname} </td>
                <td name="datearrive"> <input type="date" name="datearrive"/> </td>
                <td name="datedepart"> <input type="date" name="datedepart"/> </td>
                <td>
                     <select name = "travels">
                        <c:forEach var="travel" items="${travelplans}">
                        <option name="travel" value="${travel.travelplanname}">${travel.travelplanname}</option>
                        </c:forEach>
                    </select>
                </td>
                <td>
                    <button type="submit" name="buttonid">Add to TravelPlan</button>
                </td>
            </tr>

    </table>
</form>
</body>
</html>
