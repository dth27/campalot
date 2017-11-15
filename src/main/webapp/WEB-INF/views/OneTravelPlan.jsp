
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My TravelPlans</title>
    <link rel="stylesheet" type="text/css" href="/css/testing2.css">

    <link href="https://fonts.googleapis.com/css?family=Lobster|Shadows+Into+Light" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
</head>
<body>

    <h1>${tra.travelplanname}</h1>

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
                    <a class="navbar-brand" href="goToNotendasida"><img src="/css/logo3.png" alt="Dispute Bills">
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
                                <li><a href="aboutCampALot.jsp">About Camp'A'Lot</a></li>
                                <li><a href="help">Help</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
                <!--/.nav-collapse -->
            </div>
            <!--/.container-fluid -->
        </nav>
    </div>

    <table class="table">
        <thead>
        <tr>
            <th>Camp</th>
            <th>From</th>
            <th>To</th>
            <th>Total price</th>
        </tr>
        </thead>
        <c:forEach var="travelplan" items="${travelplans}" >
            <tr>
                <td> ${travelplan.campname} </td>
                <td> ${travelplan.datearrive}</td>
                <td> ${travelplan.datedepart}</td>
                <td> ${travelplan.totalprice}</td>
            </tr>
        </c:forEach>
    </table>
    <form method="get" action = "onetravel">
        <select name = "travelname">
            <c:forEach var="travelname" items="${travelplan}">
                <option name="travelname" value="${travelname.travelplanname}">${travelname.travelplanname}</option>
            </c:forEach>
        </select>
        <button type="submit">Go</button>
    </form>

</body>
</html>
