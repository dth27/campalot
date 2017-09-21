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
    <title>New Travel Plan</title>
</head>
<body>

<h1>Create a new travel plan</h1>


<form action="/campsites/newTravel" method="post">
    <div class="container">
        <label><b>Username</b></label>
        <input type="text" placeholder="Enter Username" name="username" required>
        <label><b>Plan name</b></label>
        <input type="text" placeholder="Enter Name" name="planName" required>
    </div>

    <button type="submit">submit</button>
</form>
<script>
    function loka(){
        window.close();
        window.onunload = refreshParent;
        function refreshParent() {
            window.opener.location.reload();
        }
    }

</script>
</body>
</html>
