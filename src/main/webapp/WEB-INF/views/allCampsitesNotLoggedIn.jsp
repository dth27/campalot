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
    <title>All Campsites</title>
    <link rel="stylesheet" type="text/css" href="/css/allCampsitesLook.css?v=1">
    <link href="https://fonts.googleapis.com/css?family=Lobster|Open+Sans+Condensed:300" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<p class="headTxt">All campsites</p>
<div style="font-family: Open Sans Condensed, sans-serif">
    <form action = "goToFrontpage">
        <button type = "submit">Log in</button>
    </form>
</div>
<br>
<br>
<div class="maincontainer">
<h3>Find campsites located in a specific part of the country:</h3>
    <div class="areas">
        <form action="showCamps" method="POST" class = "sort">
            <select name="area">
                <option value="All">All</option>
                <option value="Sudurland">Sudurland</option>
                <option value="Vestfirdir">Vestfirdir</option>
                <option value="Hofudborgarsvaedi">Hofuðborgarsvaedid</option>
                <option value="Austurland" >Austurland</option>
                <option value="Nordurland">Norðurland</option>
                <option value="Reykjanes">Reykjanes</option>
                <option value="Vesturland" >Vesturland</option>
                <option value="Halendid">Halendid</option>
            </select>
            <button>Sort</button>
        </form>
    </div>
<br>
<br>

    <div class="map" style="display: block; margin-left: 15%; background: url(&quot;css/island.png&quot;); position: relative; padding: 0px; width: 471px; height: 321px;">
        <canvas style="width: 471px; height: 321px; position: absolute; left: 0px; top: 0px; padding: 0px; border: 0px; opacity: 1;" height="321" width="471"></canvas>
        <img src="css/island.png" width="471" height="321" border="0" class="map maphilighted" usemap="#fMap" style="opacity: 0; position: absolute; left: 0px; top: 0px; padding: 0px; border: 0px;"></div>
    <form action="showCamps" method="get" class="sort" >
        <map name="fMap" id="fMap">
            <area shape="poly" coords="129,110,134,100,119,82,132,88,135,67,130,63,134,58,124,52,121,41,114,33,104,29,90,7,86,12,71,7,70,14,63,19,63,20,78,22,82,20,83,24,89,29,71,30,71,37,87,46,89,49,94,57,93,70,92,73,88,59,83,67,84,55,74,50,69,52,68,43,65,39,52,31,41,35,51,49,35,43,32,47,50,64,33,58,27,64,42,74,55,75,55,77,46,79,46,83,35,79,25,72,21,70,20,71,24,93,12,84,0,98,13,103,24,108,33,106,44,103,57,101,65,100,75,101,87,102,88,102,95,112,100,105,111,110,128,110"
                  alt="Vestfirðir" name="area" value="Vestfirdir" href="showVestfirdir" onclick="form.action='showVestfirdir';">
            <area shape="poly" coords="176,177,112,117,100,117,77,136,99,144,105,141,112,134,115,137,110,145,112,153,80,149,74,153,70,146,61,156,57,152,48,152,48,158,43,155,40,155,30,161,25,157,11,160,11,163,14,168,21,177,28,173,29,172,37,172,42,169,43,169,52,171,61,173,69,175,75,177,83,180,84,181,82,189,82,193,89,209,93,204,111,197,101,205,100,207,98,207,92,213,91,217,90,221,92,223,89,230,93,230,107,219,111,218,111,220,109,222,108,222,103,226,102,228,112,232,176,178"
                  alt="Vesturland"  name="area" value="Vesturland" href="showVesturland" onclick="form.action='showVesturland';">
            <area shape="poly" coords="120,116,131,115,135,116,140,125,140,109,144,113,148,94,159,86,160,88,160,97,171,93,169,51,181,43,187,56,194,70,199,70,201,83,212,83,209,76,207,69,203,62,210,60,207,50,222,49,230,39,238,38,249,48,251,58,260,62,270,92,268,65,262,55,257,41,268,41,278,45,288,59,297,57,298,57,298,47,302,44,302,37,313,33,317,43,331,37,335,27,328,18,328,6,336,4,340,9,347,0,355,4,353,10,368,15,361,26,371,30,378,38,378,28,387,25,390,16,398,12,403,15,414,12,414,14,404,20,394,25,397,32,387,42,389,44,392,46,394,46,394,48,359,87,338,118,323,156,313,182,295,181,266,177,251,176,241,174,183,174,155,149,119,117"
                  alt="Norðurland"  name="area" value="Nordurland" href="showNordurland" onclick="form.action='showNordurland';" >
            <area shape="poly" coords="415,41,419,51,417,56,414,64,409,71,410,74,411,81,424,73,433,69,430,80,445,89,453,84,453,92,452,95,464,95,464,107,459,111,456,112,450,120,464,116,466,123,455,129,469,129,470,130,470,143,468,147,450,144,464,153,460,161,454,169,450,175,444,177,442,177,429,172,443,183,434,186,433,187,437,192,433,196,436,209,419,212,413,210,347,190,335,186,331,185,320,184,328,160,342,123,356,102,364,90,405,45"
                  alt="Austurland"  name="area" value="Austurland" href="showAusturland" onclick="form.action='showAusturland';">
            <area shape="poly" coords="416,216,412,219,410,227,393,227,386,234,376,238,371,239,352,260,337,277,322,280,312,281,302,284,298,284,289,290,279,307,268,312,262,315,258,318,256,318,252,320,247,320,242,319,235,317,231,317,224,319,221,319,207,313,195,308,193,307,175,307,148,280,140,273,137,272,132,271,130,269,128,264,127,264,125,269,109,273,108,272,107,257,110,255,112,254,114,252,116,250,117,246,117,235,183,181,240,181,283,185,305,188,327,190,403,212"
                  alt="Suðurland" value="Sudurland" name="area" href="showSudurland" onclick="form.action='showSudurland';">
            <area shape="poly" coords="61,271,76,270,101,272,102,258,98,256,91,253,89,250,83,252,78,254,73,257,64,244,64,257,63,264"
                  alt="Reykjanes" name="area" value="Reykjaknes" href="showReykjanes" onclick="form.action='showReykjanes';" >
            <area shape="poly" coords="104,239,102,232,104,232,109,234,111,237,112,244,111,246,107,251,98,251,95,248,98,248,96,238,99,238"
                  alt="Höfuðborgarsvæðið" name="area" value="Hofudborgarsvaedid" href="showHofud" onclick="form.action='showHofud';" >

        </map>
    </form>


<div class="tablecontainer">
    <form action="getInfo" method="POST"  class = "tafla">
        <table class="table table-hover" border="1">
            <thead>
            <tr>
                <th>Name</th>
                <th>Area</th>
            </tr>
            </thead>
            <c:forEach items="${camps}" var="camp" >
                <tr>
                    <td> <button class = "btn btn-block" name="campName" type ="submit" value="${camp.campname}">${camp.campname}</button> </td>
                    <td> ${camp.region} </td>
                </tr>
            </c:forEach>
        </table>
    </form>
</div>

</div>
<div class="bottom-nav">
    Created By Diljá, Kristín, Ólöf og Sandra
</div>
</body>
</html>
