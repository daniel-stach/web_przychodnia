<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/JspHeader.jspf" %>

<%@ include file="/WEB-INF/jspf/HtmlHeader.jspf" %>
<%@ include file="/WEB-INF/jspf/HtmlMenu.jspf" %>


<header class="header-register">
    <div class="more-section">
        <div style="padding-top: 100px; margin: 0 auto; text-align: center;" class="card-container mdl-grid">
            <div class="mdl-cell mdl-cell--5-col mdl-cell--5-col-tablet mdl-cell--12-col-phone mdl-card mdl-shadow--4dp" style="margin-left: 25%;">
                <div class="mdl-card__title mdl-color--indigo mdl-color-text--white">
                    <h2 class="mdl-card__title-text" style="color: White;">Edytuj</h2>
                </div>
                <form name="editForm" method="post" action="App">

                    <div class="mdl-card__supporting-text">
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                            <input id="in0" class="mdl-textfield__input" type="text" pattern="[A-Z,a-z]*"  name="firstname">
                            <label class="mdl-textfield__label" for="firstname">Imię lekarza</label>
                            <span class="mdl-textfield__error">Tylko znaki alfabetu i bez spacji</span>
                        </div>
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                            <input id="in1" class="mdl-textfield__input" type="text" pattern="[A-Z,a-z]*"  name="surname">
                            <label class="mdl-textfield__label" for="surname">Nazwisko lekarza</label>
                            <span class="mdl-textfield__error">Tylko znaki alfabetu i bez spacji</span>
                        </div>
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                            <input id="in2" class="mdl-textfield__input" type="text" name="data">
                            <label class="mdl-textfield__label" for="data">Termin</label>
                        </div>
                        ${edit.inputs}
                    </div>

                    <input id="in8" type="hidden" name="id">

                    <div class="mdl-card__actions">

                        <button type="submit" name="op" value="execute-edit" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" style="float: right;">Aktualizuj dane</button>

                    </div>

                </form>
            </div>
        </div>
    </div>
</header>
<script>
    ${edit.html}
</script>




<%-- <%@ include file="/WEB-INF/jspf/HtmlFooterPart1.jspf" %> --%>
<%@ include file="/WEB-INF/jspf/HtmlFooterPart2.jspf" %>