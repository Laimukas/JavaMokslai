<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div align="center">
        <h2>Prisijunges vartotojas: ${user.userName}</h2>
        <table border="1" cellpadding="5">
        <tr>
            <td>
              <form method="POST" action="logout">
                 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                 <input type="submit" value="Logout">
              </form>
            </td>
            <td>
                 <a href="admin/users">Users</a>
            </td>
            <td>
                <a href="todo/edit">Edit</a>
            </td>
            <td>
              <a href="admin/permissions">Permissions</a>
            </td>
        </tr>
        </table>
    </div>
    </body>
</html>
