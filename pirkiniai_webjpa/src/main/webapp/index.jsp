<%@page import="java.util.List"%>
<%@page import="jakarta.persistence.EntityManager"%>
<%@page import="jakarta.persistence.Query"%>
<%@page import="lt.bit.pirkiniai_webjpa.data.Cekis"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    EntityManager em = (EntityManager) request.getAttribute("em");
      Query q = em.createQuery("select c from Cekis c");
      Query qbs = em.createQuery("select sum(p.kaina*p.kiekis) from Preke p");
      List<Cekis> list = q.getResultList();
      String bendrasuma = ""+ qbs.getResultList();
     %>
  <!DOCTYPE html>
  <html>
      <head>
          <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <title>Pirkiniai</title>
      </head>
      <body>
          <h1>Ataskaitos:</h1>
          <a href="pirkiniuSuma.jsp">Bendra pirkiniu suma uz perioda</a>
          <p></p>
          <a href="pirkiniaiPagalTipa.jsp">Pirkiniai pagal tipa uz perioda</a>
          <%
              if (list.isEmpty()) {
          %>
          <h3>Sąraše nėra nė vieno čekio</h3>
          <%
          } else {
          %>
          <h1>Čekiai:</h1>
          <a href="cekisEdit.jsp">Naujas Čekis</a>
          <ul>
              <%
                  for (Cekis cekis : list) {
              %>
              <li>
                  <%=cekis%>
                  <a href="cekisEdit.jsp?id=<%=cekis.getId()%>">Edit</a>
                  <a href="deleteCekis?id=<%=cekis.getId()%>">Delete</a>
                  <a href="prekesList.jsp?cekisId=<%=cekis.getId()%>">Prekes</a>
              </li>
              <%
                  }
              %>
          </ul>
          <h3>Bendra Suma:</h3>
             <%=bendrasuma%>
          <%
              }
          %>
      </body>
  </html>
