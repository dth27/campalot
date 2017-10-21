<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Review</title>
    <spring:url value="/css/style.css" var="crunchifyCSS" />
    <link href="${crunchifyCSS}" rel="stylesheet" />
</head>

<body>
<h1>Give ${campinfo.campname} a review</h1>
<ul>
    <li><a href="listofcamps">All campsites</a></li>
    <li><a href="">My travelplans</a></li>
    <li><a href="UserReviews">User reviews</a></li>
    <li><a href="accountInfo">My account</a></li>
</ul>

<h2>Write a review for ${camp.campname} <h2></h2><br><br>
<form method = "POST" action = "postReview">
    <textarea cols = "50" rows = "10" placeholder="Type your review" name="myReview" required></textarea><br><br>
    <button type="submit" name="campName" value="${camp.campname}">Submit</button>
</form>

</body>
</html>