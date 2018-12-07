<%--
  Created by IntelliJ IDEA.
  User: mathi
  Date: 06/12/2018
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h2>Tous les ouvrages :</h2>

<c:forEach items="${ ouvrages }" var="ouvrage" varStatus="status">
    <p>Ouvrage  <c:out value="${ ouvrage.titre }" /></p>
</c:forEach>

<h2>Ouvrage disponibles :</h2>

<c:forEach items="${ ouvragesDispos }" var="ouvrageDispo" varStatus="status">
    <p>Ouvrage : <c:out value="${ ouvrageDispo.titre }"/>, Dispo : <c:out value="${ ouvrageDispo.nbDispo }"/></p>
</c:forEach>

<h2> Ouvrage non disponible : </h2>

<c:forEach items="${ ouvragesNonDispos }" var="ouvrageNonDispo" varStatus="status">
    <p>Ouvrage : <c:out value="${ ouvrageNonDispo.titre }"/></p>
</c:forEach>



