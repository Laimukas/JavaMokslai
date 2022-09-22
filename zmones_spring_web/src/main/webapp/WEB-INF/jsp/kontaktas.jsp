<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>vienas kontaktas</title>
    </head>
    <body>
        <form method="POST" action="../saveKont">
            <c:if test="${kontaktas.kontId != null}">
                <input type="hidden" name="kontId" value="${kontaktas.kontId}">
            </c:if>
            ZmId: <input type="number" name="zmId" value="${kontaktas.zmId}">
            Tipas: <input type="text" name="tipas" value="${kontaktas.tipas}">
            Reiksme: <input type="text" name="reiksme" value="${kontaktas.reiksme}">
            <input type="submit" value="save">
            <a href="<%=application.getContextPath()%>">Cancel</a>
        </form>
    </body>
</html>