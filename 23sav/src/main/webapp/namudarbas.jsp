<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Namu Darbas</title>
    </head>
    <body>
    <table>
    <tbody>
        <%
        for(int i = 3;i<=15;i++){
        %>
           <tr>
           <%
            for(int j = 3;j<=15;j++){
            %>
                    <td>
                    <%= i*j%>
                    </td>
            <%
            }
            %>
            </tr>
        <%
          }
        %>
          </tbody>
       </table>
       <h1>***********************************
       </h1>
       <table>
       <thead>
           <tr>
               <td></td>
               <tr>
               <td></td>
                   <%
                     for(int a = 3;a<=15;a++){
                   %>
                    <td><b>
                    <%=a%>
                    </b></td>
                    <%
                    }
                    %>
               </tr>
           </tr>
       </thead>
           <tbody>
               <%
               for(int i = 3;i<=15;i++){
               %>
               <tr>
               <td><b><%=i%>
               </b></td>

                  <%
                   for(int j = 3;j<=15;j++){
                   %>
                     <td>
                     <%= i*j%>
                     </td>
                   <%
                   }
                   %>
                   </tr>
               <%
                 }
               %>
         </tbody>
       </table>
    </body>
</html>