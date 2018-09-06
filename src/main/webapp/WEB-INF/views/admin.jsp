<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: olgierd
  Date: 05.09.2018
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="head.jsp" %>

<div align="center">
    <fieldset>
        <table style="border-collapse: separate; border-spacing: 10px;">

            <legend>Panel administracyjny - użytkownicy</legend>
            <form:form method="post" modelAttribute="user">

                <tr>
                    <td align="right" colspan="1"><h4>Użytkownik:</h4></td>
                    <td style="font-size: small" align="center">Wszystkie pola wymagane</td>
                </tr>
                <tr>
                    <td align="right" width="200">Login:</td>
                    <td><form:input path="username" size="30"/></td>
                </tr>
                <tr>
                    <td align="right" width="200">Haslo:</td>
                    <td><form:input path="password"/></td>
                </tr>
                <tr>
                    <td colspan="1" align="right">GOŚC: <form:checkbox path="guestVip"/></td>
                </tr>
                <tr>
                    <td colspan="1" align="right">EDYTOR: <form:checkbox path="editorVip"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="1" align="right">ADMINISTRATOR: <form:checkbox path="adminVip"/>
                    </td>
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
