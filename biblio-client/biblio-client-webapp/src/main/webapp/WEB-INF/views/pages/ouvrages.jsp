<%--
  Created by IntelliJ IDEA.
  User: mathi
  Date: 06/12/2018
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach items="${ ouvrages }" var="ouvrage" varStatus="status">
    <p>Ouvrage : <c:out value="${ status.count }" /> : <c:out value="${ ouvrage.titre }" /></p>
</c:forEach>


