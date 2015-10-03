import com.jaunt.*;

/**
 * Hackference
 * @author samtebbs, 17:26:38 - 3 Oct 2015
 */
public class Location {
    
    public String location;

    public Location(String location) {
	this.location = location;
    }
    
    public JobCoord getCoords() throws ResponseException, NotFound{
	Test.agent.sendGET("https://maps.googleapis.com/maps/api/geocode/json?address="+location);
	//System.out.println(Test.agent.json);
	JNode json = Test.agent.json;
	JNode coords = null;
	try {
	    coords = json.get("results").get(0).get("geometry").get("location");
	} catch (NotFound e) {
	    e.printStackTrace();
	}
	return new JobCoord(coords.get("lat").toDouble(), coords.get("lng").toDouble());
    }

}
