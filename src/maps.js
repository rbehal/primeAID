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
    var image = './media/hospital_icon.png'
    var image2 = './media/walkin_icon.png'
  
    
      var infowindow = new google.maps.InfoWindow({
          content: 'Clinique Medicale Du Sud-Ouest<br>Current Patients: 33<br>Average Wait Time: 1.5 hours<br>Doctors Available: 3 <br> <br> &emsp; &emsp; &emsp; <button type="submit" class="btn btn-primary">Register</button>'
        }); 
  
      var marker = new google.maps.Marker({
      position: new google.maps.LatLng(45.460076, -73.576396),
      map: map,
      icon: image2
      
      });
  
      marker.addListener('click', function() {
          infowindow.open(map, marker);
  
        });
  
        var infowindow1 = new google.maps.InfoWindow({
          content: 'CLINIQUE MÉDICALE PLATEAU MONT-ROYAL<br>Current Patients: 33<br>Average Wait Time: 1.5 hours<br>Doctors Available: 3 <br> <br> &emsp; &emsp; &emsp; <button type="submit" class="btn btn-primary">Register</button>'
        });
      
      var marker1 = new google.maps.Marker({
      position: new google.maps.LatLng(45.530458, -73.576428),
      map: map,
      icon: image2
      });
  
      marker1.addListener('click', function() {
          infowindow1.open(map, marker1);
        });
  
  
      var infowindow2 = new google.maps.InfoWindow({
          content: 'MÉDICO-CENTRE MONT-ROYAL - CLINIQUE DU VOYAGEUR<br>Current Patients: 33<br>Average Wait Time: 1.5 hours<br>Doctors Available: 3 <br> <br> &emsp; &emsp; &emsp; <button type="submit" class="btn btn-primary">Register</button>'
        });
      
      var marker2 = new google.maps.Marker({
          position: new google.maps.LatLng(45.53426, -73.576691),
          map: map,
          icon: image2
      });
  
      marker2.addListener('click', function() {
          infowindow2.open(map, marker2);
        });
  
  
      var infowindow3 = new google.maps.InfoWindow({
          content: 'CLINIQUE MÉDICALE DE LA CITÉ<br>Current Patients: 33<br>Average Wait Time: 1.5 hours<br>Doctors Available: 3<br> <br> &emsp; &emsp; &emsp; <button type="submit" class="btn btn-primary">Register</button>'
        });
  
      var marker3 = new google.maps.Marker({
          position: new google.maps.LatLng(45.488869, -73.586067),
          map: map,
          icon: image2
          
      });
  
      marker3.addListener('click', function() {
          infowindow3.open(map, marker3);
        });
  
      
      var infowindow4 = new google.maps.InfoWindow({
          content: 'GROUPE SANTÉ WESTMOUNT SQUARE<br>Current Patients: 33<br>Average Wait Time: 1.5 hours<br>Doctors Available: 3<br> <br> &emsp; &emsp; &emsp; <button type="submit" class="btn btn-primary">Register</button>'
        });
      var marker4 = new google.maps.Marker({
          position: new google.maps.LatLng(45.486860, -73.588640),
          map: map,
          icon: image2
  
      });
  
      marker4.addListener('click', function() {
          infowindow4.open(map, marker4);
        });
  
  
      var infowindow5 = new google.maps.InfoWindow({
          content: 'CLINIQUE SANS RENDEZ-VOUS HERZL<br>Current Patients: 33<br>Average Wait Time: 1.5 hours<br>Doctors Available: 3<br> <br> &emsp; &emsp; &emsp; <button type="submit" class="btn btn-primary">Register</button>'
        });
      var marker5 = new google.maps.Marker({
          position: new google.maps.LatLng(45.499480, -73.630020),
          map: map,
          icon: image2
          
      });
  
      marker5.addListener('click', function() {
          infowindow5.open(map, marker5);
        });
  
        var infowindow6 = new google.maps.InfoWindow({
          content: 'CLINIQUE MÉDICALE MÉTROMÉDIC CENTRE-VILLE<br>Current Patients: 33<br>Average Wait Time: 1.5 hours<br>Doctors Available: 3<br> <br> &emsp; &emsp; &emsp; <button type="submit" class="btn btn-primary">Register</button>'
        });
  
      var marker6 = new google.maps.Marker({
          position: new google.maps.LatLng(45.500420, -73.577980),
          map: map,
          icon: image2
          
      });
  
      marker6.addListener('click', function() {
          infowindow6.open(map, marker6);
        });
  
  
        var infowindow7 = new google.maps.InfoWindow({
          content: 'CENTRE MÉDICALE QUEEN ÉLIZABETH URGENT CARE<br>Current Patients: 33<br>Average Wait Time: 1.5 hours<br>Doctors Available: 3<br> <br> &emsp; &emsp; &emsp; <button type="submit" class="btn btn-primary">Register</button>'
        });
      var marker7 = new google.maps.Marker({
          position: new google.maps.LatLng(45.474480, -73.606800),
          map: map,
          icon: image2
          
      });
      marker7.addListener('click', function() {
          infowindow7.open(map, marker7);
        });
  
  
        var infowindow8 = new google.maps.InfoWindow({
          content: 'CLINIQUE MÉDICALE 1851<br>Current Patients: 33<br>Average Wait Time: 1.5 hours<br>Doctors Available: 3<br> <br> &emsp; &emsp; &emsp; <button type="submit" class="btn btn-primary">Register</button>'
        });
  
      var marker8 = new google.maps.Marker({
          position: new google.maps.LatLng(45.528880, -73.564070),
          map: map,
          icon: image2
          
      });
  
      marker8.addListener('click', function() {
          infowindow8.open(map, marker8);
        });
  
        
      var infowindow9 = new google.maps.InfoWindow({
          content: 'Montreal General Hospital<br>Current Patients: 33<br>Average Wait Time: 1.5 hours<br>Doctors Available: 3<br> <br> &emsp; &emsp; &emsp; <button type="submit" class="btn btn-primary">Register</button>'
        });
  
      var marker9 = new google.maps.Marker({
          position: new google.maps.LatLng(45.496985, -73.588799),
          map: map,
          icon: image
          
      });
  
      marker9.addListener('click', function() {
          infowindow9.open(map, marker9);
        });
  
      
        var infowindow10 = new google.maps.InfoWindow({
          content: 'Jewish General Hospital<br>Current Patients: 33<br>Average Wait Time: 1.5 hours<br>Doctors Available: 3<br> <br> &emsp; &emsp; &emsp; <button type="submit" class="btn btn-primary">Register</button>'
        });
  
      var marker10 = new google.maps.Marker({
          position: new google.maps.LatLng(45.49696, -73.630211),
          map: map,
          icon: image
          
      }); 
  
      marker10.addListener('click', function() {
          infowindow10.open(map, marker10);
        });
  
  
        var infowindow11 = new google.maps.InfoWindow({
          content: 'McGill University Health Centre<br>Current Patients: 33<br>Average Wait Time: 1.5 hours<br>Doctors Available: 3<br> <br> &emsp; &emsp; &emsp; <button type="submit" class="btn btn-primary">Register</button>'
        });
  
      var marker11 = new google.maps.Marker({
          position: new google.maps.LatLng(45.472852, -73.600969),
          map: map,
          icon: image
          
      }); 
  
      marker11.addListener('click', function() {
          infowindow11.open(map, marker11);
        });
  
        var infowindow12 = new google.maps.InfoWindow({
          content: 'St. Marys Hospital<br>Current Patients: 33<br>Average Wait Time: 1.5 hours<br>Doctors Available: 3<br> <br> &emsp; &emsp; &emsp; <button type="submit" class="btn btn-primary">Register</button>'
        });
  
      var marker12 = new google.maps.Marker({
          position: new google.maps.LatLng(45.494896, -73.623838),
          map: map,
          icon: image
          
      }); 
  
      marker12.addListener('click', function() {
          infowindow12.open(map, marker12);
        });
  
  
        var infowindow13 = new google.maps.InfoWindow({
          content: 'Shriners Hospital for Children Canada<br>Current Patients: 33<br>Average Wait Time: 1.5 hours<br>Doctors Available: 3<br> <br> &emsp; &emsp; &emsp; <button type="submit" class="btn btn-primary">Register</button>'
        });
  
  
      var marker13 = new google.maps.Marker({
          position: new google.maps.LatLng(45.471813, -73.601811),
          map: map,
          icon: image
          
      }); 
  
      marker13.addListener('click', function() {
          infowindow13.open(map, marker13);
        });
  
      
        var infowindow14 = new google.maps.InfoWindow({
          content: 'CHUM<br>Current Patients: 33<br>Average Wait Time: 1.5 hours<br>Doctors Available: 3<br> <br> &emsp; &emsp; &emsp; <button type="submit" class="btn btn-primary">Register</button>'
        });
  
      var marker14 = new google.maps.Marker({
          position: new google.maps.LatLng(45.511197, -73.557284),
          map: map,
          icon: image
          
      }); 
  
      marker14.addListener('click', function() {
          infowindow14.open(map, marker14);
        });
  
        var infowindow15 = new google.maps.InfoWindow({
          content: 'Santa Cabrini Hospital<br>Current Patients: 33<br>Average Wait Time: 1.5 hours<br>Doctors Available: 3<br> <br> &emsp; &emsp; &emsp; <button type="submit" class="btn btn-primary">Register</button>'
        });
  
      var marker15 = new google.maps.Marker({
          position: new google.maps.LatLng(45.579533, -73.571416),
          map: map,
          icon: image
          
      }); 
  
      marker15.addListener('click', function() {
          infowindow15.open(map, marker15);
        });
  
        var infowindow16 = new google.maps.InfoWindow({
          content: 'Jean Talon Hospital<br>Current Patients: 33<br>Average Wait Time: 1.5 hours<br>Doctors Available: 3<br> <br> &emsp; &emsp; &emsp; <button type="submit" class="btn btn-primary">Register</button>'
        });
  
      var marker16 = new google.maps.Marker({
          position: new google.maps.LatLng(45.545725, -73.609308),
          map: map,
          icon: image
          
      }); 
  
      marker16.addListener('click', function() {
          infowindow16.open(map, marker16);
        });
  
  
        var infowindow17 = new google.maps.InfoWindow({
          content: 'Fleury Hospital<br>Current Patients: 33<br>Average Wait Time: 1.5 hours<br>Doctors Available: 3<br> <br> &emsp; &emsp; &emsp; <button type="submit" class="btn btn-primary">Register</button>'
        });
  
      var marker17 = new google.maps.Marker({
          position: new google.maps.LatLng(45.571887, -73.649903),
          map: map,
          icon: image
          
      }); 
     
      marker17.addListener('click', function() {
          infowindow17.open(map, marker17);
        });
  
        var infowindow18 = new google.maps.InfoWindow({
          content: 'Hopital du Sacre-Coeur de Montreal<br>Current Patients: 33<br>Average Wait Time: 1.5 hours<br>Doctors Available: 3<br><br> <br> &emsp; &emsp; &emsp; <button type="submit" class="btn btn-primary">Register</button>'
        });
  
  
      var marker18 = new google.maps.Marker({
          position: new google.maps.LatLng(45.532519, -73.714105),
          map: map,
          icon: image
          
      }); 
  
      marker18.addListener('click', function() {
          infowindow18.open(map, marker18);
        });
  
        var infowindow19 = new google.maps.InfoWindow({
          content: 'Lachine Hospital<br>Current Patients: 33<br>Average Wait Time: 1.5 hours<br>Doctors Available: 3<br> <br> &emsp; &emsp; &emsp; <button type="submit" class="btn btn-primary">Register</button>'
        });
  
      var marker19 = new google.maps.Marker({
          position: new google.maps.LatLng(45.441159, -73.677073),
          map: map,
          icon: image
          
      }); 
      marker19.addListener('click', function() {
          infowindow19.open(map, marker19);
        }); 
  
        var infowindow20 = new google.maps.InfoWindow({
          content: 'CHU Sainte-Justine<br>Current Patients: 33<br>Average Wait Time: 1.5 hours<br>Doctors Available: 3<br> <br> &emsp; &emsp; &emsp; <button type="submit" class="btn btn-primary">Register</button>'
        });
  
      var marker20 = new google.maps.Marker({
          position: new google.maps.LatLng(45.503219, -73.623916),
          map: map,
          icon: image       
      }); 
      marker20.addListener('click', function() {
          infowindow20.open(map, marker20);
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