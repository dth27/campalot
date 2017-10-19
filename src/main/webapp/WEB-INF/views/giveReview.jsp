<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Review</title>
</head>

<body>
<form method = "POST" action = "postReview">
    <label><b>Your review for ${camp.campname} </b></label>
    <textarea cols = "50" rows = "10" placeholder="Type your review" name="myReview" required></textarea>
    <button type="submit" name="campName" value="${camp.campname}">Submit</button>
</form>

</body>
</html>