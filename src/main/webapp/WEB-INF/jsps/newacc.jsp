<%--
  Created by IntelliJ IDEA.
  User: artyom
  Date: 15.5.11
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
  <title>Create Account</title>
  <meta content="text/html" charset="UTF-8">
  <link href="${pageContext.request.contextPath}/stat/css/main.css" rel="stylesheet" type="text/css">
</head>
<body>

<sf:form method="post" action="${pageContext.request.contextPath}/createaccount" commandName="user">
  <table class="formtable">
    <tr><td class="label">User Name:</td><td><sf:input path="userName" class="control" name="userName" type="text" />
      <br/>
      <sf:errors path="userName" cssClass="error"></sf:errors>
    </td></tr>

    <tr><td class="label">Email:</td><td><sf:input path="email" class="control" name="email" type="text" />
      <br/>
      <sf:errors path="email" cssClass="error"></sf:errors>
    </td></tr>

    <tr><td class="label">Password:</td><td><sf:textarea path="password" class="control" name="password" rows="10" cols="10"></sf:textarea>
      <br/>
      <sf:errors path="password" cssClass="error"></sf:errors>
    </td></tr>

    <tr><td class="label">Confirm Password:</td><td><textarea class="control" name="confirm_password" rows="10" cols="10"></textarea>
      <br/>
    </td></tr>

    <tr><td class="label"></td><td><input class="control" value="Create" type="submit" /></td></tr>
  </table>
</sf:form>

</body>
</html>
