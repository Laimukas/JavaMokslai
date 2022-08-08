<%@page import="java.sql.Connection"%>
<%@page import="pirkiniai.webdb.Cekis"%>
<%@page import="pirkiniai.webdb.Db"%>
<%@page import="pirkiniai.webdb.Preke"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.SQLException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Connection conn = (Connection) request.getAttribute("conn");
      Cekis c = null;
      String cekisIds = request.getParameter("cekisId");
      if (cekisIds != null) {
          try {
              c = Db.getCekisById(conn, Integer.parseInt(cekisIds));
          } catch (NumberFormatException ex) {
              // ignore
          } catch (SQLException ex) {
              System.err.println("Failed to find 'cekis': " + ex.getMessage());
              response.sendRedirect("index.jsp");
              return;
          }
      }
      String ids = request.getParameter("id");
      Preke p = null;
      if (ids != null) {
          try {
              p = Db.getPrekeById(conn, Integer.parseInt(ids));
              if (p == null) {
                  if (c == null) {
                      response.sendRedirect("index.jsp");
                  } else {
                      response.sendRedirect("prekesList.jsp?cekisId=" + c.getId());
                  }
                  return;
              }
              c = Db.getCekisByPreke(conn, p);
          } catch (NumberFormatException ex) {
              if (c == null) {
                  response.sendRedirect("index.jsp");
              } else {
                  response.sendRedirect("prekesList.jsp?cekisId=" + c.getId());
              }
              return;
          } catch (SQLException ex) {
              System.err.println("Failed to find 'preke': " + ex.getMessage());
              response.sendRedirect("index.jsp");
              return;
          }
      }
      if (c == null) {
          response.sendRedirect("index.jsp");
          return;
      }
  %>
  <!DOCTYPE html>
  <html>
      <head>
          <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <title><%=c.getData() + " " + c.getParduotuve()%> prekės redagavimas</title>
      </head>
      <body>
          <form action="savePreke" method="POST">
              <%
                  if (p != null) {
              %>
              <input type="hidden" name="id" value="<%=p.getId()%>">
              <%
                  } else {
              %>
              <input type="hidden" name="cekisId" value="<%=c.getId()%>">
              <%
                  }
              %>
              Cekis_id: <input name="cekis_id" value="<%=p != null ? p.getCekisid(): ""%>"><br>
              Preke: <input name="preke" value="<%=p != null ? p.getPreke(): ""%>"><br>
              Kiekis: <input name="kiekis" value="<%=p != null ? p.getKiekis(): ""%>"><br>
              Kaina: <input name="kaina" value="<%=p != null ? p.getKaina(): ""%>"><br>
              Tipas_Id: <input name="tipas_id" value="<%=p != null ? p.getTipasid(): ""%>"><br>
              <input type="submit" value="Save">
          </form>
          <a href="prekesList.jsp?cekisId=<%=c.getId()%>">Cancel</a>
      </body>
  </html>
