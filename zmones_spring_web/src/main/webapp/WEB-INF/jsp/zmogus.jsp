<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>vienas zmogus</title>
    </head>
    <body>
        <form method="POST" action="../save">
            <c:if test="${zmogus.id != null}">
                <input type="hidden" name="id" value="${zmogus.id}">
            </c:if>
            Vardas: <input type="text" name="vardas" value="${zmogus.vardas}">
            Pavarde: <input type="text" name="pavarde" value="${zmogus.pavarde}">
            Amzius: <input type="number" name="amzius" value="${zmogus.amzius}">
            <input type="submit" value="save">
            <a href="../">Cancel</a>
        </form>
    </body>
</html>