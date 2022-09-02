<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Prekė</title>
    </head>
    <body>
        <form method="POST" action="<%=application.getContextPath()%>/preke/save">
            <c:if test="${value != null}">
                <input type="hidden" name="id" value="${value.id}">
            </c:if>

            <div align="center">
            <table border="1" cellpadding="5">
                <tr>
                    <th>Tipas</th>
                    <th>Reikšmės</th>
                </tr>
                <tr>
                    <th>Cekis id:</th>
                    <th><input type="text" name="cekis_id" value="${value.cekis.id}"></th>
                </tr>
                <tr>
                    <th>Preke:</th>
                    <th><input type="text" name="preke" value="${value.preke}"></th>
                </tr>
                <tr>
                    <th>Kiekis:</th>
                    <th><input type="text" name="kiekis" value="${value.kiekis}"></th>
                </tr>
                <tr>
                    <th>Kaina:</th>
                    <th><input type="text" name="kaina" value="${value.kaina}"></th>
                </tr>
                <tr>
                    <th>Tipas id:</th>
                    <th><input type="text" name="tipas_id" value="${value.tipas.id}"></th>
                </tr> 
                <tr>
                <th> <input type="submit" value="Save"></th>
                <th> <a href="<%=application.getContextPath()%>/cekis">Cancel</a></th>
                </tr>

            </table>
            </div>
        </form>
    </body>
</html>