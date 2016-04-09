<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/JspHeader.jspf" %>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
    </head>

    <body>
        <h1>${example.text}</h1>
        <br>
        <a href="<%=controller.GetAppLink(WebApp.EOperation.Example)%>">Example Operation 1</a>
        <br>
        <a href="<%=controller.GetAppLink(WebApp.EOperation.Example)%>&param=NewElo520">Example Operation 2</a>
    </body>

</html>
