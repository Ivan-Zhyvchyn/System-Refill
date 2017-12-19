<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.3.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.12/datatables.min.js"></script>
    <style>
        #popolnenie {
            background: rgba(102, 102, 102, 0.5);
            width: 100%;
            height: 100%;
            position: absolute;
            top: 0;
            left: 0;
            display: none;
        }

        #okno {
            width: 300px;
            height: 120px;
            text-align: center;
            padding: 15px;
            border: 3px solid #080808;
            border-radius: 10px;
            color: #080808;
            position: absolute;
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
            margin: auto;
            background: #fff;
        }

        #popolnenie:target {
            display: block;
        }

        .close {
            display: inline-block;
            border: 1px solid #080808;
            color: #080808;
            padding: 0 12px;
            margin: 10px;
            text-decoration: none;
            background: #f2f2f2;
            font-size: 14pt;
            cursor: pointer;
        }

        .send {
            display: inline-block;
            border: 1px solid #080808;
            color: #080808;
            padding: 0 12px;
            margin: 10px;
            text-decoration: none;
            background: #f2f2f2;
            font-size: 14pt;
            cursor: pointer;
        }

        .close:hover {
            background: #e6e6ff;
        }
    </style>
</head>

<body>


<h1>Управление балансами пользователей </h1>

<form action="/admin/journal" method="get" style="margin-bottom: 10px">
    <input type="submit" value="Журнал пополнений"/>
</form>


<table id="example" class="left" width="95%" cellspacing="0">
    <thead>
    <tr>
        <th><b>Email</b>
        </th>
        <th><b>Баланс</b>
        </th>
        <th><b>Дата регистрации</b>
        </th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${users}" var="user">
        <tr style="text-align: center">
            <td><a id="name" href="#popolnenie" onclick="a('${user.username}')">${user.username}</a></td>
            <td>${user.balance} $</td>
            <td>${user.registration}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script>
    $(function () {
        $("#example").dataTable();
    });

    function a(name) {
        document.getElementById("myText").value = name;
    }

</script>


<div id="popolnenie">
    <div id="okno">
        <h3> Пополнение баланса</h3>

        <form action="/admin/updateBalance" method="post">
            <input type="hidden" name="user" id="myText"/>

            <input type="hidden"
                   name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>

            Сумма <input type="text" name="balance" id="balance" class="form-control input-lg"
                         placeholder="Balance" required="true" autofocus="true"/> <br>

            <input type="submit" value="Пополнить"/>

        </form>
        <a href="#"> Закрыть окно</a>

    </div>
</div>

<form action="/logout" method="get">
    <input type="submit" class="btn btn-lg btn-primary btn-block" value="Выход"/>
</form>

</body>
</html>