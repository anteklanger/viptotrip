<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: olgierd
  Date: 04.09.2018
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>OPIEKUN GRUPY</title>
</head>
<body>

<form:form method="post" modelAttribute="eventLeader">
    Opiekun Grupy:<br>
    Imię i nazwisko: <form:input path="name"/><br/>
    Telefon: <form:input path="phone"/><br/>
    email: <form:input path="email"/><br/>
    Miasto (Lotnisko, na którym będzie oczekiwał opiekun grupy): <form:input path="city"/><br/>
    Rola (opcjonalna np. animator, transport, itp): <form:input path="role"/><br/>
    <input type="submit" value="Zatwierdź"/>
</form:form>

</body>
</html>
