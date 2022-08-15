<%@page import="jakarta.persistence.EntityManager"%>
<%@page import="jakarta.persistence.Query"%>
<%@page import="lt.bit.pirkiniai_webjpa.data.Cekis"%>
<%@page import="lt.bit.pirkiniai_webjpa.data.Preke"%>
<%@page import="lt.bit.pirkiniai_webjpa.data.Tipas"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
   EntityManager em = (EntityManager) request.getAttribute("em");
   String cekisIds = request.getParameter("cekisId");
     if (cekisIds == null) {
         response.sendRedirect("index.jsp");
         return;
     }
     int cekisId;
     try {
         cekisId = Integer.parseInt(cekisIds);
     } catch (NumberFormatException ex) {
         response.sendRedirect("index.jsp");
         return;
     }
     Cekis c = em.find(Cekis.class, cekisId);
     if (c == null) {
         response.sendRedirect("index.jsp");
         return;
     }
     List<Preke> prekes = c.getPrekes();
 %>
 <!DOCTYPE html>
 <html>
     <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title><%=c.getData() + " " + c.getParduotuve()%> pirktos prekės</title>
     </head>
     <body>
         <h1><%=c.getData() + " " + c.getParduotuve()%> prekių sąrašas:</h1>
         <a href="prekeEdit.jsp?cekisId=<%=c.getId()%>">Nauja prekė</a>
         <%
             if (prekes.isEmpty()) {
         %>
         <h3>Nejau tik užsukai pasivaikščiot?</h3>
         <%
             } else {
         %>
         <ul>
             <%
                 for (Preke preke : prekes) {
             %>
             <li>
                 <%=preke%>
                 <a href="prekeEdit.jsp?id=<%=preke.getId()%>">edit</a>
                 <a href="deletePreke?id=<%=preke.getId()%>">delete</a>
                 <a href="tipaiList.jsp?id=<%=preke.getId()%>">Tipas</a>
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
