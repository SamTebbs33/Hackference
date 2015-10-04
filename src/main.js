// source: https://developers.arcgis.com/javascript/jsapi/map-amd.html
var map;
var jobs = [];
var moveMapTo;
var setBaseMap;

//var Point = require('esri/geometry/point');
require(["esri/map", "esri/geometry/Point", /*"esri/symbols/SimpleMarkerSymbol", "esri/Graphic",*/ "dojo/domReady!"], function(Map, Point/*, SimpleMarkerSymbol, Graphic*/) {
  map = new Map("map", {
    center: [-1.888082, 52.4770682],
    zoom: 7,
    basemap: "streets"
  });

    moveMapTo = function(x, y){
        map.centerAt(new Point(x, y));
    }

    setBaseMap = function(basemap){
         map.setBasemap(basemap);
    }

});

function sort(){
    var form = document.job_search
    var sort_types = form.sort_type;
    var sort_type = sort_types.options[sort_types.selectedIndex].value;

    switch (sort_type) {
        case "title":
            jobs.sort(function(a, b){
                if(a.title < b.title) return -1;
                else if(a.title > b.title) return 1;
                return 0;
            });
        case "company":
            jobs.sort(function(a, b){
                if(a.company < b.company) return -1;
                else if(a.company > b.company) return 1;
                return 0;
            });
            break;
        case "location":
            jobs.sort(function(a, b){
                if(a.location < b.location) return -1;
                else if(a.location > b.location) return 1;
                return 0;
            });
        default:
    }
    printJobs();
}

function printJobs(){
    var list = document.getElementById("job_list");
    list.innerHTML = "";
    for(var x = 0; x < jobs.length; x++){
        var job = jobs[x];
        list.innerHTML += "<p><li><b><a href=\"" + job.link + "\">" + job.title + "</a></b></li>";
        list.innerHTML += "\t<li><b>Company:</b> " + job.company + "</li>";
        list.innerHTML += "\t<li><b>Location:</b> " + job.location + "</li>";
        if(job.wage !== undefined) list.innerHTML += "\t<li><b>Wage:</b> " + job.wage + "</li></p>";
        else list.innerHTML += "</p>"
    }
}

function search(){
    document.getElementById("job_list").innerHTML = "";
    jobs = [];
    var form = document.job_search;

    var job_location = form.job_location.value;
    var job_field = form.job_field.value;

    changeBaseMap();

    var query = "https://api.import.io/store/data/d321f0fc-9c00-458d-9f40-d8012f677cf1/_query?input/webpage/url=http%3A%2F%2Fwww.indeed.co.uk%2F" + job_field + "-jobs-in-" + job_location + "&_user=1698e35a-1ac8-4ef5-b5f5-50d0cebf2239&_apikey=" + import_io_key;
    $.getJSON(query, function(){})
    .done(function(data){
        var results = data.results;
        for(var x = 0; x < results.length; x++){
            var job = results[x];
            var jobObj = {
                title: job["turnstilelink_link_1\/_title"],
                company: job.company_value,
                location: job.location_value,
                link: job.turnstilelink_link_1,
                wage: job.snip_value
            };
            jobs.push(jobObj);
        }
        console.log(jobs);
        printJobs();
    });

    query = "https://maps.googleapis.com/maps/api/geocode/json?address=" + job_location;
    $.getJSON(query, function(){})
    .done(function(data){
        var loc = data.results[0].geometry.location;
        moveMapTo(loc.lng, loc.lat);
    })

    return false;
}

function changeBaseMap(){
    var form = document.job_search;
    var map_types = form.map_type;
    var base_map = map_types.options[map_types.selectedIndex].value;
    setBaseMap(base_map);
    return false;
}
