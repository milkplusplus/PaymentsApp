<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head><title>Search Results</title>
    <jsp:include page="includeFile.jsp"></jsp:include>
  </head>
  <body>
  <jsp:include page="navigationAdminBar.jsp"></jsp:include>
    <div class="container">
    <h1>Search Result</h1>
    <c:if test="${user != null}">
        <table class="table table-striped">
        <thead>
          <tr>
                <td>ID</td>
                <td>Login</td>
                <td>Role</td>
           </tr>
           </thead>
           <tbody>
            <tr>
              <td><c:out value="${user.id}"/></td>
              <td><c:out value="${user.login}"/></td>
              <td><c:out value="${user.is_admin}"/></td>
            </tr>
          </tbody>
        </table>
     </c:if>
        <div style="color: red"><c:out value="${error}"/></div>
    </div>
  </body>
</html>