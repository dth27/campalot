<%--
  Created by IntelliJ IDEA.
  User: Dottedsocks
  Date: 14/09/2017
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>All Campsites</title>
    
    <link rel="stylesheet" type="text/css" href="/css/style.css?v=1">
    <link rel="stylesheet" type="text/css" href="/css/allCampsitesLook.css?v=1">
    <link href="https://fonts.googleapis.com/css?family=Lobster|Shadows+Into+Light|Cabin" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h1>All campsites</h1>

<button>Log in</button>

<br><br>
<h3>Find campsites located in a specific part of the country:</h3>
    <form action="showCamps" method="POST" class = "sort">
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
        <button>Sort</button>
</form>
<br><br>




    <form action="getInfo" method="POST"  class = "tafla">
        <table border="1">
            <thead>
            <tr>
                <th>Name</th>
                <th>Area</th>
            </tr>
            </thead>
            <c:forEach items="${camps}" var="camp" >
                <tr>
                    <td> <button name = "campName" type ="submit" value="${camp.campname}">${camp.campname}</button> </td>
                    <td> ${camp.region} </td>
                </tr>
            </c:forEach>
        </table>
    </form>
<div class="bottom-nav">
    Created By Diljá, Kristín, Ólöf og Sandra
</div>
</body>
</html>
