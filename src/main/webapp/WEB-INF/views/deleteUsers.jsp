<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
  <head><title>Delete</title>
    <jsp:include page="includeFile.jsp"></jsp:include>
  </head>
  <body>
  <jsp:include page="navigationAdminBar.jsp"></jsp:include>
  <div class="container">
    <h1>List of the users</h1>
<form:form method="post" action="/PaymentsApp/admin/delete" modelAttribute="ListUserForm">
<table class="table table-striped">
<thead>
  <tr>
        <td></td>
        <td>Index</td>
        <td>ID</td>
        <td>Login</td>
        <td>Role</td>
   </tr>
   </thead>
   <tbody>
  <c:forEach var="user_row" items="${ListUserForm.list}" varStatus="status">
    <tr>
      <td><spring:bind path = "ListUserForm.list[${status.index}].checkControl">
      <form:checkbox path="list" value="${user_row.checkControl}"/>
      </spring:bind>
      </td>

      <td>${status.index + 1}</td>
      <td><c:out value="${user_row.user.id}"/></td>
      <td><c:out value="${user_row.user.login}"/></td>
      <td><c:out value="${user_row.user.is_admin}"/></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<button type="submit" class="btn btn-danger">Submit</button>
</form:form>
  </body>
</html>