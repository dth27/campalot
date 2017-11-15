<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>UserSite</title>

    <link rel="stylesheet" type="text/css" href="/css/style.css?v=1">
    <link rel="stylesheet" type="text/css" href="/css/testing.css">

    <link href="https://fonts.googleapis.com/css?family=Lobster|Cabin" rel="stylesheet">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h1>Welcome admin! Here you can add new Campsites, update or delete them! </h1>
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

<br><br>

<div>
    ${AdminMessage}
</div>

<br><br>
<form method = "POST" action = "addNewCampRequest">
    <h3>Add a new camp to the database:</h3>
    <div class="container">
        <label><b>Camp's name</b></label>
        <input type="text" placeholder="Type the new camp's name" name="newCampName"></input><br><br>
    </div>
    <button type="submit" name="campname" value="${camp.campname}">Add Camp</button>
</form>

<br><br>
<form action="adminShowCamps" method="POST">
    <select name="area">
        <option value="All">All</option>
        <option value="Sudurland">Sudurland</option>
        <option value="Vestfirdir">Vestfirdir</option>
        <option value="Hofudborgarsvaedi">Hofuðborgarsvaedid</option>
        <option value="Austurland" >Austurland</option>
        <option value="Nordurland">Norðurland</option>
        <option value="Reykjanes">Reykjanes</option>
        <option value="Vesturland" >Vesturland</option>
        <option value="Halendid">Halendid</option>
    </select>
    <!-- TODO: Gera drop down listann þannig að þegar maður velur eitthvað og ýtir á sort, þá geymist valið í glugganum og sést hvað er verið að sýna (þar til valið er eitthvað annað næst) -->
    <button>Sort</button>
</form>


<br><br>
<form action="adminGetInfo" method="POST" >
    <table border="1">
        <thead>
        <tr>
            <th>Name</th>
            <th>Area</th>
            <th>Update info</th>
            <th>Delete Camp</th>
        </tr>
        </thead>
        <c:forEach items="${camps}" var="camp" >
            <tr>
                <td> <button name = "campName" type ="submit" value="${camp.campname}">${camp.campname}</button> </td>
                <td> ${camp.region}</td>
                <td> <button name = "campName" type = "submit" value="${camp.campname}" onclick="form.action='updateCampRequest';">Update</button> </td>
                <td> <button name = "campname" type = "submit" value="${camp.campname}" onclick="form.action='delCampRequest';">Delete</button> </td>
            </tr>
        </c:forEach>
    </table>
</form>


</body>
</html>