<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link href="<c:url value="../../bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="../../style.css" />" rel="stylesheet">

</head>

<body>
    <div class="container" style="width: 300px;">
        <form action="/reg" method="post">
            <input type="hidden"
                   name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>
            <h2 class="form-signin-heading">Регистрация</h2>
            <div class="input-d">
                <input type="text" class="form-control" name="username" placeholder="Логин" required autofocus>
            </div>
            <div class="input-d">
                <input type="password" class="form-control" name="password" placeholder="Пароль" required>
            </div>

            <p><button class="btn btn-lg btn-primary btn-block" type="submit">Зарегистрировать</button></p>
        </form>
    </div>

</body>
</html>