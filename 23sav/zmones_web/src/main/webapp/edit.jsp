<%@page import="java.text.SimpleDateFormat"%>
 <%@page import="lt.bit.zmones.Db"%>
 <%@page import="lt.bit.zmones.Zmogus"%>
 <%@page contentType="text/html" pageEncoding="UTF-8"%>
 <!DOCTYPE html>
 <html>
     <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Zmogaus redagavimas</title>
     </head>
     <body>
         <%
             int id = Integer.parseInt(request.getParameter("id"));
             Zmogus z = Db.getById(id);
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
             String zgd;
             try {
             zgd = sdf.format(z.getGimimoData());
             } catch (Exception ex) {
             zgd="";
             }

         %>
         <form action="saveZmogus" method="POST">
             <input type="hidden" name="id" value="<%=z.getId()%>">
             Vardas: <input name="vardas" value="<%=z.getVardas()%>"><br>
             Pavarde: <input name="pavarde" value="<%=z.getPavarde()%>"><br>
             Gimimo data: <input name="gimimoData" value="<%=zgd%>"><br>
             Alga: <input name="alga" value="<%=z.getAlga()%>"><br>
             <input type="submit" value="Save">
         </form>

     </body>
 </html>
