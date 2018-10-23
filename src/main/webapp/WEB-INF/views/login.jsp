<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<%--<head>--%>
    <%--<title>Logowanie</title>--%>
    <%--<style>--%>
        <%--div {--%>
            <%--margin: 5px;--%>
        <%--}--%>
    <%--</style>--%>
<%--</head>--%>
<%--<body>--%>
    <%--<div>--%>
        <%--<form method="post" action="/WEB-INF/views/login.jsp">--%>
            <%--<fieldset>--%>
                <%--<legend>Podaj dane logowania</legend>--%>
                <%--<div>--%>
                    <%--<input type="text" name="username" placeholder="Podaj login"/>--%>
                <%--</div>--%>
                <%--<div>--%>
                    <%--<input type="password" name="password" placeholder="Podaj hasło"/>--%>
                <%--</div>--%>
            <%--</fieldset>--%>
            <%--<fieldset>--%>
                <%--<input type="submit" value="Zaloguj"/>--%>
            <%--</fieldset>--%>
            <%--<c:if test="${param.error != null}">--%>
                <%--<fieldset>--%>
                    <%--<label style="color: red">Błędne dane logowania</label>--%>
                <%--</fieldset>--%>
            <%--</c:if>--%>
        <%--</form>--%>
    <%--</div>--%>
<%--</body>--%>
<%--</html>--%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value=""/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <%--<meta http-equiv="X-UA-Compatible" content="IE=edge">--%>
    <%--<meta name="viewport" content="width=device-width, initial-scale=1">--%>
    <%--<meta name="description" content="">--%>
    <%--<meta name="author" content="">--%>

    <title>Log in with your credentials</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<body>

<div class="container">

    <form method="POST" action="/login" class="form-signin">
        <h2 class="form-heading">Log in</h2>

        <div class="form-group ">
            <span></span>
            <input name="username" type="text" class="form-control" placeholder="Username"
                   autofocus="true"/>
            <input name="password" type="password" class="form-control" placeholder="Password"/>
            <span></span>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
        </div>

    </form>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script></body>
</html>