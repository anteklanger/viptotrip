<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EVENT</title>

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

        li {
            background-color: lavender;
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

    <h2>VIP TO TRIP PANEL ADMINISTRACYJNY</h2>


    <a href="/event/new_event">
        <button style="width: 300px; height: 40px; background-color: dimgray; font-size: larger">DODAJ NOWY EVENT
        </button>
    </a>
</div>
<br>

<div align="center" style="background-color: whitesmoke">
    <table>
        <c:forEach items="${events}" var="event">
            <tr style="background-color: bisque">
                <td>${event.code}</td>
                <td> ${event.eventName} </td>
                <td>
                    <a href="/event/new_event">
                        <button style="width: 100px; height: 20px; background-color: dimgray; font-size: small">EDYTUJ
                        </button>
                    </a></td>
                <td>
                    <a href="/event/new_event">
                        <button style="width: 100px; height: 20px; background-color: dimgray; font-size: small">USUN
                        </button>
                    </a></td>
                <td>
                    <a href="/event/new_event">
                        <button style="width: 100px; height: 20px; background-color: dimgray; font-size: small">WIADOMOŚC
                        </button>
                    </a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>


<%--</div>--%>
<%--<div style="width: 300px">--%>
<%--<ol>--%>
<%--<c:forEach items="${events}" var="event">--%>
<%--<li>${event.code} ${event.eventName}--%>
<%--<a href="/event/new_event">--%>
<%--<button style="width: 100px; height: 20px; background-color: dimgray; font-size: small">EDYTUJ--%>
<%--</button>--%>
<%--</a></li>--%>
<%--</c:forEach>--%>

<%--</ol>--%>
<%--</div>--%>