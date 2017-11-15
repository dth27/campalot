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
    <title>My account</title>
    <link rel="stylesheet" type="text/css" href="/css/testing2.css?v=1">

    <link href="https://fonts.googleapis.com/css?family=Lobster|Shadows+Into+Light" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h1>My account</h1>
<div class = info>
    <br><br>
    <h2>This is your account information!</h2>

    <p><b>Username: </b>${user.username}</p>
    <p><b>Email: </b>${user.email}</p>
    <br>
    <button type="button" onclick="javascript:window.close()">Close
    </button>
    <br>
</div>


<br>


</body>
</html>
