<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/jspf/JspHeader.jspf" %>

<%@ include file="/WEB-INF/jspf/HtmlHeader.jspf" %>
<%@ include file="/WEB-INF/jspf/HtmlMenu.jspf" %>



<header>
    <div class="more-section" style="max-width: 1600px;">
        <div class="section-title mdl-typography--display-1-color-contrast">Pacjenci</div>
        <table class="mdl-data-table mdl-shadow--2dp" style="width: 100%;">
            <thead>
                <tr>
                    <th>Imię</th>
                    <th>Nazwisko</th>
                    <th>Email</th>
                    <th>PESEL</th>
                    <th>Nr telefonu</th>
                </tr>
            </thead>
            <tbody>
                ${lroom.htmlTableRows}
            </tbody>
        </table>


        <div style="margin-top: 50px;" class="section-title mdl-typography--display-1-color-contrast">Notatki</div>
        <table class="mdl-data-table mdl-shadow--2dp" style="width: 70%;">
            <thead>
                <tr>
                    <th>Imię</th>
                    <th>Nazwisko</th>
                    <th>Notatka</th>
                </tr>
            </thead>
            <tbody>
                ${lroom.htmlTableRows2}
            </tbody>
        </table>
            
        <button onclick="window.location = 'App?op=add';" class="mdl-button mdl-js-button mdl-button--raised" style="margin-top: 20px;">
            Dodaj notatkę
        </button>
    </div>
</header>



<%-- <%@ include file="/WEB-INF/jspf/HtmlFooterPart1.jspf" %> --%>
<%@ include file="/WEB-INF/jspf/HtmlFooterPart2.jspf" %>