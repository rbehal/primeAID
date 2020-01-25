var map;
var latitude = 45.501690;
var longitude = -73.567253;
function initMap() {
    var myLatlng = new google.maps.LatLng(latitude,longitude);
    var mapOptions = {
        zoom: 16,
        center: myLatlng,
        mapTypeId: 'satellite'
    };
    var map = new google.maps.Map(document.getElementById('map'),
    mapOptions);
}