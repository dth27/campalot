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
    <link rel="stylesheet" type="text/css" href="/css/style.css">
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
</body>
</html>
