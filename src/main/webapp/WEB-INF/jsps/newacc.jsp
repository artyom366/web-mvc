<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="US-ASCII"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <link href="${pageContext.request.contextPath}/stat/css/main.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="<c:url value="/stat/script/jquery-1.11.3.min.js"></c:url> "></script>

    <script type="text/javascript">
        function onLoad() {

            $("#password").keyup(checkPasswordsMatch);
            $("#confirmpass").keyup(checkPasswordsMatch);

            $("#details").submit(canSubmit);
        }

        function canSubmit() {
            var password = $("#password").val();
            var confirmpass = $("#confirmpass").val();

            if(password != confirmpass) {
                alert("<spring:message key='PasswordsNotMatch.user.password' />")
                return false;
            }
            else {
                return true;
            }
        }

        function checkPasswordsMatch() {
            var password = $("#password").val();
            var confirmpass = $("#confirmpass").val();

            if (password.length > 3 || confirmpass.length > 3) {

                if (password == confirmpass) {
                    $("#matchpass").text("<spring:message key='PasswordsMatch.user.password' />");
                    $("#matchpass").addClass("valid");
                    $("#matchpass").removeClass("error");
                } else {
                    $("#matchpass").text("<spring:message key='PasswordsNotMatch.user.password' />");
                    $("#matchpass").addClass("error");
                    $("#matchpass").removeClass("valid");
                }
            }
        }

        $(document).ready(onLoad);
    </script>




    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>Create New Account</title>
</head>
<body>

<h2>Create New Account</h2>

<sf:form id="details" method="post" action="${pageContext.request.contextPath}/createaccount" commandName="user">

    <table class="formtable">
        <tr><td class="label">Username: </td><td><sf:input class="control" path="userName" name="userName" type="text" /><br/><div class="error"><sf:errors path="userName"></sf:errors></div></td></tr>
        <tr><td class="label">Name: </td><td><sf:input class="control" path="name" name="name" type="text" /><br/><div class="error"><sf:errors path="name"></sf:errors></div></td></tr>
        <tr><td class="label">Email: </td><td><sf:input class="control"  path="email" name="email" type="text" /><div class="error"><sf:errors path="email"></sf:errors></div></td></tr>
        <tr><td class="label">Password: </td><td><sf:input id="password" class="control"  path="password" name="password" type="password" /><div class="error"><sf:errors path="password"></sf:errors></div></td></tr>
        <tr><td class="label">Confirm Password: </td><td><input id="confirmpass" class="control"  name="confirmpass" type="password" />
            <div id="matchpass"></div>
        </td></tr>
        <tr><td class="label"> </td><td><input class="control"  value="Create account" type="submit" /></td></tr>
    </table>

</sf:form>

</body>
</html>