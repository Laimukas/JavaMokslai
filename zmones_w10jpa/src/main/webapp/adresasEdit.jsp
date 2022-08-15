<%@page import="lt.bit.zmones_webjpa.data.Adresas"%>
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
    Adresas a = null;
    if (ids != null) {
        try {
            a = em.find(Adresas.class, Integer.parseInt(ids));
            if (a == null) {
                if (z == null) {
                    response.sendRedirect("index.jsp");
                } else {
                    response.sendRedirect("adresaiList.jsp?zmogusId=" + z.getId());
                }
                return;
            }
            z = a.getZmogus();
        } catch (NumberFormatException ex) {
            if (z == null) {
                response.sendRedirect("index.jsp");
            } else {
                response.sendRedirect("adresaiList.jsp?zmogusId=" + z.getId());
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
        <form action="saveAdresas" method="POST">
            <%
                if (a != null) {
            %>
            <input type="hidden" name="id" value="<%=a.getId()%>">
            <%
                } else {
            %>
            <input type="hidden" name="zmogusId" value="<%=z.getId()%>">
            <%
                }
            %>
            Adresas: <input name="adresas" value="<%=a != null ? a.getAdresas(): ""%>"><br>
            Miestas: <input name="miestas" value="<%=a != null ? a.getMiestas(): ""%>"><br>
            Pasto kodas: <input name="pastoKodas" value="<%=a != null ? a.getPastoKodas(): ""%>"><br>
            <input type="submit" value="Save">
        </form>
        <a href="adresaiList.jsp?zmogusId=<%=z.getId()%>">Cancel</a>
    </body>
</html>
