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
                                  <h3>Pilnas todo sarasas</h3>
<table border="1" cellpadding="5">
        <ul>
        <c:forEach var="todo" items="${todos}">
            <tr>
                <th>
                  ${todo.userId.id}
                </th>
                <td>
                ${todo.desc}
                </td>
            </tr>
        </c:forEach>
        </ul>
        </table>
        <hr>
         <h3>Pasirinkto asmens: ${user.userName} todo sarasas</h3>
        <table border="1" cellpadding="5">
                <ul>
                <c:forEach var="todo" items="${user.todosList}">
                    <tr>
                        <th>
                          ${todo.userId.id}
                        </th>
                        <td>
                        ${todo.desc}
                        </td>
                    </tr>
                </c:forEach>
                </ul>
                </table>

    </div>
    </body>
</html>
