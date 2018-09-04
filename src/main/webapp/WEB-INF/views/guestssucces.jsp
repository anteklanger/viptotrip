<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: olgierd
  Date: 04.09.2018
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

Lista przelotów:<br/>
<ol>
    <c:forEach items="${guests}" var="guest">
        <li>${guest.username} ${guest.pin}</li>
    </c:forEach>

    <br>

    <a href="/event/add_leaders/${event.code}">DODAJ OPIEKUNA GRUPY DO EVENTU O KODZIE ${event.code}</a>


</ol>

</body>
</html>
