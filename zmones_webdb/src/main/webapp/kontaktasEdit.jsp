<%@page import="java.sql.Connection"%>
<%@page import="zmoneswebdb.Db"%>
<%@page import="zmoneswebdb.Zmogus"%>
<%@page import="zmoneswebdb.Kontaktas"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.SQLException"%>
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
      Kontaktas k = null;
      if (ids != null) {
          try {
              k = Db.getKontaktasById(conn, Integer.parseInt(ids));
              if (k == null) {
                  if (z == null) {
                      response.sendRedirect("index.jsp");
                  } else {
                      response.sendRedirect("kontaktaiList.jsp?zmogusId=" + z.getId());
                  }
                  return;
              }
              z = Db.getZmogusByKontaktas(conn, k);
          } catch (NumberFormatException ex) {
              if (z == null) {
                  response.sendRedirect("index.jsp");
              } else {
                  response.sendRedirect("kontaktaiList.jsp?zmogusId=" + z.getId());
              }
              return;
          } catch (SQLException ex) {
              System.err.println("Failed to find 'kontaktas': " + ex.getMessage());
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
       <div align="center">
      <table border="1" cellpadding="5">
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
              <tr><th>Tipas:</th> <td><input name="tipas" value="<%=k != null ? k.getTipas(): ""%>"></td></tr>
              <tr><th>Reiksme:</th> <td><input name="reiksme" value="<%=k != null ? k.getReiksme(): ""%>"></td></tr>
              <tr><td><input type="submit" value="Save"></td>
          </form>
          <td><a href="kontaktaiList.jsp?zmogusId=<%=z.getId()%>">Cancel</a></td></tr>
          </div>
      </body>
  </html>
