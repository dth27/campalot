<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
    <spring:url value="/css/campinf.css" var="crunchifyCSS" />
    <link href="${crunchifyCSS}" rel="stylesheet" />
</head>
<body>
<h1>Welcome to Camp'A'Lot</h1>
<ul>
    <li><a href="listofcamps">All campsites</a></li>
    <li><a href="">My travelplans</a></li>
    <li><a href="UserReviews">User reviews</a></li>
    <li><a href="accountInfo">My account</a></li>
</ul>
<br><br>
<h2>Sorry, you have to log in to be able to do that!</h2>
<br><br>
<form action="/forsida" method="post">
    <button>
        Log in
    </button>
</form>
</body>
</html>
