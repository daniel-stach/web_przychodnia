<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/jspf/JspHeader.jspf" %>

<%@ include file="/WEB-INF/jspf/HtmlHeader.jspf" %>
<%@ include file="/WEB-INF/jspf/HtmlMenu.jspf" %>



<script>
    var active = 1;
    $('.mdl-navigation').eq(0).children().eq(active).addClass('active');
    $('.mdl-navigation').eq(1).children().eq(active).addClass('active');
</script>
<header class="header-register">
    <div class="more-section">
        <div class="section-title mdl-typography--display-1-color-contrast">Rejestracja</div>

        <form name="registerForm" onsubmit="return ValidateForm()" method="post" action="App">

            <div class="card-container mdl-grid">
                <div class="mdl-cell mdl-cell--8-col mdl-cell--8-col-tablet mdl-cell--12-col-phone mdl-card mdl-shadow--4dp">
                    <div class="mdl-card__title mdl-color--brown mdl-color-text--white">
                        <h2 class="mdl-card__title-text" style="color: White;">Wybierz termin</h2>
                    </div>
                    <ul class="dl-list" style="margin-left: -35px; overflow-y: scroll; height:400px;">

                        ${registration.htmlVisits}

                    </ul>
                </div>
                <div class="mdl-cell mdl-cell--4-col mdl-cell--4-col-tablet mdl-cell--12-col-phone mdl-card mdl-shadow--4dp">
                    <div class="mdl-card__title mdl-color--indigo mdl-color-text--white">
                        <h2 class="mdl-card__title-text" style="color: White;">Uzupełnij dane</h2>
                    </div>
                    <div class="mdl-card__supporting-text">
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                            <input class="mdl-textfield__input" type="text" pattern="[A-Z,a-z]*" id="firstname" name="firstname">
                            <label class="mdl-textfield__label" for="firstname">Imię</label>
                            <span class="mdl-textfield__error">Tylko znaki alfabetu i bez spacji</span>
                        </div>
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                            <input class="mdl-textfield__input" type="text" pattern="[A-Z,a-z]*" id="surname" name="surname">
                            <label class="mdl-textfield__label" for="surname">Nazwisko</label>
                            <span class="mdl-textfield__error">Tylko znaki alfabetu i bez spacji</span>
                        </div>
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                            <input class="mdl-textfield__input" type="email" id="email" name="email">
                            <label class="mdl-textfield__label" for="email">Email</label>
                            <span class="mdl-textfield__error">Niepoprawny adres email</span>
                        </div>
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                            <input class="mdl-textfield__input" type="text" pattern="[0-9]{11}" id="pesel" name="pesel">
                            <label class="mdl-textfield__label" for="pesel">Pesel</label>
                            <span class="mdl-textfield__error">Niepoprawny numer pesel</span>
                        </div>
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                            <input class="mdl-textfield__input" type="text" pattern="[0-9]{9}" id="phone" name="phone">
                            <label class="mdl-textfield__label" for="phone">Telefon</label>
                            <span class="mdl-textfield__error">Niepoprawny numer telefonu</span>
                        </div>
                        <label class="mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect" for="checkbox-2">
                            <input type="checkbox" id="checkbox-2" class="mdl-checkbox__input">
                            <span class="mdl-checkbox__label" style="font-size: 9px;">Wyrażam zgodę na przetwarzanie moich danych</span>
                        </label>
                    </div>
                    <div class="mdl-card__actions">

                        <button type="submit" name="op" value="execute-register" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" style="float: right;">Wyślij</button>

                    </div>
                </div>
            </div>

        </form>

    </div>
</header>
<script>
    function ValidateForm()
    {
        var result = true;

        var firstname = document.forms["registerForm"]["firstname"].value;
        if (firstname === null || firstname === "") {
            result = false;
        }

        var surname = document.forms["registerForm"]["surname"].value;
        if (surname === null || surname === "") {
            result = false;
        }

        var email = document.forms["registerForm"]["email"].value;
        if (email === null || email === "") {
            result = false;
        }

        var pesel = document.forms["registerForm"]["pesel"].value;
        if (pesel === null || pesel === "") {
            result = false;
        }

        var phone = document.forms["registerForm"]["phone"].value;
        if (phone === null || phone === "") {
            result = false;
        }

        if (!$('#checkbox-2').prop('checked')) {
            result = false;
        }

        return result;
    }
</script>




<%-- <%@ include file="/WEB-INF/jspf/HtmlFooterPart1.jspf" %> --%>
<%@ include file="/WEB-INF/jspf/HtmlFooterPart2.jspf" %>