<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="post" modelAttribute="flight">
    Przeloty dla klientów z: <form:input path="clientsFromCity"/><br>
    WYLOT: <form:radiobutton path="flightType" value="OUT" checked="true"/>
    POWRÓT: <form:radiobutton path="flightType" value="BACK"/><br><br>
    KOD LOTU: <form:input path="flightCode"/><br/>
    WYLOT Z LOTNISKA (miasto): <form:input path="departureAirport"/><br/>
    DATA WYLOTU: <form:input path="departureDate"/><br/>
    GODZINA WYLOTU: <form:input path="departureTime"/><br/>
    PRZYLOT DO (miasto): <form:input path="arrivalAirport"/><br/>
    DATA PRZYLOTU: <form:input path="arrivalDate"/><br/>
    PRZYLOT O GODZINIE: <form:input path="arrivalTime"/><br/>
    <input type="submit" value="Zatwierdź"/>
</form:form>


<ol>
    <c:forEach items="${allFlights}" var="flight">
        <li>${flight.flightCode} ${flight.clientsFromCity} ${flight.departureTime} ${flight.arrivalTime}</li>
    </c:forEach>
    <br>
</ol>

</body>
</html>
