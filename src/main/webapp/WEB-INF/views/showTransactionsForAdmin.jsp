<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
  <head><title>Transactions List</title>
    <jsp:include page="includeFile.jsp"></jsp:include>
  </head>
  <body>
  <jsp:include page="navigationAdminBar.jsp"></jsp:include>
  <div class="container">
    <h1>List of the transactions</h1>
<table class="table table-striped">
<thead>
  <tr>
        <td>Index</td>
        <td>ID</td>
        <td>Data</td>
        <td>Sum</td>
        <td>Type of transaction</td>
        <td>ID of card</td>
        <td>ID of client</td>
   </tr>
   </thead>
   <tbody>
  <c:forEach var="tr" items="${transactions}" varStatus="status">
    <tr>
      <td><c:out value="${status.index + 1}"/></td>
      <td><c:out value="${tr.id}"/></td>
      <td><c:out value="${tr.tr_date}"/></td>
      <td><c:out value="${tr.tr_sum}"/></td>
      <td><c:out value="${tr.tr_type}"/></td>
      <td><c:out value="${tr.card_id}"/></td>
      <td><c:out value="${tr.client_id}"/></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</div>
<div style="color: red"><c:out value="${error}"/></div>
  </body>
</html>