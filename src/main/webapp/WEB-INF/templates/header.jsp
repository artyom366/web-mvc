<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<hr>

<h2>
    homepage.welcome : <spring:message code="homepage.welcome"/>
</h2>

<br/>
    <a href="?lang=en">
        <img alt="en" title="English">
    </a>

    <a href="?lang=lv_LV">
        <img alt="lv" title="Latvian">
    </a>


<a class="title" href="<c:url value="/"/>">Offers</a>

<div class="login">
<sec:authorize access="!isAuthenticated()">
    <%--<a class="login" href="<c:url value="/login"/>">Log in</a>--%>

    <c:url var="loginUrl" value="/login"/>
    <form action="${loginUrl}" method="post">
        <input type="submit" value="Log in" />
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</sec:authorize>
</div>

<div class="login">
<sec:authorize access="isAuthenticated()">
    <!--when logging of with spring security using /logout value-->
    <!--the method should be POST when tokens enabled-->
    <c:url var="logoutUrl" value="/logout"/>
    <form action="${logoutUrl}" method="post">
        <input class="login" type="submit" value="Log out" />
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</sec:authorize>
</div>