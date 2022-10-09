<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <br>
        <div align="center">
          <h1>Uzduotis</h1>
          <form method="POST" action="save">
                      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                      <c:if test="${todo != null}">
                          <input type="hidden" name="id" value="${todo.id}">
                      </c:if>
                      <table border="1" cellpadding="5">
                          <tr>
                              <th>
                                  User Id:
                              </th>
                              <td>
                                  <input type="number" name="user_id" value="${todo.user_id}">
                              </td>
                          </tr>
                          <tr>
                              <th>
                                  Kokia:
                              </th>
                              <td>
                                  <input type="text" name="desc" value="${todo.desc}">
                              </td>
                          </tr>
                          <tr>
                              <td>
                                <input type="submit" value="Save">
                              </td>
                              <td>
                                  <a href="../todo">Cancel</a>
                              </td>
                          </tr>
                  </table>
                  </form>
        </div>        
    </body>
</html>
