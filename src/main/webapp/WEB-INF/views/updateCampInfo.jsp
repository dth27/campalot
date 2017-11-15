<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Admin - Change info in the selected Camp</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css?v=1">
    <spring:url value="/css/style.css" var="crunchifyCSS" />
    <link href="${crunchifyCSS}" rel="stylesheet" />
</head>

<body>
<h1>Change the info as wanted in the selected camp ${camp.campname}</h1>


<form method = "POST" action = "updateCamp">
    <div class="container">

        <h2>Please change the information as wanted for the camp ${camp.campname} and press the "Update Camp Info" button </h2>

        <label><b>Camp's address</b></label>
        <input type="text" placeholder="Type the camp's address" name="campaddress" value="${camp.campaddress}"></input><br><br>

        <label><b>Camp's zip code</b></label>
        <input type="text" placeholder="Type the camp's zip code" name="campzip" value="${camp.campzip}"></input><br><br>

        <label><b>Camp's email address</b></label>
        <input type="text" placeholder="Type the camp's email address" name="campemail" value="${camp.campemail}"></input><br><br>

        <label><b>Camp's phone number</b></label>
        <input type="text" placeholder="Type the camp's phone number" name="campphone" value="${camp.campphone}"></input><br><br>

        <label><b>Camp's website</b></label>
        <input type="text" placeholder="Type the camp's website" name="campwebsite" value="${camp.campwebsite}"></input><br><br>

        <label><b>Camp's opening season</b></label>
        <input type="text" placeholder="Type the camp's opening season" name="campseason" value="${camp.campseason}"></input><br><br>

        <label><b>Camp's main category</b></label>
        <input type="text" placeholder="e.g. gisting, veitingar, upplýsingar etc." name="maincategory" value="${camp.maincategory}"></input><br><br>

        <label><b>Camp's category</b></label>
        <input type="text" placeholder="e.g. tjaldsvæði, bændagisting, farfuglaheimili, hostel etc." name="category" value="${camp.category}"></input><br><br>

        <label><b>Camp's region</b></label>
        <select name="region" value="${camp.region}">
            <option value="Sudurland">Sudurland</option>
            <option value="Vestfirdir">Vestfirdir</option>
            <option value="Hofudborgarsvaedi">Hofuðborgarsvaedid</option>
            <option value="Austurland" >Austurland</option>
            <option value="Nordurland">Norðurland</option>
            <option value="Reykjanes">Reykjanes</option>
            <option value="Vesturland" >Vesturland</option>
            <option value="Halendid">Halendid</option>
        </select><br><br>

        <label><b>Camp's description</b></label><br>
        <textarea cols = "50" rows = "10" placeholder="Type the camp's description" name="description">${camp.description}</textarea><br><br>

        <label><b>Camp's location value x</b></label>
        <input type="text" placeholder="Type the camp's x value" name="xval" value="${camp.xval}"></input><br><br>

        <label><b>Camp's location value y</b></label>
        <input type="text" placeholder="Type the camp's y value" name="yval" value="${camp.yval}"></input><br><br>

        <label><b>Camp's price</b></label>
        <input type="text" placeholder="Type the camp's price" name="price" value="${camp.price}"></input><br><br>

    </div>

    <button type="submit" name="campname" value="${camp.campname}">Update Camp info</button>
</form>

<form method = "GET" action = "goBack">
    <button type = "submit">Cancel</button>
</form>

</body>
</html>