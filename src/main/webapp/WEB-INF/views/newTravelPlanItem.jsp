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
    <link rel="stylesheet" type="text/css" href="/css/testing2.css">
    <link href="https://fonts.googleapis.com/css?family=Lobster|Shadows+Into+Light" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<form action="addTravelitem" method="post" >
<h1>Add ${campinfo.campname} to my travelplan</h1>

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
