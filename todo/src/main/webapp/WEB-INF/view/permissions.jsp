<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Permission List</title>
    </head>
    <body>
        <div align="center">
        <table>
        <tr>
        <td>
        <a href="editPermission">New permission</a></td>
        <td>
        <form method="POST" action="../todo">
              <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
              <input type="submit" value="GoBack">
        </form></td>
        </tr>
        </table>

        <table border="1" cellpadding="5">
        <ul>
        <c:forEach var="permission" items="${list}">
            <tr>
                <th>
                  ${permission.permissionName}
                </th>
                <td>
                <a href="editPermission?id=${permission.id}">edit</a>
                <a href="deletePermission?id=${permission.id}">delete</a>
                </td>
            </tr>
        </c:forEach>
        </ul>
        </table>
        </div>
    </body>
</html>
