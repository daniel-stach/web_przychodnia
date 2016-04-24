<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/jspf/JspHeader.jspf" %>

<%@ include file="/WEB-INF/jspf/HtmlHeader.jspf" %>
<%@ include file="/WEB-INF/jspf/HtmlMenu.jspf" %>



<header>
    <div class="more-section" style="max-width: 1600px;">
        <div class="section-title mdl-typography--display-1-color-contrast">Tabela umówionych wizyt</div>
        <table class="mdl-data-table mdl-js-data-table mdl-data-table--selectable mdl-shadow--2dp" style="width: 100%;">
            <thead>
                <tr>
                    <th>Lekarz</th>
                    <th>Termin przyjęcia</th>
                    <th>Pacjent</th>
                    <th>Email</th>
                    <th>PESEL</th>
                    <th>Nr telefonu</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                ${reception.htmlTableRows}
            </tbody>
        </table>
        <button class="mdl-button mdl-js-button mdl-button--raised" style="margin-top: 20px;">
            Dodaj wizytę
        </button>

        <div style="margin-top: 50px;" class="section-title mdl-typography--display-1-color-contrast">Tabela zaplanowanych wizyt</div>
        <table class="mdl-data-table mdl-js-data-table mdl-data-table--selectable mdl-shadow--2dp" style="width: 100%;">
            <thead>
                <tr>
                    <th>Lekarz</th>
                    <th>Termin przyjęcia</th>
                    <th>Pacjent</th>
                    <th>Email</th>
                    <th>PESEL</th>
                    <th>Nr telefonu</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                ${reception.htmlTableRows2}
            </tbody>
        </table>
        <button class="mdl-button mdl-js-button mdl-button--raised" style="margin-top: 20px;">
            Dodaj wizytę
        </button>
    </div>
</header>




<%-- <%@ include file="/WEB-INF/jspf/HtmlFooterPart1.jspf" %> --%>
<%@ include file="/WEB-INF/jspf/HtmlFooterPart2.jspf" %>