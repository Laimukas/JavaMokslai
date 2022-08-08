<%@page import="java.sql.Connection"%>
<%@page import="pirkiniai.webdb.Db"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="pirkiniai.webdb.Cekis"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      Connection conn = (Connection) request.getAttribute("conn");
      Cekis c = null;
      String ids = request.getParameter("id");
      if (ids != null) {
          try {
              int id = Integer.parseInt(ids);
              c = Db.getCekisById(conn, id);
              if (c == null) {
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
          <title>Čekio redagavimas</title>
      </head>
      <body>
          <form action="saveCekis" method="POST">
              <%
                  if (c != null) {
              %>
              <input type="hidden" name="id" value="<%=c.getId()%>">
              <%
                  }
              %>
              Data: <input name="data" value="<%=c != null && c.getData() != null ? sdf.format(c.getData()) : ""%>"><br>
              Parduotuve: <input name="parduotuve" value="<%=c != null ? c.getParduotuve() : ""%>"><br>
              Aprasymas: <input name="aprasymas" value="<%=c != null ? c.getAprasymas() : ""%>"><br>
              <input type="submit" value="Save">
          </form>
              <a href="index.jsp">Cancel</a>
      </body>
  </html>
