<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<br>
<head>
    <title>Information for admin</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css?v=1">
    <link rel="stylesheet" type="text/css" href="/css/help.css">
    <link href="https://fonts.googleapis.com/css?family=Lobster|Cabin" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h1>Help</h1>
<p class = "loggedIn">You are logged in as: <b class="username">${username}</b></p>
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
                <a class="navbar-brand" href="goToAdminsida"><img src="/css/logo3.png" alt="Dispute Bills">
                </a>
            </div>
            <div id="navbar1" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="goToAdminsida">Admin site</a></li>
                    <li><a href="helpAdmin">Help</a></li>
                        </ul>
                    </li>
                </ul>
                <a class = "right" href = "logOut">Log out</a>
            </div>
            <!--/.nav-collapse -->
        </div>
        <!--/.container-fluid -->
    </nav>
</div>
<br>
<h1>How to ...</h1>

<h2>How to create a new camp:</h2>
<p>
    1. Where you can see "Add a new camp to the database" type into the textbox the name of the new camp you wish to add.<br>
    2. Click on the button "Add camp".<br>
    3. You will then be directed to a new page where you can fill in the information of the new camp.<br>
    4. Fill in all the information you have regarding the new camp. You don't have to fill in all the boxes, just skip anything you don't have information about.<br>
    5. Click on the button "Add camp" to create the new camp with your information, or in case you would like to cancel creating the new camp click on the button "Cancel".<br>
    <br>
    after these steps, your new camp should be added to the list of camps and be seen at the bottom of the list.
</p>

<h2>How to update the information of a camp:</h2>
<p>
    1. Find the camp you would like to update, in the list of camps. If you know in which region the camp is located, you can use sort to find the camp quickly.<br>
    2. Click on the button "Update" which is located on the right side to your camp's name.<br>
    3. You will then be directed to a new page where you can change any information you like of the selected camp, by changing the text in the textboxes of each item.<br>
    4. Click on the button "Update Camp Info" to update the information, or in case you would like to cancel the update click on the button "Cancel".<br>
    <br>
    After these steps, the camp should be have the updated information. To see the information of the camp, click on the name of the camp.
</p>

<h2>How to delete a camp from the database:</h2>
<p>
    1. Find the camp you would like to delete, in the list of camps. If you know in which region the camp is located, you can use sort to find the camp quickly.<br>
    2. Click on the button "Delete" which is located on the right side to your camp's name.<br>
    3. You will then be directed to a new page where you are asked if you are sure you would like to delete the chosen camp.<br>
    4. Click on the button "YES" if you are sure you would like to delete the camp, else click on the button "Cancel".<br>
    <br>
    After these steps, you should have deleted the chosen camp.
    <br>
    <br>
    <br>
    <br>
</p>

<br>
<br>

<div class="bottom-nav">
    Created By Diljá, Kristín, Ólöf og Sandra
</div>
<br>
<br>
<br>

</body>
</html>