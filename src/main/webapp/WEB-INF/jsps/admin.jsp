<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: artyom
  Date: 15.12.11
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users List</title>
    <meta content="text/html" charset="UTF-8">
    <link href="${pageContext.request.contextPath}/stat/css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
<h3>Authorised users only</h3>

<table class="formtable">
    <tr>
        <td>
            Username
        </td>
        <td>
            Email
        </td>
        <td>
            Role
        </td>
        <td>
            Ebable
        </td>
    </tr>

    <c:forEach var="user" items="${users}">

        <tr>
            <td>
                <c:out value="${user.name}"></c:out>
            </td>
            <td>
                <c:out value="${user.userName}"></c:out>
            </td>
            <td>
                <c:out value="${user.email}"></c:out>
            </td>
            <td>
                <c:out value="${user.authority}"></c:out>
            </td>
            <td>
                <c:out value="${user.enabled}"></c:out>
            </td>
        </tr>

    </c:forEach>



</table>


</body>
</html>
