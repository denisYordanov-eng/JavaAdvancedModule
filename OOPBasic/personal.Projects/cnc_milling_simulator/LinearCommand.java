package cnc_milling_simulator;

public class LinearCommand extends BaseCommand {
    public LinearCommand(Point staringPoint, Point endPoint, double feedRate) {
        super(staringPoint, endPoint, feedRate);
    }

    //todo calculateDistance()
    //todo machiningTime()
    @Override
    public String toString() {
        return String.format("Milling from {%.2f, %.2f, %.2f} to {%.2f, %.2f, %.2f} with feedRate: %.2f"
                , getStartPoint().getX(), getStartPoint().getY(), getStartPoint().getZ()
        ,getEndPoint().getX(),getEndPoint().getY(), getEndPoint().getZ()
        ,getFeedRate());
    }
}
