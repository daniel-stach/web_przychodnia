<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/jspf/JspHeader.jspf" %>

<%@ include file="/WEB-INF/jspf/HtmlHeader.jspf" %>
<%@ include file="/WEB-INF/jspf/HtmlMenu.jspf" %>



<script>
    var active = 0;
    $('.mdl-navigation').eq(0).children().eq(active).addClass('active');
    $('.mdl-navigation').eq(1).children().eq(active).addClass('active');
</script>
<style>
    .mdl-layout__content {
        display: initial !important; // for full height header
    }
</style>
<header class="header-home">
    <div class="mdl-typography--text-center">
        <div class="slogan">Leczenie to nasza pasja!</div>
        <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" style="margin-top: 50px; background-color: #03A9F4; color: White;" onclick="location.href = '#goto'">
            O nas
        </button>
        <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" style="margin-top: 50px; background-color: #F44336; color: White;" onclick="location.href = 'rejestracja.jsp'">
            Umów się do lekarza
        </button>
    </div>
    <a href="#goto">
        <button class="fab mdl-button mdl-button--colored mdl-js-button mdl-button--fab mdl-js-ripple-effect">
            <i class="icon-expand_more"></i>
        </button>
    </a>
</header>
<div class="more-section">
    <a name="goto"></a>
    <div class="section-title mdl-typography--display-1-color-contrast">O przychodni</div>
    <div class="card-container mdl-grid">
        <div class="mdl-cell mdl-cell--3-col mdl-cell--4-col-tablet mdl-cell--4-col-phone mdl-card mdl-shadow--3dp">
            <div class="mdl-card__media">
                <img src="img/o/2.jpg">
            </div>
            <div class="mdl-card__title">
                <h4 class="mdl-card__title-text">Twoje zdrowie jest dla nas najważniejsze</h4>
            </div>
        </div>
        <div class="mdl-cell mdl-cell--3-col mdl-cell--4-col-tablet mdl-cell--4-col-phone mdl-card mdl-shadow--3dp">
            <div class="mdl-card__media">
                <img src="img/o/3.jpg">
            </div>
            <div class="mdl-card__title">
                <h4 class="mdl-card__title-text">U nas pracują renomowani specjaliści</h4>
            </div>
        </div>
        <div class="mdl-cell mdl-cell--3-col mdl-cell--4-col-tablet mdl-cell--4-col-phone mdl-card mdl-shadow--3dp">
            <div class="mdl-card__media">
                <img src="img/o/4.jpg">
            </div>
            <div class="mdl-card__title">
                <h4 class="mdl-card__title-text">Używamy najnowszych technologii</h4>
            </div>
        </div>
        <div class="mdl-cell mdl-cell--3-col mdl-cell--4-col-tablet mdl-cell--4-col-phone mdl-card mdl-shadow--3dp">
            <div class="mdl-card__media">
                <img src="img/o/1.jpg">
            </div>
            <div class="mdl-card__title">
                <h4 class="mdl-card__title-text">Cenimy Twój czas</h4>
            </div>
        </div>
    </div>
    <div class="mdl-typography--text-center">
        <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" style="margin-top: 50px; background-color: #F44336; color: White;" onclick="location.href = 'rejestracja.jsp'">
            Umów się do lekarza
        </button>
    </div>
</div>



<%@ include file="/WEB-INF/jspf/HtmlFooterPart1.jspf" %>
<%@ include file="/WEB-INF/jspf/HtmlFooterPart2.jspf" %>