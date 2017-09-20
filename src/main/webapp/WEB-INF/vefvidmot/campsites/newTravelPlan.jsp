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
    <title>New travel plan</title>
</head>
<body>

<h1>new travel plan </h1>

<form action="/campsites/newTravel" method="post">

    <div class="container">
        <label><b>Username</b></label>
        <input type="text" placeholder="Enter Username" name="username" required>

        <label><b>Plan name</b></label>
        <input type="text" placeholder="Enter Name" name="planName" required>

        <button type="submit" method="POST" action="/campsites/newTravel">submit</button>


    </div>

</form>

</body>
</html>
