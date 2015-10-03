

import com.jaunt.*;

/**
 * Hackference
 * @author samtebbs, 17:26:38 - 3 Oct 2015
 */
public class Location {
    
    public String location;
    public JobCoord coords;

    public Location(String location) throws NotFound, ResponseException {
	this.location = location;
	this.coords = getCoords();
    }
    
    private JobCoord getCoords() throws ResponseException, NotFound{
	Test.agent.sendGET("https://maps.googleapis.com/maps/api/geocode/json?address="+location);
	JNode json = Test.agent.json;
	JNode coords = null;
	try {
	    coords = json.get("results").get(0).get("geometry").get("location");
	} catch (NotFound e) {
	    e.printStackTrace();
	}
	return new JobCoord(coords.get("lat").toDouble(), coords.get("lng").toDouble());
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((location == null) ? 0 : location.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) return true;
	if (obj == null) return false;
	if (getClass() != obj.getClass()) return false;
	Location other = (Location) obj;
	if (location == null) {
	    if (other.location != null) return false;
	} else if (!location.equals(other.location)) return false;
	return true;
    }

    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append(location + "(");
	builder.append(coords);
	builder.append(")");
	return builder.toString();
    }

}
