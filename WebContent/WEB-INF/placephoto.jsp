<!DOCTYPE html>
<html>
  <head>
    <title>Panoramio Layer</title>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <style>
      html, body, #map-canvas {
        height: 100%;
        margin: 0px;
        padding: 0px
      }
      #panel {
        position: absolute;
        top: 5px;
        left: 50%;
        margin-left: -180px;
        z-index: 5;
        background-color: #fff;
        padding: 5px;
        border: 1px solid #999;
      }
#photo-panel {
  background: #fff;
  padding: 5px;
  overflow-y: auto;
  overflow-x: hidden;
  width: 300px;
  max-height: 300px;
  font-size: 14px;
  font-family: Arial;
  border: 1px solid #ccc;
  box-shadow: -2px 2px 2px rgba(33, 33, 33, 0.4);
  display: none;
}
    </style>
    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&signed_in=true&libraries=panoramio"></script>
    <script>
function initialize() {
  var mapOptions = {
    zoom: 11,
    center: new google.maps.LatLng(40.4404491,-79.9743207)
  };

  var map = new google.maps.Map(document.getElementById('map-canvas'),
      mapOptions);

  var panoramioLayer = new google.maps.panoramio.PanoramioLayer();
  panoramioLayer.setMap(map);

  var photoPanel = document.getElementById('photo-panel');
  map.controls[google.maps.ControlPosition.RIGHT_TOP].push(photoPanel);

  google.maps.event.addListener(panoramioLayer, 'click', function(photo) {
    var li = document.createElement('li');
    var link = document.createElement('a');
    link.innerHTML = photo.featureDetails.title + ': ' +
        photo.featureDetails.author;
    link.setAttribute('href', photo.featureDetails.url);
    li.appendChild(link);
    photoPanel.appendChild(li);
    photoPanel.style.display = 'block';
  });
}

google.maps.event.addDomListener(window, 'load', initialize);

    </script>
  </head>
  <body>
    <ul id="photo-panel">
      <li><strong>Photos clicked</strong></li>
    </ul>
    <div id="map-canvas"></div>
  </body>
</html>