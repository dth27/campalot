<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>UserSite</title>
    <link rel="stylesheet" type="text/css" href="/css/testing.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h1>Welcome admin! Here you can add new Campsites, update or delete them! </h1>


<br><br>

<div>
    ${AdminMessage}
</div>

<br><br>
<form method = "POST" action = "addNewCampRequest">
    <h3>Add a new camp to the database:</h3>
    <div class="container">
        <label><b>Camp's name</b></label>
        <input type="text" placeholder="Type the camp's name" name="newCampName"></input><br><br>
    </div>
    <button type="submit" name="campname" value="${camp.campname}">Add Camp</button>
</form>


</body>
</html>