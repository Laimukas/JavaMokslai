<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Čekių sąrašas</title>
    </head>
    <body>
        <h1>Visų čekių sąrašas</h1>
        <a href="<%=application.getContextPath()%>/cekis/edit">Naujas cekis</a>
        <ul>
        <c:forEach var="cekis" items="${list}">
            <li>
                ${cekis.parduotuve}
                <a href="<%=application.getContextPath()%>/cekis/edit?id=${cekis.id}">Edit</a>
                <a href="<%=application.getContextPath()%>/cekis/delete?id=${cekis.id}">Delete</a>
                <br>
                <ul>
                    <c:forEach var="preke" items="${cekis.prekes}">
                        <li>
                            ${preke.preke}
                        </li>
                    </c:forEach>
                </ul>
            </li>
        </c:forEach>
        </ul>
        <a href="<%=application.getContextPath()%>/">Pagrindinis puslapis</a>
    </body>
</html>
