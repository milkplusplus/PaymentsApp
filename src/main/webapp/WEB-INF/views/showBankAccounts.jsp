<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
  <head><title>Users List</title>
    <jsp:include page="includeFile.jsp"></jsp:include>
  </head>
  <body>
  <jsp:include page="navigationAdminBar.jsp"></jsp:include>
  <div class="container">
    <h1>List of Bank Accounts</h1>
<table class="table table-striped">
<thead>
  <tr>
        <td>Index</td>
        <td>ID</td>
        <td>Balance</td>
        <td>Status</td>
        <td>Action</td>
   </tr>
   </thead>
   <tbody>
  <c:forEach var="bankAcc" items="${bankAccs}" varStatus="status">
    <tr>
      <td><c:out value="${status.index + 1}"/></td>
      <td><c:out value="${bankAcc.id}"/></td>
      <td><c:out value="${bankAcc.balance}"/></td>
      <c:if test="${bankAcc.is_blocked == true}">
          <td>Blocked</td>
          <td><a class="btn btn-primary"
          href="<c:url value="/admin/show_bank-accounts/change_status/${bankAcc.id}"/>"
          role="button">Unblock</a></td>
      </c:if>
      <c:if test="${bankAcc.is_blocked == false}">
           <td>Not Blocked</td>
           <td><a class="btn btn-warning"
            href="<c:url value="/admin/show_bank-accounts/change_status/${bankAcc.id}"/>"
           role="button">Block</a></td>
      </c:if>
    </tr>
  </c:forEach>
  </tbody>
</table>
</div>
  </body>
</html>