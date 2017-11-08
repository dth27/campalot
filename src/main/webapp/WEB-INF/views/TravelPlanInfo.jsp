<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TravelPlan info</title>
</head>
<body>
<h1>Your travelplan</h1>
<form method="get" action="/onetravel">
    <table border="1">
       <thead>
       <tr>
           <th>User</th>
            <th>Travelplan</th>

       </tr>
       </thead>
        <c:forEach var="travelitems" items="${travelplanitems}">
        <tr>
            <td><button>${travelitems.username}</button></td>
            <td><button name="travelname" value="${travelitems.travelplanname}">${travelitems.travelplanname}</button></td>
        </tr>
    </c:forEach>
</table>
</form>
</body>
</html>
