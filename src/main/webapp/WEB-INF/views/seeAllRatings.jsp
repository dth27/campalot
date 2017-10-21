<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>All Ratings</title>
    <spring:url value="/css/campinf.css" var="crunchifyCSS" />
    <link href="${crunchifyCSS}" rel="stylesheet" />
</head>
<body>
<h1>All Ratings</h1>
<ul>
    <li><a href="listofcamps">All campsites</a></li>
    <li><a href="">My travelplans</a></li>
    <li><a href="UserReviews">User reviews</a></li>
    <li><a href="accountInfo">My account</a></li>
</ul>

<br><br>
<h2>Here you can see what others rated ${campinfo.campname}</h2>
<table border="1">
    <thead>
    <tr>
        <th>Ratings</th>
        <th>Author</th>
    </tr>
    </thead>
    <c:forEach items="${ratings}" var="r" >
        <tr>
            <td>  ${r.rating} </td>
            <td> ${r.username} </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
