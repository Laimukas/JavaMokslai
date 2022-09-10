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
        <a href="editUser">New user</a>
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
                </td>                
            </tr>
        </c:forEach>
        </ul>
        </table>
        </div>
    </body>
</html>
