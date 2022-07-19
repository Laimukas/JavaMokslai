<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <%
        int sk = (int) (Math.random()*100+1);
    %>
    <%=sk%>
    <%
       if (sk < 20){
    %>
        mazas
    <%
       } else if (sk<80){
    %>
       vidutinis
    <%
       }else{
    %>
       didelis
    <%
       }
    %>

    </body>
</html>