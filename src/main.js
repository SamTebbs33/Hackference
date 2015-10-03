function search(){
    console.log("# search()")

    var form = document.job_search;
    var job_area = form.job_area.value;
    console.log("job area: " + job_area);

    var job_types = form.job_type;
    var job_type = job_types.options[job_types.selectedIndex].value;
    console.log("job type: " + job_type);

    var map_types = form.map_type;
    var base_map = map_types.options[map_types.selectedIndex].value;

    console.log("map type: " + base_map);
    setBaseMap(base_map);
    return false;
}
