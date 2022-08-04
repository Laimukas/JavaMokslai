<%@page import="java.util.List"%>
<%@page import="zmoneswebdb.Zmogus"%>
<%@page import="zmoneswebdb.ZmogusDb"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Connection conn = (Connection) request.getAttribute("conn");
    List<Zmogus> list = ZmogusDb.getList(conn);
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
                <hr>
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
                           <a href="deleteZmogus?id=<%=zmogus.getId()%>">Delete</a>`
                           <a href="kontaktaiList.jsp?zmogusId=<%=zmogus.getId()%>">Kontaktai</a>
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
