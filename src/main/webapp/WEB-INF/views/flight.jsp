<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Przeloty</title>
    <link href="/css/custom.css" rel="stylesheet">
    <style>
        tr {
            background-color: gainsboro;
        }

        input {
            background-color: whitesmoke;
            border: none;
        }

        td {
            padding: 6px;
            padding-right: 15px
        }

        div {
            background-color: darkgrey;
            font-family: 'DejaVu Sans', Arial, Helvetica, sans-serif
        }

        textarea {
            background-color: whitesmoke;
            border: none;
        }

        body {
            background-color: darkgrey;
        }
    </style>
</head>
<body>

<%--<form:form method="post" modelAttribute="flight">--%>

<%--KOD LOTU: <br/>--%>
<%--WYLOT Z LOTNISKA (miasto): <br/>--%>
<%--DATA WYLOTU: <br/>--%>
<%--GODZINA WYLOTU: <br/>--%>
<%--PRZYLOT DO (miasto): <br/>--%>
<%--DATA PRZYLOTU: <br/>--%>
<%--PRZYLOT O GODZINIE: <br/>--%>
<%--<input type="submit" value="Zatwierdź"/>--%>
<%--</form:form>--%>


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
                    <td colspan="1" align="right">POWRÓT: POWRÓT: <form:radiobutton path="flightType"
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
</div>


<ol>
    <c:forEach items="${allFlights}" var="flight">
        <li>${flight.flightCode} ${flight.clientsFromCity} ${flight.departureTime} ${flight.arrivalTime}</li>
    </c:forEach>
    <br>
</ol>

</body>
</html>
