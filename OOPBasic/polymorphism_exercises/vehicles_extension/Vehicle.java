package vehicles_extension;

import java.text.DecimalFormat;

public  abstract class Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;
    private  double tankCapacity;

    public Vehicle(double tankCapacity, double fuelConsumption,double fuelQuantity) {
        this.tankCapacity = tankCapacity;
        this.fuelConsumption = fuelConsumption;
        setFuelQuantity(fuelQuantity);
    }

    public void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity <= 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if(fuelQuantity > this.tankCapacity){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public  void refuel(double litres){
        if (litres <= 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if(litres > this.tankCapacity){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
      //  setFuelQuantity(this.fuelQuantity + litres);
        this.fuelQuantity += litres;
    }
    public String drive(double distance){
      double totalConsumption = distance * this.fuelConsumption;
      if(totalConsumption <= this.fuelQuantity){
          DecimalFormat df = new DecimalFormat("#.##");
          this.fuelQuantity -=  totalConsumption;
          return String.format("%s travelled %s km",getClass().getSimpleName(),df.format(distance));
      }
        return String.format("%s needs refueling",getClass().getSimpleName());
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("%s: %.2f",getClass().getSimpleName(), this.fuelQuantity);
    }
}
