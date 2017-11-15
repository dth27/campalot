<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<br>
<head>
    <title>Information</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css?v=2">
    <link rel="stylesheet" type="text/css" href="/css/campInfoLook.css?v=2">
    <link href="https://fonts.googleapis.com/css?family=Lobster|Cabin" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h1>Information about ${campinfo.campname}</h1>

<br>
<div class="mainContainer">
    <div id="description">
            <h2>Name</h2>
            ${campinfo.campname}
            <h2>Description</h2>
            ${campinfo.description}
    </div>
    <div class="container-info">
        <div class="container-contact">
                <h3 id="adress">Address</h3>
                ${campinfo.campaddress}
                ${campinfo.campzip}
                <h3 id="contactinfo">Contact information</h3>
                ${campinfo.campemail}
                ${campinfo.campphone}
                ${campinfo.campwebsite}
            </div>
        <div class="rating">
        <h3>Average Rating</h3>
        ${campinfo.averagerating}
    </form>
    </div>
    </div>
</div>

<form action = "goToFrontpage">
    <button type = "submit">Log in to see more information</button>
</form>
<br>
<button onclick=window.history.back(); type="button" id="myPopup">Go back to all campsites!</button>
<br><br><br>
<div class="bottom-nav">
    Created By Diljá, Kristín, Ólöf og Sandra
</div>
</body>
</html>