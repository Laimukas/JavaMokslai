<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Permission edit</title>
    </head>
    <body>
        <div align="center">
        <form method="POST" action="savePermission">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <c:if test="${permission != null}">
                <input type="hidden" name="id" value="${permission.id}">
            </c:if>
            <table border="1" cellpadding="5">
                <tr>
                    <th>
                        Permission name:
                    </th>
                    <td>
                        <input type="text" name="permissionName" value="${permission.permissionName}">
                    </td>
                </tr>
                <tr>
                    <th>
                        Description:
                    </th>
                    <td>
                        <input type="text" name="desc" value="${permission.desc}">
                    </td>
                </tr>
                <tr>
                    <td>
                      <input type="submit" value="Save">
                    </td>
                    <td>
                        <a href="./permissions">Cancel</a>
                    </td>
                </tr>
        </table>
        </form>
    </div>
    </body>
</html>
