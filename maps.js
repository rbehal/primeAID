var map;
function initMap() {
    var myLatlng = new google.maps.LatLng(45.501690,-73.567253);
    var mapOptions = {
        zoom: 16,
        center: myLatlng,
        mapTypeId: 'satellite'
    };
    var map = new google.maps.Map(document.getElementById('map'),
    mapOptions);
}