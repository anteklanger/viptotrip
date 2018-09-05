<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="head.jsp" %>

<div align="center">
    <fieldset>
        <table style="border-collapse: separate; border-spacing: 10px;">

            <legend>Panel administracyjny - agenda - dane podstawowe</legend>
            <form:form method="post" modelAttribute="agenda">

                <tr>
                    <td align="right" colspan="1" style="font-size: small">Wszystkie pola są wymagane</td>
                    <td style="font-size: small; background-color: darkgrey" align="center"></td>

                <tr>
                    <td align="right" width="200">Nr pozycji w agendzie:</td>
                    <td><form:input path="entryPosition"/></td>
                </tr>
                <tr>
                    <td align="right" width="200">Kategoria pozycji:</td>
                    <td><form:input path="entryCategory"/></td>
                </tr>
                <tr>
                    <td align="right" width="200">Początek pozycji:</td>
                    <td><form:input path="startHour" placeholder="godzina"/></td>
                </tr>
                <tr>
                    <td align="right" width="200">Koniec pozycji:</td>
                    <td><form:input path="endHour" placeholder="godzina"/></td>
                </tr>
                <tr>
                    <td align="right" width="200">Opis pozycji:</td>
                    <td><form:input path="entryDescription" size="50"/></td>
                </tr>

                </tr>
                <tr>
                    <td colspan="1" align="right" style="background-color: darkgrey">
                        <input type="submit" value="Zatwierdź"/></td>
                </tr>
            </form:form>
        </table>
    </fieldset>
</div>


<ol>
    <c:forEach items="${allAgendaEntries}" var="agenda">
        <li>${agenda.entryPosition} ${agenda.startHour} ${agenda.endHour} ${agenda.entryDescription}</li>
    </c:forEach>
    <br>
</ol>


</body>
</html>


