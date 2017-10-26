<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>User Reviews</title>
    <link rel="stylesheet" type="text/css" href="/css/testing.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <h1>Reviews</h1>
    <nav class="navbar navbar-inverse" data-spy="affix" data-offset-top="197">
        <ul class="nav navbar-nav">
            <li><a href="listofcamps">All campsites</a></li>
            <li><a href="">My travelplans</a></li>
            <li><a href="UserReviews">User Reviews</a></li>
            <li><a href="accountInfo">My account</a></li>
        </ul>
    </nav>

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