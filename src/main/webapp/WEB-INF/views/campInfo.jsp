<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Information</title>
</head>

<body>
<h1>Information</h1>
<h3>Name</h3>
${campinfo.campname}
<h3>Rating</h3>
${rate}
<form action="giveRating" method="POST">
    <select name="rating">
        <option value="0">0</option>
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4" >4</option>
        <option value="5" >5</option>
        <option value="6" >6</option>
        <option value="7" >7</option>
        <option value="8" >8</option>
        <option value="9" >9</option>
        <option value="10" >10</option>
    </select>
    <button name="campName2" value ="${camp.campname}" s>OK</button>

</form>
<%--
<h3>Price per night</h3>
${camp.price} kr
<h3>Service</h3>
${camp.service}
<h3>Opening hours</h3>
${camp.openinghours}
<h3>Shops nearby</h3>
${camp.shops}
<h3>Entertainment nearby</h3>
${camp.entertainment}
<h3>Area</h3>
${camp.camparea}
--%>
<h2>Description</h2>
${campinfo.description}
<h3 id="adress">Adress</h3>
${campinfo.campaddress}
${campinfo.campzip}
<h3 id="contactinfo">Contact info</h3>
${campinfo.campemail}
${campinfo.campphone}
${campinfo.campwebsite}

<h2>Reviews</h2>
<form action="review" method="POST" >
<table border="1">
    <thead>
    <tr>
        <th>Review</th>
        <th>Author</th>
    </tr>
    </thead>
    <c:forEach items="${reviews}" var="r" >
        <tr>
            <td>  ${r.review} </td>
            <td> ${r.username} </td>
        </tr>
    </c:forEach>
</table>


<button name = "campName" value="${camp.campname}" type="submit">Give a review</button>


</form>


</body>
</html>
