<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="lt.bit.spring_web.data.Zmogus"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Zmogus> list = (List<Zmogus>) request.getAttribute("zmones");

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="GET" action="zmogus/new">
        <input type="submit" value="ADD Zmogus" >
        </form>
        <hr>
        <form method="POST" action="../search">
                   <c:if test="${zmogus.id != null}">
                       <input type="hidden" name="id" value="${zmogus.id}">
                   </c:if>
                   Vardas: <input type="text" name="vardas" value="${zmogus.vardas}">
                   Pavarde: <input type="text" name="pavarde" value="${zmogus.pavarde}">
                        <input type="hidden" name="amzius" value="${zmogus.amzius}">
                   <input type="submit" value="Search">

        </form>
        <hr>
        <input type="submit" value="Vardas">
        <input type="submit" value="Pavarde">
        <input type="submit" value="Unsorted">
        <ul>
        <table border="1" cellpadding="5">

                <tr>
                    <th>Vardas</th>
                    <th>Pavardė</th>
                    <th>Amžius</th>
                    <th>Funkcijos</th>
                </tr>
        <c:forEach var="zmogus" items="${zmones}">

            <tr>
                 <td>${zmogus.vardas}</td>
                 <td>${zmogus.pavarde}</td>
                 <td>${zmogus.amzius}</td>
                 <td>
                     <a href="zmogus/${zmogus.id}">edit</a>
                     <a href="zmogus/${zmogus.id}/delete">delete</a>
                 </td>
            </tr>

        </c:forEach>
        </ul>

        <hr>
    </body>
</html>
