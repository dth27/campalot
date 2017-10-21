
<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Welcome</title>
    <spring:url value="/css/style.css" var="crunchifyCSS" />
    <link href="${crunchifyCSS}" rel="stylesheet" />
</head>
<body>
<h1>Welcome to Camp'A'Lot!</h1>

<h2>Check out the Campsites</h2>
<form method = "get" action="listofcamps" class="frontpageForm">
    <div style="text-align:center">
    <input type="submit" value="All campsites"/><br><br>
    </div>
</form>
<div class="maincontainer">
<form action="login" method="post">
    <fieldset>
        <legend>Log in:</legend>
        Username:<br>
        <input type="text" placeholder="Enter username" name="uname" required><br>
        Password:<br>
        <input type="text" placeholder="Enter password" name="psw" required><br><br>
        <button type="submit" method="POST" action="login">Login</button>
        <input type="checkbox" checked="checked"> Remember me <br><br>
        <span class="psw">Forgot <a href="#">password?</a></span>
        <button onclick="showPopupWindow()" type="button" >Sign up!</button>
    </fieldset>

    <%--<div class="container">
        <label><b>Username</b></label>
        <input type="text" placeholder="Enter Username" name="uname" required>

        <label><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="psw" required>

        <button type="submit" method="POST" action="login">Login</button>

        <input type="checkbox" checked="checked"> Remember me
    </div>


    <div class="container">
        <br>
        <button type="button" class="cancelbtn">Cancel</button>
        <span class="psw">Forgot <a href="#">password?</a></span>
        <button onclick="showPopupWindow()" type="button" >Sign up!</button>
    </div>
    --%>
</form>
</div>
<script>
    function showPopupWindow() {
        var myWindow = window.open(action = "newAccountSite", "", "width=600,height=300");}
</script>

</body>
</html>
