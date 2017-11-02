<%--
  Created by IntelliJ IDEA.
  User: Dottedsocks
  Date: 01/11/2017
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My TravelPlans</title>
</head>
<body>
    <h1>${tra.travelplanname}</h1>

    <table>
        <thead>
        <tr>
            <th>Camp</th>
            <th>From</th>
            <th>To</th>
            <th>Total price</th>
        </tr>
        </thead>
        <c:forEach var="travelplan" items="${travelplans}" >
            <tr>
                <td> ${travelplan.campname} </td>
                <td> ${travelplan.datearrive}</td>
                <td> ${travelplan.datedepart}</td>
                <td> ${travelplan.totalprice}</td>
            </tr>
        </c:forEach>
    </table>
    <form method="get" action = "onetravel">
        <select name = "travelname">
            <c:forEach var="travelname" items="${travelplan}">
                <option name="travelname" value="${travelname.travelplanname}">${travelname.travelplanname}</option>
            </c:forEach>
        </select>
        <button type="submit">Go</button>
    </form>

</body>
</html>
