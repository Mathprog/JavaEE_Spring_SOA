<%--
  Created by IntelliJ IDEA.
  User: mathi
  Date: 06/12/2018
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="UTF-8">
    <title><tiles:getAsString name="title" /></title>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet" type="text/css">
</head>

<body>
<div class="flex-container">
    <tiles:insertAttribute name="header" />
    <tiles:insertAttribute name="menu" />
    <article class="article">
        <tiles:insertAttribute name="body" />
    </article>
    <tiles:insertAttribute name="footer" />
</div>
</body>
</html>