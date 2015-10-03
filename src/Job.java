

import java.util.*;

import com.jaunt.*;


/**
 * Hackference
 * @author samtebbs, 17:17:14 - 3 Oct 2015
 */
public class Job {
    
    public static HashSet<Job> jobs = new HashSet<Job>();
    private static boolean jobsListChanged = false;
    public String title, company, wage, time, link, email;
    public Location location;

    public Job(String title, String company, String wage, String time, Location location, String link, String email) {
	this.title = title;
	this.company = company;
	this.wage = wage;
	this.time = time;
	this.location = location;
	this.link = link;
	this.email = email;
    }
    
    @Override
    public String toString() {
        return title + " for " + company + " " + time + " in " + location + (!wage.isEmpty() ? (" for " + wage) : "");
    }
    
    public static boolean listChanged(){
	if(!jobsListChanged) return false;
	jobsListChanged = false;
	return true;
    }

    public static void findJobs(String jobTitle, String place) throws ResponseException, NotFound {
	String query = "https://api.import.io/store/data/d321f0fc-9c00-458d-9f40-d8012f677cf1/_query?input/webpage/url=http%3A%2F%2Fwww.indeed.co.uk%2F" + jobTitle + "-jobs-in-" + place + "&_user=1698e35a-1ac8-4ef5-b5f5-50d0cebf2239&_apikey=1698e35a1ac84ef5b5f550d0cebf2239468da45929256c2eacd52fe0a3547befa4d4459b72516921575396f8c7c4773c68f09c2aadf3a436a3364be53f66f2e0650dfb16595765bea882bfcc5587bfec";
	Test.agent.sendGET(query);
	JNode results = Test.agent.json.get("results");
	for(JNode result : results){
	    JNode title = result.get("turnstilelink_link_1\\/_title");
	    JNode company = result.get("company_value");
	    JNode time = result.get("resultlinktext_value");
	    JNode location = result.get("location_value");
	    JNode wage = null;
	    JNode link = result.get("turnstilelink_link_1");
	    JNode email = result.get("email_link");
	    try{
		wage = result.get("snip_value");
	    }catch(NotFound e){
	    }
	    Job job = new Job(title.toString(), company.toString(), wage != null ? wage.toString() : "", time.toString(), new Location(location.toString()), link.toString(), email.toString());
	    System.out.println(job);
	    if(!jobs.contains(job)){
		jobs.add(job);
		jobsListChanged = true;
	    }
	}
    }
    
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((company == null) ? 0 : company.hashCode());
	result = prime * result + ((location == null) ? 0 : location.hashCode());
	result = prime * result + ((time == null) ? 0 : time.hashCode());
	result = prime * result + ((title == null) ? 0 : title.hashCode());
	result = prime * result + ((wage == null) ? 0 : wage.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) return true;
	if (obj == null) return false;
	if (getClass() != obj.getClass()) return false;
	Job other = (Job) obj;
	if (company == null) {
	    if (other.company != null) return false;
	} else if (!company.equals(other.company)) return false;
	if (location == null) {
	    if (other.location != null) return false;
	} else if (!location.equals(other.location)) return false;
	if (time == null) {
	    if (other.time != null) return false;
	} else if (!time.equals(other.time)) return false;
	if (title == null) {
	    if (other.title != null) return false;
	} else if (!title.equals(other.title)) return false;
	if (wage == null) {
	    if (other.wage != null) return false;
	} else if (!wage.equals(other.wage)) return false;
	return true;
    }

}