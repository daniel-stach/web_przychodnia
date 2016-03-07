<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
    </head>

    <body>
        <form name="loginForm" method="post" action="App">
            <input name="email" type="email" autofocus>
            <br>
            <input name="password" type="password">
            <br>
            <button type="submit" name="op" value="login">Login</button>
        </form>
    </body>

</html>