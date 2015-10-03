function search(){
    console.log("# search()")
    var job_area = document.getElementById("job_area");

    var job_types = document.getElementById("job_type");
    var job_type = job_types.options[job_types.selectedIndex].value;

    var map_types = document.getElementById("map_type");
    var base_map = map_types.options[map_types.selectedIndex].value;

    console.log("job area: " + job_area);
    console.log("job type: " + job_type);
    console.log("map type: " + map_type);
    setBaseMap(map_type);
    return false;
}
