import com.jaunt.*;

/**
 * Hackference
 * @author samtebbs, 16:28:09 - 3 Oct 2015
 */
public class Test {
    
    public static UserAgent agent = new UserAgent();

    public static void main(String[] args) throws ResponseException, NotFound {
	String jobTitle = args[0], place = args[1];
	String query = "https://api.import.io/store/data/d321f0fc-9c00-458d-9f40-d8012f677cf1/_query?input/webpage/url=http%3A%2F%2Fwww.indeed.co.uk%2F" + jobTitle + "-jobs-in-" + place + "&_user=1698e35a-1ac8-4ef5-b5f5-50d0cebf2239&_apikey=1698e35a1ac84ef5b5f550d0cebf2239468da45929256c2eacd52fe0a3547befa4d4459b72516921575396f8c7c4773c68f09c2aadf3a436a3364be53f66f2e0650dfb16595765bea882bfcc5587bfec";
	agent.sendGET(query);
	JNode results = agent.json.get("results");
	for(JNode result : results){
	    JNode title = result.get("turnstilelink_link_1\\/_title");
	    JNode company = result.get("company_value");
	    JNode time = result.get("resultlinktext_value");
	    JNode location = result.get("location_value");
	    JNode wage = null;
	    try{
		wage = result.get("snip_value");
	    }catch(NotFound e){
	    }
	    Job job = new Job(title.toString(), company.toString(), wage != null ? wage.toString() : "", time.toString(), new Location(location.toString()));
	    System.out.println(job);
	    JobCoord coord = job.location.getCoords();
	    System.out.println(coord);
	}
    }

}
