<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>User Reviews</title>
    <link rel="stylesheet" type="text/css" href="/css/testing2.css">
    <link href="https://fonts.googleapis.com/css?family=Lobster|Lobster+Two" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <h1>Reviews</h1>
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
                    <a class="navbar-brand" href="forsida"><img src="/css/tent.jpg" alt="Dispute Bills">
                    </a>
                </div>
                <div id="navbar1" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="listofcamps">Campsites</a></li>
                        <li><a href="myTravelplans">My Travelplans</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">My account <span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="accountInfo">My information</a></li>
                                <li><a href="UserReviews">My reviews</a></li>
                                <li class="divider"></li>
                                <li class="dropdown-header">Nav header</li>
                                <li><a href="#">Separated link</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
                <!--/.nav-collapse -->
            </div>
            <!--/.container-fluid -->
        </nav>
    </div>


    <br><br>
    <h2>Here you can see what others have to say about the campsites</h2>
    <h3>Whether they liked them or not</h3>
    <br>
    <table border="1">
        <thead>
        <tr>
            <th>Campname</th>
            <th>Reviews</th>
            <th>Author</th>
        </tr>
        </thead>
        <c:forEach items="${reviews}" var="r" >
            <tr>
                <td> ${r.campname}</td>
                <td>  ${r.review} </td>
                <td> ${r.username} </td>
            </tr>
        </c:forEach>
    </table>
</body>