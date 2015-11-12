<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page import="java.util.Map" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Home</title>
</head>
<body>

<div id="flags">
    <a href="?lang=en">
        <img alt="en" title="English">
    </a>

    <a href="?lang=lv_LV">
        <img alt="lv" title="Latvian">
    </a>
</div>

<br/>
<h2>
    homepage.welcome : <spring:message code="homepage.welcome" text="default text" />
</h2>
<h2>
    Current Locale : ${pageContext.response.locale}
</h2>


<p>
    <a href="${pageContext.request.contextPath}/offers">Show offers</a>
</p>
<p>
    <a href="${pageContext.request.contextPath}/createoffer">Add a new offer</a>
</p>
</body>
</html>