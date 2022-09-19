<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="lt.bit.spring_web.classes.Kontaktas"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Kontaktas> list = (ArrayList<Kontaktas>) request.getAttribute("kontaktai");

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kontaktai</title>
    </head>
    <body>
        <form method="GET" action="kontaktas/new">
        <input type="submit" value="ADD Kontaktas" >
        </form>
        <a href="zmones">Go Back</a>
        <hr>

        <ul>
        <table border="1" cellpadding="5">

                <tr>
                    <th>Id</th>
                    <th>ZmogausId</th>
                    <th>Tipas</th>
                    <th>Reiksme</th>
                    <th>Funkcijos</th>
                </tr>
        <c:forEach var="kontaktas" items="${kontaktai}">

            <tr>
                 <td>${kontaktas.kontId}</td>
                 <td>${kontaktas.zmId}</td>
                 <td>${kontaktas.tipas}</td>
                 <td>${kontaktas.reiksme}</td>
                 <td>
                     <a href="kontaktas/${kontaktas.kontId}">edit</a>
                     <a href="kontaktas/${kontaktas.kontId}/delete">delete</a>
                 </td>
            </tr>

        </c:forEach>
        </ul>

        <hr>

    </body>
</html>
