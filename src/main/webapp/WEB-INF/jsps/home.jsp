<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import="java.util.Map" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
    homepage.welcome : <spring:message code="homepage.welcome"/>
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

<sec:authorize access="!isAuthenticated()">
    <p><a href="<c:url value="/login"/>">Log in</a></p>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
    <c:url var="logoutUrl" value="/logout"/>
    <form action="${logoutUrl}" method="post">
        <input type="submit" value="Log out" />
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</sec:authorize>

<sec:authorize access="hasRole('ROLE_ADMIN')">
    <p><a href="<c:url value="/admin"/>">Admin</a></p>
</sec:authorize>


</body>
</html>