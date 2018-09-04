<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: olgierd
  Date: 04.09.2018
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

Users:<br/>
<ol>
    <c:forEach items="${leaders}" var="lider">
        <li>${lider.name}</li>
    </c:forEach>

    <br>

    <a href="/event/add_leaders/${eventCode}">DODAJ KOLEJNEGO OPIEKUNA</a>

    <a href="/event/add_flight/${eventCode}">DODAJ INFORMACJE O PRZELOTACH</a>

</ol>

</body>
</html>
