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
    <spring:url value="/css/campinf.css" var="crunchifyCSS" />
    <link href="${crunchifyCSS}" rel="stylesheet" />
</head>
<body>
<h1>My account</h1>
<ul>
    <li><a href="listofcamps">All campsites</a></li>
    <li><a href="">My travelplans</a></li>
    <li><a href="UserReviews">User reviews</a></li>
    <li><a href="accountInfo">My account</a></li>
</ul>
<br><br>
<h2>This is your account information!</h2>
<br>
    <button onclick=window.close(); type="button" id="myPopup">Close</button>

</body>
</html>
