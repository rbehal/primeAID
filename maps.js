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
    position: new google.maps.LatLng(45.460076, -73.576396),
    map: map,
    label: "CLINIQUE MÉDICALE DU SUD-OUEST"
    });
    var marker1 = new google.maps.Marker({
    position: new google.maps.LatLng(45.530458, -73.576428),
    map: map,
    label: "CLINIQUE MÉDICALE PLATEAU MONT-ROYAL"
    });
    var marker2 = new google.maps.Marker({
        position: new google.maps.LatLng(45.53426, -73.576691),
        map: map,
        label: "MÉDICO-CENTRE MONT-ROYAL - CLINIQUE DU VOYAGEUR"
    });
    var marker3 = new google.maps.Marker({
        position: new google.maps.LatLng(45.488869, -73.586067),
        map: map,
        label: "CLINIQUE MÉDICALE DE LA CITÉ"
        
    });

    var marker4 = new google.maps.Marker({
        position: new google.maps.LatLng(45.486860, -73.588640),
        map: map,
        label: "GROUPE SANTÉ WESTMOUNT SQUARE"
        
    });

    var marker5 = new google.maps.Marker({
        position: new google.maps.LatLng(45.499480, -73.630020),
        map: map,
        label: "CLINIQUE SANS RENDEZ-VOUS HERZL"
        
    });

    var marker6 = new google.maps.Marker({
        position: new google.maps.LatLng(45.500420, -73.577980),
        map: map,
        label: "CLINIQUE MÉDICALE MÉTROMÉDIC CENTRE-VILLE"
        
    });

    var marker7 = new google.maps.Marker({
        position: new google.maps.LatLng(45.474480, -73.606800),
        map: map,
        label: "CENTRE MÉDICALE QUEEN ÉLIZABETH URGENT CARE"
        
    });

    var marker8 = new google.maps.Marker({
        position: new google.maps.LatLng(45.528880, -73.564070),
        map: map,
        label: "CLINIQUE MÉDICALE 1851"
        
    });

    var marker9 = new google.maps.Marker({
        position: new google.maps.LatLng(45.496985, -73.588799),
        map: map,
        label: "Montreal General Hospital"
        
    });

    var marker10 = new google.maps.Marker({
        position: new google.maps.LatLng(45.49696, -73.630211),
        map: map,
        label: "Jewish General Hospital"
        
    }); 

    var marker11 = new google.maps.Marker({
        position: new google.maps.LatLng(45.472852, -73.600969),
        map: map,
        label: "McGill University Health Centre"
        
    }); 

    var marker12 = new google.maps.Marker({
        position: new google.maps.LatLng(45.494896, -73.623838),
        map: map,
        label: "St. Mary's Hospital"
        
    }); 

    var marker13 = new google.maps.Marker({
        position: new google.maps.LatLng(45.471813, -73.601811),
        map: map,
        label: "Shriners Hospital for Children Canada"
        
    }); 

    var marker14 = new google.maps.Marker({
        position: new google.maps.LatLng(45.511197, -73.557284),
        map: map,
        label: "CHUM"
        
    }); 

    var marker15 = new google.maps.Marker({
        position: new google.maps.LatLng(45.579533, -73.571416),
        map: map,
        label: "Santa Cabrini Hospital"
        
    }); 

    var marker16 = new google.maps.Marker({
        position: new google.maps.LatLng(45.545725, -73.609308),
        map: map,
        label: "Jean Talon Hospital"
        
    }); 

    var marker17 = new google.maps.Marker({
        position: new google.maps.LatLng(45.571887, -73.649903),
        map: map,
        label: "Fleury Hospital"
        
    }); 

    var marker18 = new google.maps.Marker({
        position: new google.maps.LatLng(45.532519, -73.714105),
        map: map,
        label: "Hopital du Sacre-Coeur de Montreal"
        
    }); 

    var marker19 = new google.maps.Marker({
        position: new google.maps.LatLng(45.441159, -73.677073),
        map: map,
        label: "Lachine Hospital"
        
    }); 

    var marker20 = new google.maps.Marker({
        position: new google.maps.LatLng(45.503219, -73.623916),
        map: map,
        label: {text: "CHU Sainte-Justine", color: "white"}

        
    }); 
}

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

// CLINIQUE MÉDICALE DU SUD-OUEST 45.460076, -73.576396
// CLINIQUE MÉDICALE PLATEAU MONT-ROYAL 45.530458, -73.576428
// MÉDICO-CENTRE MONT-ROYAL - CLINIQUE DU VOYAGEUR 45.53426, -73.576691
// CLINIQUE MÉDICALE DE LA CITÉ: 45.488869, -73.586067
// GROUPE SANTÉ WESTMOUNT SQUARE: 45.486860, -73.588640
// CLINIQUE SANS RENDEZ-VOUS HERZL: 45.499480, -73.630020
// CLINIQUE MÉDICALE MÉTROMÉDIC CENTRE-VILLE, 45.500420, -73.577980
// CENTRE MÉDICALE QUEEN ÉLIZABETH URGENT CARE, 45.474480, -73.606800
// CLINIQUE MÉDICALE 1851, 45.528880, -73.564070