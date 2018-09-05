<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: olgierd
  Date: 04.09.2018
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="head.jsp" %>


<div align="center">
    <h2>Opiekunowie:</h2><br/>

    <table>
        <c:forEach items="${leaders}" var="lider">
            <tr>
                <td>${lider.name}</td>
                <td>${lider.phone}</td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <section class="jubotron" style="background-color: lightgray;">
        <a href="/event/add_leaders/${eventCode}" class="agenda-success-btn">DODAJ KOLEJNEGO OPIEKUNA</a>
        <a href="/index" class="agenda-success-btn">ZATWIERDZ I WRÓC DO MENU GLOWNEGO</a>
    </section>
</div>
</body>
</html>
