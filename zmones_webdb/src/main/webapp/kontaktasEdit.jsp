<%@page import="java.sql.Connection"%>
<%@page import="zmoneswebdb.ZmogusDb"%>
<%@page import="zmoneswebdb.Zmogus"%>
<%@page import="zmoneswebdb.Kontaktas"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Zmogus z = null;
    String zmogusIds = request.getParameter("zmogusId");
    Connection conn = (Connection) request.getAttribute("conn");
    if (zmogusIds != null) {
        try {
            z = ZmogusDb.getById(conn,Integer.parseInt(zmogusIds));
        } catch (NumberFormatException ex) {
            // ignore
        }
    }
    String ids = request.getParameter("id");
    Kontaktas k = null;
    if (ids != null) {
        try {
            k = ZmogusDb.getKontaktasById(conn,Integer.parseInt(ids));
            if (k == null) {
                if (z == null) {
                    response.sendRedirect("index.jsp");
                } else {
                    response.sendRedirect("kontaktaiList.jsp?zmogusId=" + z.getId());
                }
                return;
            }
            z = ZmogusDb.getZmogusByKontaktas(conn,k);
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
