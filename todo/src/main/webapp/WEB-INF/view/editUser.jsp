<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User edit</title>
    </head>
    <body>
        <div align="center">
        <form method="POST" action="saveUser">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <c:if test="${user != null}">
                <input type="hidden" name="id" value="${user.id}">
            </c:if>
            <table border="1" cellpadding="5">
                <tr>
                    <th>
                        User name:
                    </th>
                    <td>
                        <input type="text" name="userName" value="${user.userName}">
                    </td>
                </tr>
                <tr>
                    <th>
                        Password:
                    </th>
                    <td>
                        <input type="password" name="userPassword">
                    </td>
                </tr>
                <tr>
                    <td>
                      <input type="submit" value="Save">
                    </td>
                    <td>
                        <a href="./users">Cancel</a>
                    </td>
                </tr>
        </table>
        </form>
    </div>
    </body>
</html>
