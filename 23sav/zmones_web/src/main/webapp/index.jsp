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
        <form action="addZmogus" method="POST">
            Vardas: <input name="vardas"><br>
            Pavarde: <input name="pavarde"><br>
            <input type="submit" value="Save">
        </form>
        <hr>
        <%
            List<Zmogus> l = Db.getList();
            for (Zmogus zmogus : l) {

        %>
        <%=zmogus%> <a href="deleteZmogus?id=<%=zmogus.getId()%>">delete</a><br>
        <%
            }
        %>

    </body>
</html>
