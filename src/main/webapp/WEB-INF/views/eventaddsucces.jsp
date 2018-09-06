<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: olgierd
  Date: 04.09.2018
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="head.jsp" %>
<div align="center">

    <fieldset>
        <legend>Panel administracyjny - event - dane podstawowe</legend>
        <h2>DODANY EVENT</h2><br>
        <table>
            <tr>
                <td>${event.code}</td>
                <td>${event.eventName}</td>
                <td>${event.eventDate}</td>
                <td>${event.hotelName}</td>
                <td>${event.hotelAddress}</td>
            </tr>
        </table>
        <section class="jubotron" style="background-color: lightgray;">
            <c:if test="${event.eventCategory == 'L'}">
                <a href="/event/add_agenda/${event.code}" class="agenda-success-btn">DODAJ AGENDĘ EVENTU</a>
            </c:if>
            <c:if test="${event.eventCategory == 'F'}">
                <a href="/event/add_flight/${event.code}" class="agenda-success-btn">DODAJ PRZELOT</a>
            </c:if>
        </section>
    </fieldset>
</div>
<%--<section class="jubotron" style="background-color: lightgray;">--%>
<%--<a href="/event/add_agenda/${eventCode}" class="agenda-success-btn">DODAJ KOLEJNĄ POZYCJĘ AGENDY</a>--%>
<%--<a href="/event/add_guests/${eventCode}" class="agenda-success-btn">DODAJ LISTĘ GOŚCI</a>--%>
<%--</section>--%>

</body>
</html>
