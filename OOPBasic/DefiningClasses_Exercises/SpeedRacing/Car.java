package DefiningClass_Exercises.SpeedRacing;

public class Car {
    private final double INITIAL_DISTANCE = 0;

    private  String model;

    private double fuelAmount;

    private  double fuelConsumptionPerKm;

    private  double distance = INITIAL_DISTANCE;

    public Car(String model, double fuelAmount, double fuelConsumptionPerKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
        this.distance = INITIAL_DISTANCE;
    }

    public String getModel() {
        return model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getFuelConsumptionPerKm() {
        return fuelConsumptionPerKm;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }



    public  void drive (double targetKm) {
        double fuelNeed = fuelConsumptionPerKm * targetKm;

        if(checkFuel(fuelAmount,fuelNeed)){
            fuelAmount -= fuelNeed;
            distance += targetKm;
        }else {
            System.out.println("Insufficient fuel for the drive");
        }
    }
    public  boolean checkFuel(double fuelAmount,double fuelNeed){
        if(fuelAmount >= fuelNeed){
            return true;
        }
        return false;
    }
       @Override
    public String toString(){
   return String.format("%s %.2f %.0f", getModel(),getFuelAmount(), getDistance());
    }
}
