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
        <legend>Panel administracyjny - lista gości - dane podstawowe</legend>
        <br>
        <table style="border-collapse: separate; border-spacing: 10px;">

            <form action="/event/add_guests/${eventCode}" method="post">

                Dodaj listę gości w formacie "Imię Nazwisko,". <br>
                Każdy gość w osobnej linii. Każada linia zkończona "," <br><br>
                <div style="background-color: whitesmoke; width: 500px">
                    przykład: <br>
                    <br>
                    Jan Kowalski, <br>
                    Piotr Nowak, <br>
                    Ewa Górska, <br>
                </div>

                <label><h2>LISTA</h2>
                    <textarea name="list" cols="50" rows="20"></textarea><br><br>
                    <input type="submit" name="message" placeholder="message">

                </label>

            </form>
        </table>
    </fieldset>
</div>
</body>
</html>
