<%@page import="jakarta.persistence.EntityManager"%>
<%@page import="jakarta.persistence.Query"%>
<%@page import="lt.bit.pirkiniai_webjpa.data.Cekis"%>
<%@page import="lt.bit.pirkiniai_webjpa.data.Preke"%>
<%@page import="lt.bit.pirkiniai_webjpa.data.Tipas"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
     EntityManager em = (EntityManager) request.getAttribute("em");

    /* Query qpilnas = em.createQuery("select * from Cekis c join Preke p on c.id=cekis_id join Tipas t on t.id=p.tipas_id order by c.id, c.data, c.parduotuve"); */
     Query qc = em.createQuery("select c from Cekis c");
     Query qp = em.createQuery("select p from Preke p");
     Query qt = em.createQuery("select t from Tipas t");

   /*  List<> pilnas = qpilnas.getResultList();*/
     List<Preke> prekes = qc.getResultList();
     List<Tipas> tipai = qp.getResultList();
     List<Cekis> cekiai = qt.getResultList();
 %>
 <!DOCTYPE html>
 <html>
     <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Pirkiniai pagal Tipą už periodą</title>
     </head>
     <body>
         <h2>Tipų sąrašas:</h2>
         <%
         if (tipai.isEmpty()) {
         %>
         <h3>Turi sukurti prekių tipų sąrašą!</h3>
         <%
         } else {
         %>
         <ul>
         <%
            for (Tipas tipas : tipai) {
               %>
                <li>
               <%=tipas%>
             </li>
            <%
              }
         %>
         </ul>
          <%
          }
          %>
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
                    %>
                 </ul>
                 <%
                 }
                 %>
         <a href="index.jsp">Back</a>
          <h3>Suvesk periodo rėžius!</h3>
         <form action="savePreke" method="POST">

                       NUO: <input name="nuo" >
                       IKI: <input name="iki" ><br>

                       <input type="submit" value="Result">
                   </form>
     </body>
 </html>
