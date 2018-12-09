<%--
  Created by IntelliJ IDEA.
  User: mathi
  Date: 08/12/2018
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>


Infos détaillés :
<form method = "POST" action = "${contextPath}/ouvrages/recherche">
    <table>
        <tr>
            <td><label >Titre</label></td>
            <td><input name = "titre" /></td>
        </tr>
        <tr>
            <td colspan = "2">
                <input type = "submit" value = "Rechercher"/>
            </td>
        </tr>
    </table>
</form>