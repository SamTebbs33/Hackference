
/**
* Hackference
* @author samtebbs, 17:40:02 - 3 Oct 2015
*/
public class JobCoord {
    public double x, y;

    public JobCoord(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("JobCoord [x=");
	builder.append(x);
	builder.append(", y=");
	builder.append(y);
	builder.append("]");
	return builder.toString();
    }
   
}