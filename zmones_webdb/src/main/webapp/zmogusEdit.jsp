<%@page import="java.sql.Connection"%>
<%@page import="zmoneswebdb.ZmogusDb"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="zmoneswebdb.Zmogus"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Connection conn = (Connection) request.getAttribute("conn");
    Zmogus z = null;
    String ids = request.getParameter("id");
    if (ids != null) {
        try {
            int id = Integer.parseInt(ids);
            z = ZmogusDb.getById(conn, id);
            if (z == null) {
                response.sendRedirect("index.jsp");
                return;
            }
        } catch (NumberFormatException ex) {
            response.sendRedirect("index.jsp");
            return;
        }
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Zmogaus redagavimas</title>
    </head>
    <body>
        <form action="saveZmogus" method="POST">
            <%
                if (z != null) {
            %>
            <input type="hidden" name="id" value="<%=z.getId()%>">
            <%
                }
            %>
            Vardas: <input name="vardas" value="<%=z != null ? z.getVardas() : ""%>"><br>
            Pavarde: <input name="pavarde" value="<%=z != null ? z.getPavarde() : ""%>"><br>
            Gimimo data: <input name="gimimoData" value="<%=z != null && z.getGimimoData() != null ? sdf.format(z.getGimimoData()) : ""%>"><br>
            Alga: <input name="alga" value="<%=z != null && z.getAlga() != null ? z.getAlga() : ""%>"><br>
            <input type="submit" value="Save">
        </form>
            <a href="index.jsp">Cancel</a>
    </body>
</html>