<%@page import="jakarta.persistence.EntityManager"%>
<%@page import="jakarta.persistence.Query"%>
<%@page import="lt.bit.zmones_webjpa.data.Zmogus"%>
<%@page import="lt.bit.zmones_webjpa.data.Kontaktas"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

    EntityManager em = (EntityManager) request.getAttribute("em");

         Zmogus z = em.find(Zmogus.class, request.getParameter("zmogusId"));
         if (z == null) {
             response.sendRedirect("index.jsp");
             return;
         }
     List<Kontaktas> kontaktai = z.getKontaktai();
 %>
 <!DOCTYPE html>
 <html>
     <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title><%=z.getVardas() + " " + z.getPavarde()%> kontaktai</title>
     </head>
     <body>
         <h1><%=z.getVardas() + " " + z.getPavarde()%> kontaktu sarasas</h1>
         <a href="kontaktasEdit.jsp?zmogusId=<%=z.getId()%>">New</a>
         <%
             if (kontaktai.isEmpty()) {
         %>
         <h3>Nezinau, kaip susisiekti su situ zmogumi</h3>
         <%
             } else {
         %>
         <ul>
             <%
                 for (Kontaktas kontaktas : kontaktai) {
             %>
             <li>
                 <%=kontaktas%>
                 <a href="kontaktasEdit.jsp?id=<%=kontaktas.getId()%>">edit</a>
                 <a href="deleteKontaktas?id=<%=kontaktas.getId()%>">delete</a>
             </li>
             <%
                 }
             %>
         </ul>
         <%
             }
         %>
         <a href="index.jsp">Back</a>
     </body>
 </html>
