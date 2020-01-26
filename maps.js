var lat;
var lng;
var map, infoWindow;
// Try HTML5 geolocation.
if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(function(position) {
    var pos = {
        lat: position.coords.latitude,
        lng: position.coords.longitude
    };

    infoWindow.setPosition(pos);
    infoWindow.setContent('Your current location');
    infoWindow.open(map);
    map.setCenter(pos);
    }, function() {
    handleLocationError(true, infoWindow, map.getCenter());
    });
} else {
    // Browser doesn't support Geolocation
    handleLocationError(false, infoWindow, map.getCenter());
}

function handleLocationError(browserHasGeolocation, infoWindow, pos) {
infoWindow.setPosition(pos);
infoWindow.setContent(browserHasGeolocation ?
                        'Error: The Geolocation service failed.' :
                        'Error: Your browser doesn\'t support geolocation.');
infoWindow.open(map);
}

function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
        center: {lat: lat, lng: lng},
        zoom: 18,
        mapTypeId: 'satellite'
    });
    infoWindow = new google.maps.InfoWindow;

    var marker = new google.maps.Marker({
    position: new google.maps.LatLng(45.494954, -73.577632),
    map: map
    });
    
}

// CLINIQUE MÉDICALE DU SUD-OUEST 45.460076, -73.576396
// CLINIQUE MÉDICALE PLATEAU MONT-ROYAL 45.530458, -73.576428
// MÉDICO-CENTRE MONT-ROYAL - CLINIQUE DU VOYAGEUR 45.53426, -73.576691
// CLINIQUE MÉDICALE DE LA CITÉ: 45.488869, -73.586067
// GROUPE SANTÉ WESTMOUNT SQUARE: 45.486860, -73.588640
// CLINIQUE SANS RENDEZ-VOUS HERZL: 45.499480, -73.630020
// CLINIQUE MÉDICALE MÉTROMÉDIC CENTRE-VILLE, 45.500420, -73.577980
// CENTRE MÉDICALE QUEEN ÉLIZABETH URGENT CARE, 45.474480, -73.606800
// CLINIQUE MÉDICALE 1851, 45.528880, -73.564070

// Montreal General Hospital: 45.496985, -73.588799
// Jewish General Hospital: 45.49696, -73, 630211
// McGill University Health Centre: 45.472852, -73.600969
// St. Mary's Hospital: 45.494896, -73.623838
// Shriners Hospital for Children Canada: 45.471813, -73.601811
// CHUM: 45.511197, -73.557284
// Santa Cabrini Hospital: 45.579533, -73.571416
// Jean Talon Hospital: 45.545725, -73.609308
// Fleury Hospital: 45.571887, -73.649903
// Hopital du Sacre-Coeur de Montreal: 45.532519, -73.714105
// Lachine Hospital: 45.441159, -73.677073
// CHU Sainte-Justine: 45.503219, -73.623916