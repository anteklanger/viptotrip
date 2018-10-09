<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="head.jsp" %>

<div align="center">

    <table class="tab-container">
        <tr>
            <td>
                KOD IMPREZY
            </td>
            <td>
                ${event.code}
            </td>
        </tr>

        <tr>
            <td>
                NAZWA IMPREZY
            </td>
            <td>
                ${event.eventName}
            </td>
        </tr>

        <tr>
            <td>
                DATA IMPREZY
            </td>
            <td>
                ${event.eventDate}
            </td>
        </tr>

        <tr>
            <td>
                HOTEL
            </td>
            <td>
                ${event.hotelName}
            </td>
        </tr>

        <tr>
            <td>
                ADRES IMPREZY
            </td>
            <td>
                ${event.hotelAddress}
            </td>
        </tr>

        <tr>
            <td>
                OPIS HOTELU
            </td>
            <td>
                ${event.hotelDescription}
            </td>
        </tr>

        <table>
            <c:forEach items="${leaders}" var="leader">
                <tr>
                    <td>opiekun: </td>
                    <td>${leader.name}</td>
                    <td>${leader.phone}</td>
                </tr>
            </c:forEach>
        </table>
        <br>

    </table>



</div>

</body>
</html>
