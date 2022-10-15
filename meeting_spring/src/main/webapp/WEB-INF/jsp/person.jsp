<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="lt.bit.spring_web.data.Meeting"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Person</title>
    </head>
    <body>

<div align="center">
    <table border="1" cellpadding="5">
        <form method="POST" action="../save">
            <c:if test="${meeting.id != null}">
                <input type="hidden" name="id" value="${meeting.id}">
            </c:if>
            <tr><th>Name:</th> <td> <input type="text" name="name" value="${meeting.name}"></td> </tr>
            <tr><th>Responsible person:</th> <td> <input type="text" name="responsiblePerson" value="${meeting.responsiblePerson.prname}"></td> </tr>
            <tr><th>Description:</th> <td> <input type="text" name="description" value="${meeting.description}"></td> </tr>
            <tr><th>Category:</th> <td> <input type="text" name="category" value="${meeting.category}"></td> </tr>
            <tr><th>Type:</th> <td> <input type="text" name="type" value="${meeting.type}"></td> </tr>
            <tr><th>Start Date:</th> <td> <input type="text" name="startDate" value="${meeting.startDate}"></td> </tr>
            <tr><td><input type="submit" value="save"></td>
            <td><a href="../">Cancel</a></td> </tr>
        </form>
        </div>

    </body>
</html>
