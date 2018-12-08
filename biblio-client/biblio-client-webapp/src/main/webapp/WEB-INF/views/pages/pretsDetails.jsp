<%--
  Created by IntelliJ IDEA.
  User: mathi
  Date: 06/12/2018
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="date" tagdir="/WEB-INF/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<c:forEach items="${ prets }" var="pret" varStatus="status">
    <p>Ouvrage : <c:out value="${ status.count }" /> :
        <c:out value="${ pret.exemplaire.ouvrage.titre }" /> !
        date d'emprunt : <date:localDate date="${pret.datePret}"  pattern="dd/MM/yyyy"/>,
        date de fin : <date:localDate date="${pret.dateFin}" pattern="dd/MM/yyyy"/>
        <c:choose>
            <c:when test="${empty pret.relance}">
                Demander une prolongation de :
                <form method = "POST" action = "${contextPath}/relance/add">
                    <table>
                        <tr>
                            <td><label >Semaines</label></td>
                            <td><select name="weeks">
                                <option value="1">1 semaine</option>
                                <option value="2">2 semaines</option>
                                <option value="3">3 semaines</option>
                                <option value="4">4 semaines</option>
                            </select></td>
                        </tr>
                        <input type="hidden" name="pretId" value="${pret.id}"/>
                        <tr>
                            <td colspan = "2">
                                <input type = "submit" value = "Prolonger mon prêt"/>
                            </td>
                        </tr>
                    </table>
                </form>
            </c:when>
            <c:otherwise>
                Relance jusqu'au : <date:localDate date="${pret.relance.dateFin}"  pattern="dd/MM/yyyy"/>
            </c:otherwise>
        </c:choose></p>
</c:forEach>
