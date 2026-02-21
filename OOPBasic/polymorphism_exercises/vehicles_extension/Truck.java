package vehicles_extension;

public class Truck extends Vehicle {
    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + 1.6, tankCapacity);
    }

    @Override
    public void refuel(double fuelConsumption) {
        double liters = fuelConsumption * 0.95;
        super.refuel(liters);
    }

}
