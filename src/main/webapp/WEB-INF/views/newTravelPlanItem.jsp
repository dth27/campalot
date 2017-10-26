<%--
  Created by IntelliJ IDEA.
  User: Dottedsocks
  Date: 19/10/2017
  Time: 09:38
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Camp to TravelPlan</title>
</head>
<body>
<form action="addTravelitem" method="post" >
    <table border="1">

        <thead>
        <tr>
            <th>Name</th>
            <th>From</th>
            <th>To</th>
            <th>Choose Travelplan</th>
        </tr>
        </thead>

            <tr>
                <td name="camps" value="${camp.campname}"> ${camp.campname} </td>
                <td name="datearrive"> <input type="date" name="datearrive"/> </td>
                <td name="datedepart"> <input type="date" name="datedepart"/> </td>
                <td>
                     <select name = "travels">
                        <c:forEach var="travel" items="${travelplans}">
                        <option name="travel" value="${travel.travelplanname}">${travel.travelplanname}</option>
                        </c:forEach>
                         <option name="travel" value="Our plan">Our plan</option>
                    </select>
                </td>
                <td>
                    <button type="submit" name="buttonid">Add to TravelPlan</button>
                </td>
            </tr>

    </table>
</form>
</body>
</html>
