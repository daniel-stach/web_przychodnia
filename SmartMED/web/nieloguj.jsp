<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/jspf/JspHeader.jspf" %>

<%@ include file="/WEB-INF/jspf/HtmlHeader.jspf" %>
<%@ include file="/WEB-INF/jspf/HtmlMenu.jspf" %>



<script>
var active = 4;
$('.mdl-navigation').eq(0).children().eq(active).addClass('active');
$('.mdl-navigation').eq(1).children().eq(active).addClass('active');
</script>
<header>
    <div class="more-section">
        <div style="padding-top: 100px; margin-left: 35%; " class="section-title mdl-typography--display-1-color-contrast">Błędny login lub hasło </div>
    </div>
    <div class="mdl-card__actions">
        <a button class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" style="margin-left: 47%;" href="zaloguj.jsp"> Powrót</button></a>
    </div>
</header>



<%-- <%@ include file="/WEB-INF/jspf/HtmlFooterPart1.jspf" %> --%>
<%@ include file="/WEB-INF/jspf/HtmlFooterPart2.jspf" %>