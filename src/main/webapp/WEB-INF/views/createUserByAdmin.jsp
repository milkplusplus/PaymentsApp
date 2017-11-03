<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new</title>
    <jsp:include page="includeFile.jsp"></jsp:include>
</head>
<body>
<form:form name="getNewClient" method="POST">
    <div class="container">
        <h1>Create a new client</h1>
        <table class="table table-striped">
            <tr>
                <td>Login</td>
                <td><input type="text" name="login" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password" /></td>
            </tr>
            <tr>
                <td>Role</td>
                <td><input type="text" name="is_admin" /></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Submit" /></td>
            </tr>
        </table>
        <div style="color: red"><c:out value="${error}"/></div>
    </div>
</form:form>
</body>
</html>
