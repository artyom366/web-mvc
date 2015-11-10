<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: artyom
  Date: 15.10.11
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Login Page</title>
    <meta content="text/html" charset="UTF-8">
    <link href="${pageContext.request.contextPath}/stat/css/main.css" rel="stylesheet" type="text/css">
</head>
<body onload='document.f.username.focus();'>
<h3>Login with Username and Password</h3>

<c:if test="${param.error != null}">
    <span class="loginerror">Login failed. User name ar password are incorrect.</span>
</c:if>

<form name='f' action='${pageContext.request.contextPath}/login' method='POST'>
    <table class="formtable">
        <tr>
            <td>User:</td>
            <td><input type='text' name='username' value=''></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='password'/></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="Login"/></td>
        </tr>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> <!--replaced from original-->
    </table>
</form>

<p><a href="<c:url value="/newacc"/>">Create new account</a></p>

</body>
</html>