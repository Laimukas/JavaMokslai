<%@page import="jakarta.persistence.Query"%>
<%@page import="lt.bit.zmones_webjpa.data.Zmogus"%>
<%@page import="jakarta.persistence.EntityManager"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    EntityManager em = (EntityManager) request.getAttribute("em");
    Query q = em.createQuery("select z from Zmogus z order by z.vardas, z.pavarde");
    List<Zmogus> list = q.getResultList();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Žmonės</title>
    </head>
    <body>
        <h1>Žmonių sąrašas</h1>
        <a href="zmogusEdit.jsp">Naujas</a>
        <%
            if (list.isEmpty()) {
        %>
        <h3>Sąraše nėra nė vieno žmogaus</h3>
        <%
        } else {
        %>
        <ul>
            <%
                for (Zmogus zmogus : list) {
            %>
            <li>
                <%=zmogus%>
                <a href="zmogusEdit.jsp?id=<%=zmogus.getId()%>">Edit</a>
                <a href="deleteZmogus?id=<%=zmogus.getId()%>">Delete</a>
                <a href="kontaktaiList.jsp?zmogusId=<%=zmogus.getId()%>">Kontaktai</a>
                <a href="adresaiList.jsp?zmogusId=<%=zmogus.getId()%>">Adresai</a>
            </li>
            <%
                }
            %>
        </ul>
        <%
            }
        %>
    </body>
</html>
