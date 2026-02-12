package cnc_milling_simulator;

public class BaseCommand {
    private  Point startPoint;

    private  Point endPoint;

    protected   double FeedRate;

    public BaseCommand(Point startPoint, Point endPoint, double feedRate) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
       setFeedRate(feedRate);
    }

    public void setFeedRate(double feedRate) {
        if (feedRate <= 0) {
            throw new IllegalArgumentException("feedRate must be greater than 0");
        }
        FeedRate = feedRate;
    }

    protected Point getStartPoint() {
        return startPoint;
    }

    protected Point getEndPoint() {
        return endPoint;
    }

    protected double getFeedRate() {
        return FeedRate;
    }
}
