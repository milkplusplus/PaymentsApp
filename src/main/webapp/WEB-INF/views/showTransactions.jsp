<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
  <head><title>Transactions</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </head>
  <body>
  <div class="container">
    <h1>List of the transactions</h1>
<table class="table table-striped">
<thead>
  <tr>
        <td>INDEX</td>
        <td>ID</th>
        <td>Data</th>
        <td>Sum</th>
        <td>Type of transaction</th>
        <td>ID of card</th>
        <td>ID of client</th>
   </tr>
   </thead>
   <tbody>
  <c:forEach var="tr" items="${transactions}" varStatus="status">
    <tr>
      <td><c:out value="${status.index}"/></td>
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
  </body>
</html>