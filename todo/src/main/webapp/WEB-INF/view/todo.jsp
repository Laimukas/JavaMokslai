<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div align="center">
        <table cellpadding="5">
        <tr>
            <td>
                <h2>Prisijunges vartotojas: ${user.userName}</h2>
            </td>
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
                <a href="admin/permissions">Permissions</a>
            </td>
             <td>
                <a href="viewer/todoView?user_id=${user.id}">Todo list</a>
             </td>
             <td>
                 <a href="viewer/todos?user_id=${user.id}">My Todos</a>
             </td>
        </tr>
        </table>
        <hr>
        <a href="todo/edit?user_id=${user.id}">Nauja Uzduotis</a>


    </div>
    </body>
</html>
