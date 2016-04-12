<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/jspf/JspHeader.jspf" %>

<%@ include file="/WEB-INF/jspf/HtmlHeader.jspf" %>
<%@ include file="/WEB-INF/jspf/HtmlMenu.jspf" %>



<header>
    <div class="more-section" style="max-width: 1600px;">
        <div class="section-title mdl-typography--display-1-color-contrast">Tabela wizyt pacjentów</div>
        <div class="card-container mdl-grid">
            <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp" style="width: 100%;">
                <thead>
                    <tr>
                        <th>Imię lekarza</th>
                        <th>Nazwisko lekarza</th>
                        <th>Termin przyjęcia</th>
                        <th>Imię pacjęta</th>
                        <th>Nazwisko pacjęta</th>
                        <th>PESEL</th>
                        <th>Nr telefonu</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>AAaa</td>
                        <td>AAaa</td>
                        <td>AAaa</td>
                        <td>AAaa</td>
                        <td>AAaa</td>
                        <td>99999999999</td>
                        <td>123456789</td>
                        <td>
                            <a href="#" class="mdl-button mdl-js-button mdl-button--raised">
                                    Edytuj
                                </a> &nbsp;
                            <a href="#" class="mdl-button mdl-js-button mdl-button--raised">
                                    Usuń
                                </a>
                        </td>
                    </tr>
                </tbody>
            </table>
            <button class="mdl-button mdl-js-button mdl-button--raised" style="margin-top: 20px;">
                Dodaj wizytę
            </button>
        </div>
    </div>
</header>




<%-- <%@ include file="/WEB-INF/jspf/HtmlFooterPart1.jspf" %> --%>
<%@ include file="/WEB-INF/jspf/HtmlFooterPart2.jspf" %>