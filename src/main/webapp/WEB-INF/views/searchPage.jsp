<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head><title>Search</title>
    <jsp:include page="includeFile.jsp"></jsp:include>
  </head>
  <body>
  <jsp:include page="navigationAdminBar.jsp"></jsp:include>
    <div class="container">
    <h1>Search</h1>
        <div type="div-search">
            <form:form name="/admin/find" method="POST">
            <input type="text-search" id="login" name="login" placeholder="Enter user's login...">
            <br></br>
            <input class ="submit-search" type="submit" value="Search">
          </form:form>
        </div>
    </div>
  </body>
</html>