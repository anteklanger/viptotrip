<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="head.jsp" %>

<div align="center">

    <table>
        <tr>
            <h2>
                CHCESZ USUNĄC EVENT O KODZIE ${eventCode}
            </h2>
        </tr>
        <tr>
            <a href="/event/delete_event_success/${eventCode}" class="menu-btn">TAK</a>
        </tr>
        <tr>
            <a href="/index" class="menu-btn">ANULUJ I WRÓC DO MENU</a>
        </tr>

    </table>


</div>

</body>
</html>
