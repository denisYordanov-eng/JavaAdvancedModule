package cnc_milling_simulator;

public class LinearCommand extends BaseCommand {
    public LinearCommand(Point staringPoint, Point endPoint, double feedRate) {
        super(staringPoint, endPoint, feedRate);
    }


    private double calculateDistance(){
        double deltaX = getEndPoint().getX() - getStartPoint().getX();
        double deltaY = getEndPoint().getY() - getStartPoint().getY();
        double deltaZ = getEndPoint().getZ() - getStartPoint().getZ();

        double sumPow = Math.pow(deltaX,2) + Math.pow(deltaY,2) + Math.pow(deltaZ,2);

        return Math.sqrt(sumPow);
    }

    //todo machiningTime()

    @Override
    public String toString() {
        return String.format("Milling from {X:%.2f, Y:%.2f, Z:%.2f} to {X:%.2f, Y:%.2f, Z:%.2f} with feedRate: %.2f," +
                        " totalDistance: %.2f"
                , getStartPoint().getX(), getStartPoint().getY(), getStartPoint().getZ()
        ,getEndPoint().getX(),getEndPoint().getY(), getEndPoint().getZ()
        ,getFeedRate(), calculateDistance());
    }
}
