<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
    <jsp:include page="includeFile.jsp"></jsp:include>
</head>
<body>
<jsp:include page="navigationAdminBar.jsp"></jsp:include>
<form:form name="updateClient" method="POST">
    <div class="container">
        <h1>Update a client</h1>
        <table class="table table-striped">
            <tr>
                <td>Login</td>
                <td><input type="text" name="login" value="<c:out value="${user.login}"/>" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="text" name="password" value="<c:out value="${user.password}"/>" /></td>
            </tr>
            <tr>
                <td>Role</td>
                <td><input type="text" name="is_admin" value="<c:out value="${user.is_admin}"/>" /></td>
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