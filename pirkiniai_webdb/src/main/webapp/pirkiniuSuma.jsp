<%@page import="java.sql.Connection"%>
<%@page import="pirkiniai.webdb.Cekis"%>
<%@page import="pirkiniai.webdb.Db"%>
<%@page import="pirkiniai.webdb.Preke"%>
<%@page import="pirkiniai.webdb.Tipas"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

     Connection conn = (Connection) request.getAttribute("conn");

     List<Preke> prekes = Db.getPrekeList(conn);
     List<Cekis> cekiai = Db.getCekisList(conn);
 %>
 <!DOCTYPE html>
 <html>
     <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Pirkiniai pagal Tipą už periodą</title>
     </head>
     <body>
         <h2>Prekių sąrašas:</h2>
         <%
             if (prekes.isEmpty()) {
         %>
         <h3>Nejau nesi nieko pirkęs?</h3>
         <%
             } else {
         %>
         <ul>
             <%
                 for (Preke preke : prekes) {
             %>
             <li>
                 <%=preke%>
             </li>
             <%
                 }
             %>
         </ul>
         <%
             }
         %>
         <h2>Čekių sąrašas:</h2>
                  <%
                               if (cekiai.isEmpty()) {
                  %>
                           <h3>Kur čekiai?</h3>
                  <%
                               } else {
                  %>
                           <ul>
                               <%
                                   for (Cekis cekis : cekiai) {
                                            %>
                                            <li>
                                                 <%=cekis%>
                               </li>
                               <%
                                   }
                                   }
                               %>
                           </ul>
         <a href="index.jsp">Back</a>
          <h3>Suvesk periodo rėžius!</h3>
         <form action="savePreke" method="POST">

                       NUO: <input name="nuo" >
                       IKI: <input name="iki" ><br>

                       <input type="submit" value="Result">
                   </form>
     </body>
 </html>
