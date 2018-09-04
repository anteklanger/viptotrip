<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: olgierd
  Date: 04.09.2018
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

DOADAJ LISTĘ ZAPROSZONYCH GOŚCI

w formacie "Imię Nazwisko," <br>
każdy gość w osobnej linii. Każada linia zkończona "," <br>

przykład: <br>
<br>

Jan Kowalski, <br>
Piotr Nowak, <br>
Ewa Górska, <br>

<form action="/event/add_guests/${eventCode}" method="post">
    <label><h2>LISTA</h2>
        <textarea name="list" cols="50" rows="20"></textarea><br>
        <input type="submit" name="message" placeholder="message">

    </label>
</form>
</body>
</html>
