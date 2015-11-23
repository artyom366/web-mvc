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
    <title>Create Offer</title>
    <meta content="text/html" charset="UTF-8">
    <link href="${pageContext.request.contextPath}/stat/css/main.css" rel="stylesheet" type="text/css">
</head>
<body>

<sf:form method="post" action="${pageContext.request.contextPath}/docreate" commandName="offer">
    <table class="formtable">
        <tr><td class="label">Offer:</td><td><sf:textarea path="text" class="control" name="text" rows="10" cols="10"></sf:textarea>
            <br/>
            <sf:errors path="text" cssClass="error"></sf:errors>
        </td></tr>
        <tr><td class="label"></td><td><input class="control" value="Create" type="submit" /></td></tr>
    </table>
</sf:form>

</body>
</html>
