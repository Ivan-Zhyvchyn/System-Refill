<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<head>
    <meta charset="utf-8">
    <link href="<c:url value="../../bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="../../style.css" />" rel="stylesheet">
</head>

<body>

<div>
    <div class="container" style="width: 300px;">
        <form action="/login" method="post">

            <h2 class="form-signin-heading">Добро пожаловать</h2>


            <input type="hidden"
                   name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>

            <div class="input-d">
                <input type="text" name="username" id="username" class="form-control"
                       placeholder="Логин" required="true" autofocus="true"/>
            </div>

            <div class="input-d">
                <input type="password" name="password" id="password" class="form-control"
                       placeholder="Пароль" required="true"/>
            </div>
            <input type="submit" class="btn btn-primary" value="Войти" style="position: absolute; top: 22%; left: 40%;"/>

        </form>

        <form action="/register" method="get">
            <input type="submit" class="btn btn-primary" value="Зарегистрироваться" style="position: absolute; top: 22%; left: 45%;"/>
        </form>

    </div>
</div>
</body>
</html>