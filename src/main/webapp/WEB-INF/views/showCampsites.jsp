<%--
  Created by IntelliJ IDEA.
  User: Dottedsocks
  Date: 14/09/2017
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Velkominn</title>
    <p class = "loggedIn">You are logged in as: <b class="username">${username}</b></p>
    <link rel="stylesheet" type="text/css" href="/css/testing.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <h1>Hello ${Traveller.getUsername()}</h1>
    <h1>All information ${Traveller}</h1>
    <form method = "get" action="/listofcamps">
        <input type="submit" value="Allir"/>
    </form>
    <form method="get" action="/askTraveller">
        <input type="submit" value="New campsite"/>
    </form>
    <div class="bottom-nav">
        Created By Diljá, Kristín, Ólöf og Sandra
    </div>
</body>
</html>
