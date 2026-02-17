package vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\s+");
        String vehicleType = input[0];
        double fuelQuantity = Double.parseDouble(input[1]);
        double fuelConsumption = Double.parseDouble(input[2]);
        Car car = new Car(fuelQuantity, fuelConsumption);


        String[] tokens = br.readLine().split("\\s+");
        String vehicleName = tokens[0];
        double quantity = Double.parseDouble(tokens[1]);
        double consumption = Double.parseDouble(tokens[2]);
        Truck truck = new Truck(quantity, consumption);

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] commands = br.readLine().split("\\s+");
            if (commands[0].equalsIgnoreCase("Drive")){
                double distance = Double.parseDouble(commands[2]);
                if (commands[1].equalsIgnoreCase("Car")){
                    System.out.println(car.drive(distance));
                }else if (commands[1].equalsIgnoreCase("Truck")){
                    System.out.println(truck.drive(distance));
                }
            }else if (commands[0].equalsIgnoreCase("Refuel")){
                double refuel = Double.parseDouble(commands[2]);
                if (commands[1].equalsIgnoreCase("Car")){
                    car.refuel(refuel);
                }else if (commands[1].equalsIgnoreCase("Truck")){
                    truck.refuel(refuel);
                }
            }
        }
        System.out.println(car);
        System.out.println(truck);
    }
}
