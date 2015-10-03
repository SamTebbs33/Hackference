// source: https://developers.arcgis.com/javascript/jsapi/map-amd.html

require(["esri/map", "dojo/domReady!"], function(Map) {
  map = new Map("map", {
    center: [-56.049, 38.485],
    zoom: 3,
    basemap: "streets"
  });
});

function moveMapTo(x, y){
    map.centerAt(new Point(x, y));
}

function setBaseMap(basemap){
    map.setBaseMap(basemap);
}
