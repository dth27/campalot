<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<br>
<head>
    <title>Information</title>
    <link rel="stylesheet" type="text/css" href="/css/campInfoLook.css?v=2">
    <link href="https://fonts.googleapis.com/css?family=Lobster|Open+Sans+Condensed:300" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<p class="headTitle">Information about ${campinfo.campname}</p>
<br>
<div class="mainContainer">
    <div id="description">
        <h2>Name</h2>
        <p class="campname"> ${campinfo.campname} </p>
        <h2>Description</h2>
        <p class="description2"> ${campinfo.description} </p>
    </div>
    <div class="container-info">
        <div class="container-contact">
            <h3>Address</h3>
            <p class="address">
                ${campinfo.campaddress}
                ${campinfo.campzip}
            </p>
            <h3>Contact information</h3>
            <p class="contactinfo">
                ${campinfo.campemail}
                ${campinfo.campphone}
                ${campinfo.campwebsite}
            </p>
        </div>
        <h3>Price: </h3>
        <p class="price">${campinfo.price} ISK per night</p>
        <h3>Average Rating</h3>
        <p class="avgrating">${campinfo.averagerating}</p>
    </form>
    </div>
    </div>
</div>
<div class="takkar">
<form action = "goToFrontpage">
    <button type = "submit">Log in to see more information!</button>
</form>
<br>
<button onclick=window.history.back(); type="button" id="myPopup">Go back to all campsites!</button>
</div>
<br><br><br>
<div class="bottom-nav">
    Created By Diljá, Kristín, Ólöf og Sandra
</div>
</body>
</html>