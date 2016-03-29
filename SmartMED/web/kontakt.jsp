<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/jspf/JspHeader.jspf" %>

<%@ include file="/WEB-INF/jspf/HtmlHeader.jspf" %>
<%@ include file="/WEB-INF/jspf/HtmlMenu.jspf" %>



<script>
var active = 3;
$('.mdl-navigation').eq(0).children().eq(active).addClass('active');
$('.mdl-navigation').eq(1).children().eq(active).addClass('active');
</script>
<style>
#map {
    width: auto;
    /*500px;*/
    height: 500px;
    overflow: hidden;
    max-width: none;
    /*background-color: #CCC;*/
}

#map img {
    max-width: none !important;
    max-height: none !important;
}
</style>
<script>
$(function() {
    $('.map-tab').click(function() {
        initMap();
    })
});

function initMap() {
    var mapCanvas = document.getElementById('map');
    var myLatLng = {
        lat: -25.363,
        lng: 131.044
    };
    var mapOptions = {
        center: myLatLng,
        zoom: 4
    }
    var marker = new google.maps.Marker({
        position: myLatLng,
        map: map,
        title: 'Hello World!'
    });

    var map = new google.maps.Map(mapCanvas, mapOptions);
    setTimeout(function() {
        google.maps.event.trigger(map, 'resize');
        map.setCenter(mapOptions.center);
    }, 500);
}
</script>
<script src="https://maps.googleapis.com/maps/api/js?callback=initMap" async defer></script>
<div class="more-section">
    <div class="section-title mdl-typography--display-1-color-contrast">Kontakt</div>
    <div class="card-container mdl-grid">
        <div class="mdl-cell mdl-cell--3-col mdl-cell--4-col-tablet mdl-cell--12-col-phone  mdl-card mdl-shadow--4dp">
            <div class="mdl-card__title">
                <h2 class="mdl-card__title-text">Adres</h2>
            </div>
            <div class="mdl-card__supporting-text">
                ul. Klonowa 11
                <br>50-001 Wrocław
            </div>
            <div class="mdl-card__title">
                <h2 class="mdl-card__title-text">Telefon</h2>
            </div>
            <div class="mdl-card__supporting-text no-left-padding">
                598 724 165
            </div>
            <div class="mdl-card__title">
                <h2 class="mdl-card__title-text">Email</h2>
            </div>
            <div class="mdl-card__supporting-text no-left-padding">
                lorem@ipsum.com
            </div>
        </div>
        <div class="mdl-cell mdl-cell--9-col mdl-cell--8-col-tablet mdl-cell--12-col-phone  mdl-card mdl-shadow--4dp">
            <div id="map"></div>
        </div>
    </div>
</div>




<%-- <%@ include file="/WEB-INF/jspf/HtmlFooterPart1.jspf" %> --%>
<%@ include file="/WEB-INF/jspf/HtmlFooterPart2.jspf" %>