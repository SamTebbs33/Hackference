
/**
 * Hackference
 * @author samtebbs, 17:17:14 - 3 Oct 2015
 */
public class Job {
    
    public String title, company, wage, time;
    public Location location;

    public Job(String title, String company, String wage, String time, Location location) {
	this.title = title;
	this.company = company;
	this.wage = wage;
	this.time = time;
	this.location = location;
    }
    
    @Override
    public String toString() {
        return title + " for " + company + " " + time + " in " + location + (!wage.isEmpty() ? (" for " + wage) : "");
    }

}