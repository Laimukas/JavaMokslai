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
              t = p.getTipas();
          } catch (NumberFormatException ex) {
              if (c == null && t == null) {
                  response.sendRedirect("index.jsp");
              } else {
                  response.sendRedirect("tipaiList.jsp?id=" + p.getId());
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
          <title><%=c.getData() + " " + c.getParduotuve()+ " " + p.getPreke()%> prekės tipo redagavimas</title>
      </head>
      <body>
          <form action="saveTipas" method="POST">
              <%
                  if (p != null) {
              %>
              <input type="hidden" name="tipasId" value="<%=t.getId()%>">
              <%
                  } else {
              %>
              <input type="hidden" name="id" value="<%=p.getId()%>">
              <%
                  }
              %>
              Tipas_Id: <input name="id" value="<%=t != null ? t.getId(): ""%>"><br>
              Pavadinimas: <input name="pavadinimas" value="<%=t != null ? t.getPavadinimas(): ""%>"><br>
              <input type="submit" value="Save">
          </form>
          <a href="prekesList.jsp?cekisId=<%=c.getId()%>">Cancel</a>
      </body>
  </html>
