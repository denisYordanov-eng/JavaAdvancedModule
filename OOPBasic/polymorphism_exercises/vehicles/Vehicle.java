package vehicles;

import java.text.DecimalFormat;

public  abstract class Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;


    public Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    public  void refuel(double litres){
        this.fuelQuantity += litres;
    }
    public   String drive(double distance){
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
