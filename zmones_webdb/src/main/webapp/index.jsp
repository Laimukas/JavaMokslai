<%@page import="java.util.List"%>
<%@page import="zmoneswebdb.Zmogus"%>
<%@page import="zmoneswebdb.Db"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Connection conn = (Connection) request.getAttribute("conn");
      List<Zmogus> list = Db.getZmogusList(conn);
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
          <%
              if (list.isEmpty()) {
          %>
          <h3>Sąraše nėra nė vieno žmogaus</h3>
          <%
          } else {
          %>
          <ul>
          <table border="1" cellpadding="5">
          <tr>
                              <th>Sarasas</th>
                              <th>Funkcijos</th>
                              </tr>
              <%
                  for (Zmogus zmogus : list) {
              %>
              <tr>
                 <td> <%=zmogus%></td>
                 <td><a href="zmogusEdit.jsp?id=<%=zmogus.getId()%>">Edit</a>
                  <a href="deleteZmogus?id=<%=zmogus.getId()%>">Delete</a>
                  <a href="kontaktaiList.jsp?zmogusId=<%=zmogus.getId()%>">Kontaktai</a>
                  <a href="adresaiList.jsp?zmogusId=<%=zmogus.getId()%>">Adresai</a></td>
              </tr>
              <%
                  }
              %>
          </ul>
          <%
              }
          %>
      </body>
  </html>
