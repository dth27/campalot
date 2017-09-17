<!DOCTYPE html>

<!--
@author Ólöf Fríða Magnúsdóttir , ofm1@hi.is
@author Sandra Mar Huldudóttir
@author Kristín María Tómasdóttir
@author Diljá Þorkelsdóttir
Kóði fenginn frá Ebbu
-->

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Hver er notandinn</title>
</head>
<body>

<h1></h1>

<form method="POST" action="/demo/hver">
    What is your name? <input name="nafn" type ="text" placeholder="Nafn"> </input>
    <input type="submit" value="Submit"/>
</form>

</body>

</html>