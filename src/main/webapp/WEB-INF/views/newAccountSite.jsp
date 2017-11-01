<%--
  Created by IntelliJ IDEA.
  User: Dottedsocks
  Date: 14/09/2017
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>New Account</title>
    <link rel="stylesheet" type="text/css" href="/css/testing.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>

<h1>New Account</h1>


</div>


<%--@elvariable id="newUserForm" type="is.hi.model.userAccess"--%>
<form:form action="/newAccount" method="post" modelAttribute="newUserForm">

    <div class="maincontainer">

        <form:label path="email" for="email"><b>Email</b></form:label><br>
        <form:input path="email" placeholder="Enter Email"></form:input><br>
        <form:errors path="email" style="color: RED"></form:errors><br>
        <form:label path="username" for="username"><b>Username</b></form:label><br>
        <form:input path="username" placeholder="Enter Username"></form:input><br>
        <form:errors path="username" style="color: RED"></form:errors><br>
        <form:label path="password" for="pw1"><b>Password</b></form:label><br>
        <form:input path="password" type="password" placeholder="Enter Password"></form:input><br>
        <form:errors path="password" style="color: RED"></form:errors><br>
        <label for="pw"><b>Re-enter password</b></label><br>
        <input type="password" placeholder="Enter Password" name="pw" id="pw"><br><br>
        <p style="color: RED">${passwordError}</p>

        <button type="submit" method="POST" action="campsites/newAccount">submit</button>


    </div>
</form:form>
</body>
</html>
