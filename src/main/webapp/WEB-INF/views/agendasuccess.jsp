<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: olgierd
  Date: 04.09.2018
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="head.jsp" %>

<div align="center">

    <fieldset>
        <legend>Panel administracyjny - agenda - dane podstawowe</legend>
        <h2>Agenda:</h2><br/>

        <div align="center">
            <table>
                <c:forEach items="${agenda}" var="agenda">
                    <tr>
                        <td>${agenda.entryPosition}</td>
                        <td>${agenda.startHour}</td>
                        <td>${agenda.endHour}</td>
                        <td>${agenda.entryDescription}</td>
                        <td>${agenda.entryCategory}</td>
                        <td><a href="/event/delete_agenda/${agenda.event.code}/${agenda.id}">USUN</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <br>

        <section class="jubotron" style="background-color: lightgray;">
            <a href="/event/add_agenda/${eventCode}" class="agenda-success-btn">DODAJ KOLEJNĄ POZYCJĘ AGENDY</a>
            <a href="/event/add_guests/${eventCode}" class="agenda-success-btn">DODAJ LISTĘ GOŚCI</a>
        </section>
    </fieldset>
</div>
