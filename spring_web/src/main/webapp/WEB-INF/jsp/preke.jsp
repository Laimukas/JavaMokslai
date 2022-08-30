<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>viena preke</title>
    </head>
    <body>
        <form method="POST" action="../save">
            <c:if test="${preke.id != null}">
                <input type="hidden" name="id" value="${preke.id}">
            </c:if>
            <input type="text" name="pavadinimas" value="${preke.pavadinimas}">
            <input type="number" name="kiekis" value="${preke.kiekis}">
            <input type="submit" value="save">
            <a href="../">Cancel</a>
        </form>
    </body>
</html>
