<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="head.jsp" %>

<div align="center">
    <fieldset>
        <table style="border-collapse: separate; border-spacing: 10px;">

            <legend>Panel administracyjny - edycja eventu - dane podstawowe</legend>

            <tr><td align="right" colspan="1"><h4>KOD imprezy: </h4></td><td>${event.code}</td></tr>

            <tr><td align="right" colspan="1"><h4>Rodzaj imprezy: </h4></td><td>${event.eventCategory}</td></tr>

                <%--<tr>--%>
                <%--<td align="right" colspan="1"><h4>Rodzaj imprezy:</h4></td>--%>
                <%--<td style="font-size: small" align="center">Wszystkie pola są wymagane</td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                <%--<td colspan="1" align="right">LOKALNA: <form:radiobutton path="eventCategory" value="L"/></td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                <%--<td colspan="1" align="right">ZAGRANICZNA: <form:radiobutton path="eventCategory" value="F"--%>
                <%--checked="true"/></td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                <%--<td align="right" width="200">Kod imprezy:</td>--%>
                <%--<td><form:input path="code" placeholder="6 znakowy, unikalny"/></td>--%>
                <%--</tr>--%>
                <tr>
                    <td align="right" width="200">Nazwa imprezy:</td>
                    <td>${event.eventName}</td>
                </tr>
                <tr>
                    <td align="right" width="200">Data imprezy:</td>
                    <td>${event.eventDate}</td>
                </tr>
                <tr>
                    <td align="right" width="200">Miejsce imprezy</td>
                    <td>${event.hotelName}</td>
                </tr>
                <tr>
                    <td align="right" width="200">Adres imprezy:</td>
                    <td>${event.hotelAddress}</td>
                </tr>
                <tr>
                    <td align="right" width="200">Opis miejsca imprezy:</td>
                    <td><p aria-rowspan="50" aria-colspan="20">${event.hotelDescription}</p></td>
                </tr>
                <tr>
                    <td colspan="1" align="right">Koordynaty imprezy</td>
                </tr>
                <tr>
                    <td align="right" width="200">Długość geograficzna:</td>
                    <td>${event.hotelLatitude}</td>
                </tr>
                <tr>
                    <td align="right" width="200"> Szerokość geograficzna:</td>
                    <td>${event.hotelLongitude}</td>
                </tr>
        </table>

        <div align="center" style="background-color: whitesmoke">
            <table>
                    <tr style="background-color: bisque">
                        <td>
                            <c:choose>
                                <c:when test="${event.eventCategory.equals('F')}">
                                <a href="/event/new_event" class="menu-btn">EDYTUJ PRZELOT</a></td>
                                </c:when>
                                <c:otherwise>
                                    <a href="/event/new_event" class="menu-btn">EDYTUJ AGENDE</a></td>
                                </c:otherwise>
                            </c:choose>
                        <td>
                            <a href="/event/new_event" class="menu-btn">EDYTUJ OPIEKUNOW</a>
                        </td>
                        <td>
                            <a href="/event/new_event" class="menu-btn">EDYTUJ UCZESTNIKOW</a>
                        </td>
                        <td>
                            <a href="/message/add_message/${event.code}" class="menu-btn">WIADOMOŚC</a>
                        </td>
                    </tr>
                <tr>
                    <td colspan="1" align="right" style="background-color: darkgrey">
                        <a href="/index" class="menu-btn">ANULUJ I WRÓC DO MENU</a>
                </tr>
            </table>
        </div>

    </fieldset>
</div>

</body>
</html>


