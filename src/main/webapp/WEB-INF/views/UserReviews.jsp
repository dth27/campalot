<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>User Reviews</title>
    <spring:url value="/css/campinf.css" var="crunchifyCSS" />
    <link href="${crunchifyCSS}" rel="stylesheet" />
</head>
<body>
    <h1>Reviews</h1>
    <ul>
        <li><a href="listofcamps">All campsites</a></li>
        <li><a href="">My travelplans</a></li>
        <li><a href="UserReviews">User reviews</a></li>
        <li><a href="accountInfo">My account</a></li>
    </ul>

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