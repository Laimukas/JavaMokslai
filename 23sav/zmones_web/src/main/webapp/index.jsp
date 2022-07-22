<%@page import="java.util.List"%>
<%@page import="lt.bit.zmones.Zmogus"%>
<%@page import="lt.bit.zmones.Db"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Zmoniu sarasas</title>
    </head>
    <body>
    <h1>Pagr langas</h1>
        <a href="zmogusEdit.jsp">Naujas</a>
        <hr>
        <%
            List<Zmogus> l = Db.getList();
            for (Zmogus zmogus : l) {

        %>
        <%=zmogus%>
        <a href="deleteZmogus?id=<%=zmogus.getId()%>">delete</a>
        <a href="zmogusEdit.jsp?id=<%=zmogus.getId()%>">edit</a>
        <a href="kontaktaiList.jsp?zmogusId=<%=zmogus.getId()%>">Kontaktai</a>
        <a href="adresaiList.jsp?zmogusId=<%=zmogus.getId()%>">Adresai</a>
        <br>
        <%
            }
        %>

    </body>
</html>
