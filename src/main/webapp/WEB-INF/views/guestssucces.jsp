<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: olgierd
  Date: 04.09.2018
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="head.jsp" %>

<div align="center">

    <h2>Lista gości:</h2><br/>
    <table>
        <c:forEach items="${guests}" var="guest">
            <tr>
                <td>${guest.username}</td>
                <td>${guest.pin}</td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <section class="jubotron" style="background-color: lightgray;">
        <a href="/event/add_leaders/${event.code}" class="agenda-success-btn">DODAJ OPIEKUNA GRUPY DO EVENTU</a>
    </section>
</div>

</body>
</html>
