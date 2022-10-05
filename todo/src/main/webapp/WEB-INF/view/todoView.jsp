<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Todo sarasai</title>
    </head>
    <body>
        <div align="center">
        <form method="POST" action="../todo">
           <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
           <input type="submit" value="GoBack">
        </form><br>

        <select name="user_id">
                                    <c:forEach var="user" items="${list}">
                                      <option value="${user.id}" <c:if test="${user.id==value.user.id}">selected</c:if>>
                                        ${user.userName}
                                      </option>
                                    </c:forEach>
                                  </select>
<table border="1" cellpadding="5">
        <ul>
        <c:forEach var="todo" items="${todos}">
            <tr>
                <th>
                  ${todo.desc}
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
