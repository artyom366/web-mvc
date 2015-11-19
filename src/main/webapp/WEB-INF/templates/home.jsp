<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import="java.util.Map" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<p>
    <a href="${pageContext.request.contextPath}/offers">Show offers</a>
</p>
<p>
    <a href="${pageContext.request.contextPath}/createoffer">Add a new offer</a>
</p>

<sec:authorize access="hasRole('ROLE_ADMIN')">
    <p><a href="<c:url value="/admin"/>">Admin</a></p>
</sec:authorize>

