<%--
  Created by IntelliJ IDEA.
  User: artyom
  Date: 15.13.11
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title><tiles:insertAttribute name="title"></tiles:insertAttribute></title>
    <link href="${pageContext.request.contextPath}/stat/css/main.css" rel="stylesheet" type="text/css" />
    <script href="${pageContext.request.contextPath}stat/script/jquery-1.11.3.min.js" type="text/javascript" ></script>
</head>
<body>

<div class="header">
    <tiles:insertAttribute name="header"></tiles:insertAttribute>
</div>

<div class="content">
    <tiles:insertAttribute name="body"></tiles:insertAttribute>
</div>

<div class="footer">
    <tiles:insertAttribute name="footer"></tiles:insertAttribute>
</div>
</body>
</html>
