package vehicles_extension;

public class Bus extends Vehicle {
    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }


    public String driveFull(double distance) {
        double standardFuelConsumption = super.getFuelConsumption();
        this.setFuelConsumption(standardFuelConsumption + 1.4);

        String result = super.drive(distance);

        this.setFuelConsumption(standardFuelConsumption);
        return result;
    }
}
