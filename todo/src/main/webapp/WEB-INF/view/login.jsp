<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String error = request.getParameter("error");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <%
            if (error != null) {
        %>
        <div align="center">
        <h2>Neteisingas loginas</h2>
        </div>
        <%
            }
        %>
        <div align="center"><h3>Prisistatyk</h3>      
        <table border="1" cellpadding="5">
            <form action="./login" method="POST">        
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <tr>
                <th>
                   Vardas: 
                </th>
                <td>
                    <input type="text" name="username">
                </td>
            </tr>
            <tr>
                <th>
                   Slaptazodis: 
                </th>
                <td>
                    <input type="password" name="password">
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Login">
                </td>
                <td>
                    <a href="./index.html">Cancel</a>
                </td>
            </tr>       
         </form>   
        </table>     
    </div>     
    </body>
</html>
