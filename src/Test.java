

import com.jaunt.*;

/**
 * Hackference
 * @author samtebbs, 16:28:09 - 3 Oct 2015
 */
public class Test {
    
    public static UserAgent agent = new UserAgent();
    public static String jobTitle, place;

    public static void main(String[] args) throws ResponseException, NotFound {
	jobTitle = args[0];
	place = args[1];
	Job.findJobs(jobTitle, place);
    }

}
