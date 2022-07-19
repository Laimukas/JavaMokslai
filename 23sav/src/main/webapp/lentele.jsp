<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <%
    String vardas = "Jonas";
    vardas += " ";
    vardas += "Jonaitis";
    %>
        <table>
            <tbody>
                <tr>
                    <td>11</td>
                    <td>12</td>
                    <td>13</td>
                </tr>
                <tr>
                    <td>21</td>
                    <td>22</td>
                    <td>23</td>
                </tr>
                <tr>
                    <td>31</td>
                    <td>32</td>
                    <td>33</td>
                </tr>
            </tbody>
        </table>
        <h1><%=10+20%></h1>
        <h1><%=vardas%></h1>
    </body>
</html>