<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="head.jsp" %>

<div align="center">

<h2>VIP TO TRIP PANEL ADMINISTRACYJNY</h2>

<c:if test="${user.adminVip}">
    <a href="/admin/add_user" class="agenda-success-btn">PANEL ADMINISTRATORA</a>
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
</c:if>

<c:if test="${user.editorVip}">
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
</c:if>

<c:if test="${user.guestVip}">
    <div align="center">
        <fieldset>
            <table style="border-collapse: separate; border-spacing: 10px;">
                <legend>PODAJ KOD IMPREZY KTÓRĄ CHCESZ ZOBACZYC</legend>
                <form method="post" action="/guest/show_event">

                    <%--<tr>--%>
                        <%--<td align="right" width="200">LOGIN</td>--%>
                        <%--<td><input type="text" name="username" placeholder="login"/></td>--%>
                    <%--</tr>--%>
                    <%--<tr>--%>
                        <%--<td align="right" width="200">PIN</td>--%>
                        <%--<td><input type="text" name="pin" placeholder="pin"/></td>--%>
                    <%--</tr>--%>
                    <tr>
                        <td align="right" width="200">KOD IMPREZY</td>
                        <td><input type="text" name="code" placeholder="6 znakowy kod imprezy"/></td>
                    </tr>
                    <tr>
                        <td colspan="1" align="right" style="background-color: darkgrey">
                            <input type="submit" value="Zatwierdź"/></td>
                    </tr>
                </form>
            </table>
        </fieldset>
    </div>
</c:if>


<%--<c:choose>--%>
<%--<c:when test="${user.adminVip}">--%>
<%----%>
<%--<a href="/event/new_event" class="agenda-success-btn">DODAJ NOWY EVENT</a>--%>
<%--</c:when>--%>
<%--<c:when test="${user.editorVip}">--%>
<%----%>
<%--</c:when>--%>
<%--<c:otherwise>--%>
<%--...--%>
<%--</c:otherwise>--%>
<%--</c:choose>--%>


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