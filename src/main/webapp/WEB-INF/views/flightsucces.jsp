<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: olgierd
  Date: 04.09.2018
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

Lista przelotów:<br/>
<ol>
    <c:forEach items="${flights}" var="flight">
        <li>${flight.flightCode}</li>
    </c:forEach>

    <br>

    <a href="/event/add_flight/${eventCode}">DODAJ KOLEJNY LOT</a><br>
    <a href="/event/add_guests/${eventCode}">DODAJ LISTĘ GOŚCI</a>


</ol>

</body>
</html>
