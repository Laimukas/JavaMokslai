<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <br>
        <div align="center">
          <h1>edit</h1>
          <form method="POST" action="../todo">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <input type="submit" value="GoBack">
          </form></td>
        </div>        
    </body>
</html>
