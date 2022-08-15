<%@page import="lt.bit.zmones_webjpa.data.Kontaktas"%>
<%@page import="lt.bit.zmones_webjpa.data.Zmogus"%>
<%@page import="jakarta.persistence.EntityManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    EntityManager em = (EntityManager) request.getAttribute("em");
    Zmogus z = null;
    String zmogusIds = request.getParameter("zmogusId");
    if (zmogusIds != null) {
        try {
            z = em.find(Zmogus.class, Integer.parseInt(zmogusIds));
        } catch (NumberFormatException ex) {
            // ignore
        }
    }
    String ids = request.getParameter("id");
    Kontaktas k = null;
    if (ids != null) {
        try {
            k = em.find(Kontaktas.class, Integer.parseInt(ids));
            if (k == null) {
                if (z == null) {
                    response.sendRedirect("index.jsp");
                } else {
                    response.sendRedirect("kontaktaiList.jsp?zmogusId=" + z.getId());
                }
                return;
            }
            z = k.getZmogus();
        } catch (NumberFormatException ex) {
            if (z == null) {
                response.sendRedirect("index.jsp");
            } else {
                response.sendRedirect("kontaktaiList.jsp?zmogusId=" + z.getId());
            }
            return;
        }
    }
    if (z == null) {
        response.sendRedirect("index.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=z.getVardas()%> <%=z.getPavarde()%> kontakto redagavimas</title>
    </head>
    <body>
        <form action="saveKontaktas" method="POST">
            <%
                if (k != null) {
            %>
            <input type="hidden" name="id" value="<%=k.getId()%>">
            <%
                } else {
            %>
            <input type="hidden" name="zmogusId" value="<%=z.getId()%>">
            <%
                }
            %>
            Tipas: <input name="tipas" value="<%=k != null ? k.getTipas(): ""%>"><br>
            Reiksme: <input name="reiksme" value="<%=k != null ? k.getReiksme(): ""%>"><br>
            <input type="submit" value="Save">
        </form>
        <a href="kontaktaiList.jsp?zmogusId=<%=z.getId()%>">Cancel</a>
    </body>
</html>
