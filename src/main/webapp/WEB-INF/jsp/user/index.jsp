<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <link href="<c:url value="../../../bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="../../../style.css" />" rel="stylesheet">
</head>

<body>
<div style="margin-left: 20px">
    <h1>Добро пожаловать ${userName}</h1>


    <h2>Ваш текущий баланс <span class="badge badge-default">${userBalance}</span></h2>


    <form action="/logout" method="get">
        <input type="submit" class="btn btn-primary" value="Выход"/>
    </form>
</div>
</body>
</html>