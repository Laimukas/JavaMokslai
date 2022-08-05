<%@page import="java.sql.Connection"%>
<%@page import="zmoneswebdb.Db"%>
<%@page import="zmoneswebdb.Zmogus"%>
<%@page import="zmoneswebdb.Kontaktas"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
   String zmogusIds = request.getParameter("zmogusId");
     if (zmogusIds == null) {
         response.sendRedirect("index.jsp");
         return;
     }
     int zmogusId;
     try {
         zmogusId = Integer.parseInt(zmogusIds);
     } catch (NumberFormatException ex) {
         response.sendRedirect("index.jsp");
         return;
     }
     Connection conn = (Connection) request.getAttribute("conn");
     Zmogus z = Db.getZmogusById(conn, zmogusId);
     if (z == null) {
         response.sendRedirect("index.jsp");
         return;
     }
     List<Kontaktas> kontaktai = Db.getKontaktasListByZmogusId(conn, zmogusId);
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
                 <a href="deleteKontaktas?id=<%=kontaktas.getId()%>">delete</a>
                 <a href="kontaktasEdit.jsp?id=<%=kontaktas.getId()%>">edit</a>
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
