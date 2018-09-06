<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: olgierd
  Date: 05.09.2018
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="head.jsp" %>

<div align="center">
    <fieldset>
        <table style="border-collapse: separate; border-spacing: 10px;">

            <legend>Panel administracyjny - opiekunowie grupy - dane podstawowe</legend>
            <form:form method="post" modelAttribute="message">
                <tr>
                    <td align="right" colspan="1"><h4>Dodajesz wiadomość do eventu</h4></td>
                    <td style="font-size: small" align="center">${message.event.code}</td>
                </tr>
                <tr>
                    <td align="right" width="200">Treść wiadomości</td>
                    <td><form:textarea path="body" rows="5" cols="50"/></td>
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
