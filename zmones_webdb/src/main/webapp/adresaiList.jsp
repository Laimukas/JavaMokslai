<%@page import="zmoneswebdb.Adresas"%>
<%@page import="java.sql.Connection"%>
<%@page import="zmoneswebdb.Db"%>
<%@page import="zmoneswebdb.Zmogus"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String zmogusIds = request.getParameter("zmogusId");
    if (zmogusIds == null) {
        response.sendRedirect("index.jsp");
        return;
    }
    int zmogusId;
    try {
        zmogusId = Integer.parseInt(zmogusIds);
    } catch (NumberFormatException ex) {
        response.sendRedirect("index.jsp");
        return;
    }
    Connection conn = (Connection) request.getAttribute("conn");
    Zmogus z = Db.getZmogusById(conn, zmogusId);
    if (z == null) {
        response.sendRedirect("index.jsp");
        return;
    }
    List<Adresas> adresai = Db.getAdresasListByZmogusId(conn, zmogusId);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=z.getVardas() + " " + z.getPavarde()%> adresai</title>
    </head>
    <body>
        <h1><%=z.getVardas() + " " + z.getPavarde()%> adresu sarasas</h1>
        <a href="adresasEdit.jsp?zmogusId=<%=z.getId()%>">New</a>
        <%
            if (adresai.isEmpty()) {
        %>
        <h3>Bomzas</h3>
        <%
            } else {
        %>
        <ul>
            <%
                for (Adresas adresas : adresai) {
            %>
            <li>
                <%=adresas%>
                <a href="deleteAdresas?id=<%=adresas.getId()%>">delete</a>
                <a href="adresasEdit.jsp?id=<%=adresas.getId()%>">edit</a>
            </li>
            <%
                }
            %>
        </ul>
        <%
            }
        %>
        <a href="index.jsp">Back</a>
    </body>
</html>
