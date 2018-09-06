<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="head.jsp" %>

<div align="center">
    <fieldset>
        <table style="border-collapse: separate; border-spacing: 10px;">

            <legend>Panel administracyjny - przeloty - dane podstawowe</legend>
            <form:form method="post" modelAttribute="flight">

                <tr>
                    <td align="right" colspan="1" style="font-size: small">Wszystkie pola są wymagane</td>
                    <td style="font-size: small; background-color: darkgrey" align="center"></td>
                </tr>
                <tr>
                    <td colspan="1" align="right">WYLOT: <form:radiobutton path="flightType" value="OUT"
                                                                           checked="true"/></td>
                </tr>
                <tr>
                    <td colspan="1" align="right">POWRÓT: <form:radiobutton path="flightType"
                                                                                    value="BACK"/></td>
                </tr>

                <tr>
                    <td align="right" width="200">Przeloty dla klientów z:</td>
                    <td><form:input path="clientsFromCity"/></td>
                </tr>
                <tr>
                    <td align="right" width="200">KOD LOTU:</td>
                    <td><form:input path="flightCode"/></td>
                </tr>
                <tr>
                    <td align="right" width="200">WYLOT Z LOTNISKA:</td>
                    <td><form:input path="departureAirport" placeholder="miasto"/></td>
                </tr>
                <tr>
                    <td align="right" width="200">DATA WYLOTU:</td>
                    <td><form:input path="departureDate"/></td>
                </tr>
                <tr>
                    <td align="right" width="200">GODZINA WYLOTU:</td>
                    <td><form:input path="departureTime"/></td>
                </tr>
                <tr>
                    <td align="right" width="200">PRZYLOT DO:</td>
                    <td><form:input path="arrivalAirport"/></td>
                </tr>
                <tr>
                    <td align="right" width="200">DATA PRZYLOTU:</td>
                    <td><form:input path="arrivalDate"/></td>
                </tr>
                <tr>
                    <td align="right" width="200">PRZYLOT O GODZINIE:</td>
                    <td><form:input path="arrivalTime"/></td>
                </tr>
                <tr>
                    <td colspan="1" align="right" style="background-color: darkgrey">
                        <input type="submit" value="Zatwierdź"/></td>
                </tr>

            </form:form>
        </table>
    </fieldset>
    <table style="background-color: bisque">
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
</div>




</body>
</html>
