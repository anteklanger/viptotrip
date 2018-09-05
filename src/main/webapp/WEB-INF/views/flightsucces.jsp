<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: olgierd
  Date: 04.09.2018
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="head.jsp" %>

<div align="center">
   <h2>Lista przelotów:</h2><br/>
    <table>
        <c:forEach items="${flights}" var="flight">
            <tr>
                <td>${flight.flightType}</td>
                <td>${flight.flightCode}</td>
                <td>${flight.departureAirport}</td>
                <td>${flight.departureDate}</td>
                <td>${flight.departureTime}</td>
                <td>${flight.arrivalAirport}</td>
                <td>${flight.arrivalDate}</td>
                <td>${flight.arrivalTime}</td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <section class="jubotron" style="background-color: lightgray;">
        <a href="/event/add_flight/${eventCode}" class="agenda-success-btn">DODAJ KOLEJNY LOT</a>
        <a href="/event/add_guests/${eventCode}" class="agenda-success-btn">DODAJ LISTĘ GOŚCI</a>
    </section>
</div>

</body>
</html>
