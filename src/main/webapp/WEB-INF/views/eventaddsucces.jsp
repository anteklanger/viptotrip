<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: olgierd
  Date: 04.09.2018
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>eventaddsucces</title>
</head>
<body>

DODANY EVENT<br>

${event.code} <br>
${event.eventName}<br>
${event.eventCategory}<br>

<c:if test="${event.eventCategory == 'L'}"><a href="/event/add_agenda/${event.code}">DODAJ AGENDE</a></c:if><br>
<c:if test="${event.eventCategory == 'F'}"><a href="/event/add_flight/${event.code}">DODAJ PRZELOTY</a></c:if>

<%--<a href="/event/add_leaders/${event.code}">DODAJ OPIEKUNA GRUPY DO EVENTU O KODZIE ${event.code}</a>--%>

</body>
</html>
