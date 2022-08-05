<%@page import="zmoneswebdb.Adresas"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="zmoneswebdb.Db"%>
<%@page import="zmoneswebdb.Zmogus"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Connection conn = (Connection) request.getAttribute("conn");
    Zmogus z = null;
    String zmogusIds = request.getParameter("zmogusId");
    if (zmogusIds != null) {
        try {
            z = Db.getZmogusById(conn, Integer.parseInt(zmogusIds));
        } catch (NumberFormatException ex) {
            // ignore
        } catch (SQLException ex) {
            System.err.println("Failed to find 'zmogus': " + ex.getMessage());
            response.sendRedirect("index.jsp");
            return;
        }
    }
    String ids = request.getParameter("id");
    Adresas a = null;
    if (ids != null) {
        try {
            a = Db.getAdresasById(conn, Integer.parseInt(ids));
            if (a == null) {
                if (z == null) {
                    response.sendRedirect("index.jsp");
                } else {
                    response.sendRedirect("adresaiList.jsp?zmogusId=" + z.getId());
                }
                return;
            }
            z = Db.getZmogusByAdresas(conn, a);
        } catch (NumberFormatException ex) {
            if (z == null) {
                response.sendRedirect("index.jsp");
            } else {
                response.sendRedirect("adresaiList.jsp?zmogusId=" + z.getId());
            }
            return;
        } catch (SQLException ex) {
            System.err.println("Failed to find 'adresas': " + ex.getMessage());
            response.sendRedirect("index.jsp");
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
