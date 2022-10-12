<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>vartotojo permissionai</title>
    </head>
    <body>
        <div align="center">
        <h2>Vartotojo ${user.userName} permissionai</h2>
        <form method="POST" action="../todo">
           <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
           <input type="submit" value="GoBack">
        </form>

        <table border="1" cellpadding="5">
        <c:forEach var="permission" items="${list}">
            <tr>
                 <td>${permission}
                 </td>
            </tr>
        </c:forEach>

        </table>

    </div>
    </body>
</html>
