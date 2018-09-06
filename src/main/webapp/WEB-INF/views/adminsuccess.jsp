<%--
  Created by IntelliJ IDEA.
  User: olgierd
  Date: 05.09.2018
  Time: 23:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="head.jsp" %>

<div align="center">
    <h2>Administratorzy:</h2><br/>

    <table>
        <c:forEach items="${admins}" var="admin">
            <tr>
                <td>${admin.id}</td>
                <td>${admin.username}</td>
            </tr>
        </c:forEach>
    </table>
    <br>

    <h2>Edytorzy:</h2><br/>

    <table>
        <c:forEach items="${editors}" var="editor">
            <tr>
                <td>${editor.id}</td>
                <td>${editor.username}</td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <section class="jubotron" style="background-color: lightgray;">
        <a href="/admin/add_user" class="agenda-success-btn">DODAJ KOLEJNEGO UŻYTKOWNIKA</a>
        <a href="/index" class="agenda-success-btn">ZATWIERDZ I WRÓC DO MENU GLOWNEGO</a>
    </section>
</div>

</body>
</html>
