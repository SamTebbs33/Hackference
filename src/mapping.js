// source: https://developers.arcgis.com/javascript/jsapi/map-amd.html
var map;

var moveMapTo;
var setBaseMap;

//var Point = require('esri/geometry/point');
require(["esri/map", "esri/geometry/Point","dojo/domReady!"], function(Map, Point) {
  map = new Map("map", {
    center: [-56.049, 38.485],
    zoom: 6,
    basemap: "streets"
  });

    moveMapTo = function(x, y){
        map.centerAt(new Point(x, y));
    }

    setBaseMap = function(basemap){
         map.setBaseMap(basemap);
    }

});
