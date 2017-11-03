<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
  <head><title>Users</title>
    <jsp:include page="includeFile.jsp"></jsp:include>

  </head>
  <body>
  <div class="container">
    <h1>List of the users</h1>
    <a class="btn btn-success pull-right" href="<c:url value="/admin/create"/>" role="button">Create new</a>
<table class="table table-striped">
<thead>
  <tr>
        <td>Index</td>
        <td>ID</td>
        <td>Login</td>
        <td>Role</td>
        <td></td>
        <td></td>
   </tr>
   </thead>
   <tbody>
  <c:forEach var="user" items="${users}" varStatus="status">
    <tr>
      <td><c:out value="${status.index}"/></td>
      <td><c:out value="${user.id}"/></td>
      <td><c:out value="${user.login}"/></td>
      <td><c:out value="${user.is_admin}"/></td>
      <td><a class="btn btn-primary" href="<c:url value="/admin/update/${user.id}"/>" role="button">Update</a></td>
      <td><a class="btn btn-danger" href="<c:url value="/admin/delete/${user.id}"/>" role="button">Delete</a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</div>
  </body>
</html>