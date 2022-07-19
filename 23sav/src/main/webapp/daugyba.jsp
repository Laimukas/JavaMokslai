<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Namu Darbas-Aliaus varijantas</title>
    </head>
    <body>
                  <%
                  int nuo = 3;
                  int iki = 15;
                  try{
                  nuo = Integer.parseInt (request.getParameter("nuo"));
                  }catch(Exception ex){
                  //ignore
                  }
                  try{
                  iki = Integer.parseInt (request.getParameter("iki"));
                  }catch(Exception ex){
                  //ignore
                  }
                  %>
                  <form action="daugyba.jsp" method="GET">
                  Nuo: <input type="number" name="nuo" value="<%=nuo%>"><br>
                  Iki: <input type="number" name="iki" value="<%=iki%>"><br>
                  <input type="submit" value="perskaiciuok">
                  </form>
                  <table>
                      <thead>
                          <tr>
                              <td></td>
                              <%
                                  for (int j = nuo; j <= iki; j++) {
                              %>
                              <th><b><%=j%></b></th>
                              <%
                                  }
                              %>
                          </tr>
                      </thead>
                      <tbody>
                          <%
                              for (int i = nuo; i <= iki; i++) {
                          %>
                          <tr>
                              <td><b><%=i%></b></td>
                              <%
                                  for (int j = nuo; j <= iki; j++) {
                              %>
                              <td><%=i * j%></td>
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