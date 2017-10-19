<%--
  Created by IntelliJ IDEA.
  User: Dottedsocks
  Date: 19/10/2017
  Time: 09:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Camp to TravelPlan</title>
</head>
<body>
<form action="addTravelitem" method="POST" >
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
                <td name="campS"> ${camp.campname} </td>
                <td name="date"> <input type="date" name="date"/> </td>
                <td name="date"> <input type="date" name="date"/> </td>
                <td>
                    <select name = "travel">
                        <c:forEach items="${travelplans}" var="travel">
                            <option value="travel">${travel.travelplanname}</option>
                        </c:forEach>
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
