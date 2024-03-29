<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User List</title>
    </head>
    <body>
        <div align="center">
        <table>
        <tr>
        <td>
        <a href="editUser">New user</a></td>
        <td>
        <form method="POST" action="../todo">
              <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
              <input type="submit" value="GoBack">
        </form></td>
        </tr>
        </table>

        <table border="1" cellpadding="5">
        <ul>
        <c:forEach var="user" items="${list}">
            <tr>
                <th>
                  ${user.userName}  
                </th>
                <td>
                <a href="editUser?id=${user.id}">edit</a>
                <a href="deleteUser?id=${user.id}">delete</a>
                <a href="userPermissions?id=${user.id}">User Permissions</a>
                </td>                
            </tr>
        </c:forEach>
        </ul>
        </table>
        </div>
    </body>
</html>
