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
    <title>All CampSites</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <form action="showCamps" method="POST">
        <select name="area">
            <option value="All">All</option>
            <option value="Sudurland">Sudurland</option>
            <option value="Vestfirdir">Vestfirdir</option>
            <option value="Hofudborgarsvaedi">Höfuðborgarsvæðið</option>
            <option value="Austurland" >Austurland</option>
            <option value="Nordurland">Norðurland</option>
            <option value="Reykjanes">Reykjanes</option>
            <option value="Vesturland" >Vesturland</option>
            <option value="Halendid">Hálendið</option>
        </select>
        <button>OK</button>
</form>

    <h1>All Campsites </h1>
    <form action="getInfo" method="POST" >
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
</body>
</html>
