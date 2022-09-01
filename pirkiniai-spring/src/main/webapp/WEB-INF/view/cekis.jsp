<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST" action="<%=application.getContextPath()%>/cekis/save">
            <c:if test="value">
                <input type="hidden" name="id" value="${value.id}">
            </c:if>
            Data: <input type="date" name="data" value="${value.data}"><br>
            Parduotuve: <input type="text" name="parduotuve" value="${value.parduotuve}"><br>
            Aprašymas: <input type="text" name="aprasymas" value="${value.aprasymas}"><br>
            <input type="submit" value="Save"><br>
            <a href="<%=application.getContextPath()%>/cekis">Cancel</a>
        </form>
    </body>
</html>
