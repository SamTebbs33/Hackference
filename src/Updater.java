import com.jaunt.*;


/**
 * Hackference
 * @author samtebbs, 17:47:49 - 3 Oct 2015
 */
public class Updater implements Runnable {
    
    public static long interval = 300000;

    @Override
    public void run() {
	long timePassed = 0;
	while(true){
	    if(timePassed >= interval){
		try {
		    update();
		} catch (NotFound | ResponseException e) {
		    e.printStackTrace();
		}
		timePassed = 0;
	    }else timePassed++;
	}
    }

    private void update() throws NotFound, ResponseException {
	Job.findJobs(Test.jobTitle, Test.place);
	if(Job.listChanged()){
	    // Send notification
	}
    }

}
