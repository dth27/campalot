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
    <title>All CampSites</title>
</head>
<body>
    <h1>All Campsites </h1>
    <table border="1">
        <thead>
        <tr>
            <th>Name</th>
        </tr>
        </thead>
        <c:forEach items="${camps}" var="camp">
            <tr>
                <td> ${camp.campName} </td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
