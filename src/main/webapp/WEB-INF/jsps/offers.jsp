<%--
  Created by IntelliJ IDEA.
  User: artyom
  Date: 15.5.11
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All offers</title>
    <meta content="text/html" charset="UTF-8">
    <link href="${pageContext.request.contextPath}/stat/css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
<table class="offers">
    <thead>
    <tr>
        <td>
            Name
        </td>
        <td>
            Email
        </td>
        <td>
           Offer
        </td>
    </tr>
    </thead>
    <c:forEach var="offer" items="${offers}">
        <tr>

            <td>
                <c:out value="${offer.name}" />
            </td>
            <td>
                <c:out value="${offer.email}" />
            </td>
            <td>
                <c:out value="${offer.text}" />
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
