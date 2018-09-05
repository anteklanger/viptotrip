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

    <link href="/css/custom.css" rel="stylesheet">
    <style>
        tr {
            background-color: gainsboro;
        }

        input {
            background-color: whitesmoke;
            border: none;
        }

        td {
            padding: 6px;
            padding-right: 15px
        }

        div {
            background-color: darkgrey;
            font-family: 'DejaVu Sans', Arial, Helvetica, sans-serif
        }

        textarea {
            background-color: whitesmoke;
            border: none;
        }

        body {
            background-color: darkgrey;
        }
    </style>
</head>
<body>


<div align="center">
    <fieldset>
        <table style="border-collapse: separate; border-spacing: 10px;">

            <legend>Panel administracyjny - opiekunowie grupy - dane podstawowe</legend>
            <form:form method="post" modelAttribute="eventLeader">

                <tr>
                    <td align="right" colspan="1"><h4>Opiekun grupy:</h4></td>
                    <td style="font-size: small" align="center">Imię i nazwisko wymagane,
                        reszta danych opcjonalna</td>
                </tr>
                <tr>
                    <td align="right" width="200">Imię i nazwisko:</td>
                    <td><form:input path="name" size="30"/></td>
                </tr>
                <tr>
                    <td align="right" width="200">Telefon:</td>
                    <td><form:input path="phone"/></td>
                </tr>
                <tr>
                    <td align="right" width="200">Email:</td>
                    <td><form:input path="email"/></td>
                </tr>
                <tr>
                    <td align="right" width="200">Opiekun dla regionu:</td>
                    <td><form:input path="city" placeholder="opcjonalnie, np. lotniskio na którym będzie oczekiwał opiekun grupy" size="50"/></td>
                </tr>
                <tr>
                    <td align="right" width="200">Rola ():</td>
                    <td><form:input path="role" placeholder="opcjonalna np. animator, transport, itp" size="50"/></td>
                </tr>

                <tr>
                    <td colspan="1" align="right" style="background-color: darkgrey">
                        <input type="submit" value="Zatwierdź"/></td>
                </tr>

            </form:form>

        </table>
    </fieldset>
</div>

</body>
</html>
