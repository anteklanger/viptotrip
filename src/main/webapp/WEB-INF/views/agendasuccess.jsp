<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: olgierd
  Date: 04.09.2018
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

Agenda:<br/>
<ol>
    <c:forEach items="${agenda}" var="agenda">
        <li>${agenda.entryPosition} ${agenda.startHour} ${agenda.endHour} ${agenda.entryDescription}</li>
    </c:forEach>
    <br>
</ol>

<a href="/event/add_agenda/${eventCode}">DODAJ KOLEJNĄ POZYCJĘ AGENDY</a><br>
<a href="/event/add_guests/${eventCode}">DODAJ LISTĘ GOŚCI</a>

</body>
</html>
