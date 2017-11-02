<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Admin - Add new Camp</title>
    <spring:url value="/css/style.css" var="crunchifyCSS" />
    <link href="${crunchifyCSS}" rel="stylesheet" />
</head>

<body>
<h1>Add ${campname} to the list of camps</h1>


<form method = "POST" action = "addNewCamp">
    <div class="container">

        <h2>Please fill in the information for the new camp ${campname} and press the OK button </h2>

        <label><b>Camp's address</b></label>
        <input type="text" placeholder="Type the camp's address" name="campaddress"></input><br><br>

        <label><b>Camp's zip code</b></label>
        <input type="text" placeholder="Type the camp's zip code" name="campzip"></input><br><br>

        <label><b>Camp's email address</b></label>
        <input type="text" placeholder="Type the camp's email address" name="campemail"></input><br><br>

        <label><b>Camp's phone number</b></label>
        <input type="text" placeholder="Type the camp's phone number" name="campphone"></input><br><br>

        <label><b>Camp's website</b></label>
        <input type="text" placeholder="Type the camp's website" name="campwebsite"></input><br><br>

        <label><b>Camp's opening season</b></label>
        <input type="text" placeholder="Type the camp's opening season" name="campseason"></input><br><br>

        <label><b>Camp's main category</b></label>
        <input type="text" placeholder="e.g. gisting, veitingar, upplýsingar etc." name="maincategory"></input><br><br>

        <label><b>Camp's category</b></label>
        <input type="text" placeholder="e.g. tjaldsvæði, bændagisting, farfuglaheimili, hostel etc." name="category"></input><br><br>

        <!-- TODO: breyta þessu yfir í dropdown lista þar sem maður velur þær "region" sem eru í boði, sjá campInfo.jsp (lína 27) -->
        <label><b>Camp's region</b></label>
        <input type="text" placeholder="Type the camp's region" name="region"></input><br><br>

        <!-- TODO: breyta þessu yfir í textarea -->
        <label><b>Camp's description</b></label>
        <input type="text" placeholder="Type the camp's description" name="description"></input><br><br>

        <!-- TODO: breyta textanum xval í eitthvað meira lýsandi í label og placeholder -->
        <label><b>Camp's xval</b></label>
        <input type="text" placeholder="Type the camp's xval" name="xval"></input><br><br>

        <!-- TODO: breyta textanum yval í eitthvað meira lýsandi í label og placeholder -->
        <label><b>Camp's yval</b></label>
        <input type="text" placeholder="Type the camp's yval" name="yval"></input><br><br>

    </div>

    <button type="submit" name="campname" value="${campname}">Add Camp</button>
</form>

</body>
</html>