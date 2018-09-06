<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: olgierd
  Date: 05.09.2018
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="head.jsp" %>

<div align="center">
    <h2>Wiadomości dla eventu: ${eventCode}</h2><br/>

    <table>
        <c:forEach items="${messages}" var="message">
            <tr>
                <td>${message.created}</td>
                <td>${message.body}</td>
                <td>${message.user.username}</td>
                <td><a href="/message/delete_message/${message.event.code}/${message.id}" class="menu-btn">USUN WIADOMOSC</a></td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <section class="jubotron" style="background-color: lightgray;">
        <a href="/message/add_message/${eventCode}" class="agenda-success-btn">DODAJ KOLEJNĄ WIADOMOŚC</a>
        <a href="/index" class="agenda-success-btn">ZATWIERDZ I WRÓC DO MENU GLOWNEGO</a>
    </section>
</div>

</body>
</html>
