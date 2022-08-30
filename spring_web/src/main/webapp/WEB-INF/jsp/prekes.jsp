<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="lt.bit.spring_web.data.Preke"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Preke> list = (List<Preke>) request.getAttribute("prekes");

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="preke/new">Nauja preke</a>
        <hr>
        ${prekes}
        <ul>
        <c:forEach var="preke" items="${prekes}">
            <li>
                ${preke.pavadinimas}
                <a href="preke/${preke.id}">edit</a>
                <a href="preke/${preke.id}/delete">delete</a>
            </li>
        </c:forEach>
        </ul>
        
        <hr>
        
        <%=list%>
        <ul>
        <%
            for (Preke preke : list) {
        %>
            <li>
                <%=preke.getPavadinimas()%>
                <a href="preke/<%=preke.getId()%>">edit</a>
                <a href="preke/<%=preke.getId()%>/delete">delete</a>
            </li>        
        <%
            }
        %>
        </ul>
    </body>
</html>
