<%--
  Created by IntelliJ IDEA.
  User: mathi
  Date: 08/12/2018
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:forEach items="${ ouvrages }" var="ouvrage" varStatus="status">
    <p>Ouvrage  <c:out value="${ ouvrage.titre }" />, nb exemplaire dispos :  <c:out value="${ ouvrage.nbDispo }" /></p>
</c:forEach>
