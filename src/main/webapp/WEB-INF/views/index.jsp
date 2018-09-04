<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>VIP TO TRIP PANEL ADMINISTRACYJNY</h2>


<a href="/event/new_event">DODAJ NOWY EVENT</a>

<ol>
    <c:forEach items="${events}" var="event">
        <li>${event.code} ${event.eventName} </li>
    </c:forEach>

</ol>

</body>
</html>
