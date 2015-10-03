// source: https://developers.arcgis.com/javascript/jsapi/map-amd.html
var map;
//var Point = require('esri/geometry/point');
require(["esri/map", "dojo/domReady!", "esri/geometry/Point"], function(Map, Point) {
  map = new Map("map", {
    center: [-56.049, 38.485],
    zoom: 3,
    basemap: "streets"
  });
  run();
});

function moveMapTo(x, y){
    map.centerAt(new Point(x, y));
}

function setBaseMap(basemap){
    map.setBaseMap(basemap);
}
