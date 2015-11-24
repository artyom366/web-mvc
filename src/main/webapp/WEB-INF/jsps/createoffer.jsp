<%--
  Created by IntelliJ IDEA.
  User: artyom
  Date: 15.5.11
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Create Offer</title>
    <meta content="text/html" charset="UTF-8">
    <link href="${pageContext.request.contextPath}/stat/css/main.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="<c:url value="/stat/script/jquery-1.11.3.min.js"></c:url> "></script>
</head>
<body>

<script>
    function onDeleteClick(event) {
        event.preventDefault();

        var doDelete = confirm("Are you sure?");
        if (doDelete == false) {
            event.preventDefault(); //prevent form from submitting to controller with delete param
        }
    }

    function onReady() {
        $("#delete").click(onDeleteClick);
    }


    $(document).ready(onReady);

</script>

<sf:form method="post" action="${pageContext.request.contextPath}/docreate" commandName="offer">

    <sf:input name="id" path="id" type="hidden"></sf:input>

    <table class="formtable">
        <tr><td class="label">Offer:</td><td><sf:textarea path="text" class="control" name="text" rows="10" cols="10"></sf:textarea>
            <br/>
            <sf:errors path="text" cssClass="error"></sf:errors>
        </td></tr>
        <tr><td class="label"></td><td><input class="control" value="Save Advert" type="submit" /></td></tr>

        <c:if test="${offer.id  != 0}">
            </td></tr>
            <tr><td class="label"></td><td><input id="delete" class="control delete" name="delete" value="Delete Offer" type="submit" /></td></tr>
        </c:if>
    </table>
</sf:form>

</body>
</html>
