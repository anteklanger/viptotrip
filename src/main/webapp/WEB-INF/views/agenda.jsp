<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="post" modelAttribute="agenda">
    Nr pozycji w agendzie<form:input path="entryPosition"/><br>
    Kategoria pozycji <form:input path="entryCategory"/><br/>
    Początek pozycji (godzina): <form:input path="startHour"/><br/>
    Koniec pozycji: <form:input path="endHour"/><br/>
    Opis pozycji: <form:input path="entryDescription"/><br/>
    <input type="submit" value="Zatwierdź"/>
</form:form>

<ol>
    <c:forEach items="${agenda}" var="agenda">
        <li>${agenda.entryPosition} ${agenda.startHour} ${agenda.endHour} ${agenda.entryDescription}</li>
    </c:forEach>
    <br>
</ol>

</body>
</html>
