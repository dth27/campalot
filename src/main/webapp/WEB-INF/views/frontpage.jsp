
<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Velkominn</title>
    <spring:url value="/css/style.css" var="crunchifyCSS" />
    <link href="${crunchifyCSS}" rel="stylesheet" />
</head>
<body>
<h1>Welcome to Camp'a'Lot!</h1>

<h2>Check out the Campsites</h2>
<form method = "get" action="listofcamps" class="frontpageForm">
    <input type="submit" value="Allir"/>
</form>
<div class="maincontainer">
<h2>Log in!</h2>
<form action="login" method="post">

    <div class="container">
        <label><b>Username</b></label>
        <input type="text" placeholder="Enter Username" name="uname" required>

        <label><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="psw" required>

        <button type="submit" method="POST" action="login">Login</button>

        <input type="checkbox" checked="checked"> Remember me
    </div>

    <div class="container">
        <button type="button" class="cancelbtn">Cancel</button>
        <span class="psw">Forgot <a href="#">password?</a></span>
        <button onclick="showPopupWindow()" type="button" >New Account</button>
    </div>
</form>
</div>
<script>
    function showPopupWindow() {
        var myWindow = window.open(action = "newAccountSite", "", "width=600,height=300");}
</script>

</body>
</html>
