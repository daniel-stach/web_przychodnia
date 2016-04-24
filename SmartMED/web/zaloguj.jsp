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
        <div style="padding-top: 100px; margin: 0 auto; text-align: center;" class="card-container mdl-grid">
            <div class="mdl-cell mdl-cell--4-col mdl-cell--4-col-tablet mdl-cell--12-col-phone mdl-card mdl-shadow--4dp" style="margin-left: 35%;">
                <div class="mdl-card__title mdl-color--indigo mdl-color-text--white">
                    <h2 class="mdl-card__title-text" style="color: White;">Logowanie</h2>
                </div>
                <form name="loginForm" onsubmit="return ValidateForm()" method="post" action="App">
                    <div class="mdl-card__supporting-text">
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                            <input class="mdl-textfield__input" type="text" pattern="[A-Z,a-z,0-9].{2,}" id="login" name="login">
                            <label class="mdl-textfield__label" for="login">Login</label>
                            <span class="mdl-textfield__error">Tylko znaki alfabetu, cyfry, bez spacji i minimum 3 znaki</span>
                        </div>
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                            <input class="mdl-textfield__input" type="password" pattern="[A-Z,a-z,0-9].{7,}" id="haslo" name="haslo">
                            <label class="mdl-textfield__label" for="haslo">Hasło</label>
                            <span class="mdl-textfield__error">Tylko znaki alfabetu, cyfry, bez spacji i minimum 8 znaków</span>
                        </div>
                    </div>
                    <div class="mdl-card__actions">
                        <button type="submit" name="op" value="execute-login" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" style="float: right;">Zaloguj</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</header>
<script>
    function ValidateForm()
    {
        var result = true;

        var firstname = document.forms["loginForm"]["login"].value;
        if (firstname === null || firstname === "") {
            result = false;
        }

        var surname = document.forms["loginForm"]["haslo"].value;
        if (surname === null || surname === "") {
            result = false;
        }

        return result;
    }
</script>




<%-- <%@ include file="/WEB-INF/jspf/HtmlFooterPart1.jspf" %> --%>
<%@ include file="/WEB-INF/jspf/HtmlFooterPart2.jspf" %>