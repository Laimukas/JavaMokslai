<%@page import="jakarta.persistence.EntityManager"%>
<%@page import="jakarta.persistence.Query"%>
<%@page import="lt.bit.pirkiniai_webjpa.data.Cekis"%>
<%@page import="lt.bit.pirkiniai_webjpa.data.Preke"%>
<%@page import="lt.bit.pirkiniai_webjpa.data.Tipas"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
      EntityManager em = (EntityManager) request.getAttribute("em");
      Cekis c = null;
      Tipas t = null;
      String cekisIds = request.getParameter("cekisId");
      if (cekisIds != null) {
          try {
              c = em.find(Cekis.class, cekisIds);
          } catch (NumberFormatException ex) {
              // ignore
          }
      }
      String ids = request.getParameter("id");
      Preke p = null;
      if (ids != null) {
          try {
              p = em.find(Preke.class, ids);
              if (p == null) {
                  if (c == null) {
                      response.sendRedirect("index.jsp");
                  } else {
                      response.sendRedirect("prekesList.jsp?cekisId=" + c.getId());
                  }
                  return;
              }
              c = p.getCekis();
             /* t = p.getTipas(); */
          } catch (NumberFormatException ex) {
              if (c == null && t == null) {
                  response.sendRedirect("index.jsp");
              } else {
                  response.sendRedirect("prekesList.jsp?cekisId=" + c.getId());
              }
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
              Cekis_id: <input name="cekis_id" value="<%=p != null ? p.getCekis().getId(): ""%>"><br>
              Preke: <input name="preke" value="<%=p != null ? p.getPreke(): ""%>"><br>
              Kiekis: <input name="kiekis" value="<%=p != null ? p.getKiekis(): ""%>"><br>
              Kaina: <input name="kaina" value="<%=p != null ? p.getKaina(): ""%>"><br>
              Tipas_Id: <input name="tipas_id" value="<%=p != null ? p.getTipas().getId(): ""%>"><br>
              <input type="submit" value="Save">
          </form>
          <a href="prekesList.jsp?cekisId=<%=c.getId()%>">Cancel</a>
      </body>
  </html>
