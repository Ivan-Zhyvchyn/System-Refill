<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.3.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.12/datatables.min.js"></script>
</head>
<body>

<h1>Журнал пополнений баланса</h1>

<form action="/admin/index" method="get" style="margin-bottom: 10px">
    <input type="submit" value="Управление балансами пользователей"/>
</form>

<table id="example" class="left" width="95%" cellspacing="0">
    <thead>
    <tr>
        <th><b>Пользователь</b>
        </th>
        <th>Администратор<b></b>
        </th>
        <th><b>Дата</b>
        </th>
        <th><b>Сумма</b>
        </th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${replenishments}" var="replenishment">
        <tr style="text-align: center">
            <c:forEach items="${replenishment.users }" var="user">
                <td>${user.username} </td>
            </c:forEach>
            <td>${replenishment.date}</td>
            <td>${replenishment.sum} $</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script>
    $(function () {
        $("#example").dataTable();
    });

</script>
</body>
</html>
