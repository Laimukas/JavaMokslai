<%@page import="lt.bit.zmones.Zmogus"%>
<%@page import="lt.bit.zmones.Db"%>
<%@page import="lt.bit.zmones.Adresas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Zmogus z = null;
    String zmogusIds = request.getParameter("zmogusId");
    if (zmogusIds != null) {
        try {
            z = Db.getById(Integer.parseInt(zmogusIds));
        } catch (NumberFormatException ex) {
            // ignore
        }
    }
    String ids = request.getParameter("id");
    Adresas a = null;
    if (ids != null) {
        try {
            a = Db.getAdresasById(Integer.parseInt(ids));
            if (a == null) {
                if (a == null) {
                    response.sendRedirect("index.jsp");
                } else {
                    response.sendRedirect("adresaiList.jsp?zmogusId=" + z.getId());
                }
                return;
            }
            z = Db.getZmogusByAdresas(a);
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
        <title><%=z.getVardas()%> <%=z.getPavarde()%> adreso redagavimas</title>
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
            Pasto Kodas: <input name="pastoKodas" value="<%=a != null ? a.getPastoKodas(): ""%>"><br>
            Valstybe: <input name="valstybe" value="<%=a != null ? a.getValstybe(): ""%>"><br>
            <input type="submit" value="Save">
        </form>
        <a href="adresaiList.jsp?zmogusId=<%=z.getId()%>">Cancel</a>
    </body>
</html>
