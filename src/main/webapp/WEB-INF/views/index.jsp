<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="head.jsp" %>

<div align="center">

    <h2>VIP TO TRIP PANEL ADMINISTRACYJNY</h2>


    <a href="/event/new_event" class="agenda-success-btn">DODAJ NOWY EVENT</a>
    <br>
</div>
<br>

<div align="center" style="background-color: whitesmoke">
    <table>
        <c:forEach items="${events}" var="event">
            <tr style="background-color: bisque">
                <td>${event.code}</td>
                <td> ${event.eventName} </td>
                <td>
                    <a href="/event/new_event" class="menu-btn">EDYTUJ</a></td>
                <td>
                    <a href="/event/new_event" class="menu-btn">USUN</a>
                </td>
                <td>
                    <a href="/message/add_message/${event.code}" class="menu-btn">WIADOMOŚC</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>


<%--</div>--%>
<%--<div style="width: 300px">--%>
<%--<ol>--%>
<%--<c:forEach items="${events}" var="event">--%>
<%--<li>${event.code} ${event.eventName}--%>
<%--<a href="/event/new_event">--%>
<%--<button style="width: 100px; height: 20px; background-color: dimgray; font-size: small">EDYTUJ--%>
<%--</button>--%>
<%--</a></li>--%>
<%--</c:forEach>--%>

<%--</ol>--%>
<%--</div>--%>