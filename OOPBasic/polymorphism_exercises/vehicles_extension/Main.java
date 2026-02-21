package vehicles_extension;

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
        double tankSize = Double.parseDouble(input[3]);
        Car car = new Car(tankSize, fuelConsumption, fuelQuantity);


        String[] tokens = br.readLine().split("\\s+");
        String vehicleName = tokens[0];
        double quantity = Double.parseDouble(tokens[1]);
        double consumption = Double.parseDouble(tokens[2]);
        double tankCapacity = Double.parseDouble(tokens[3]);
        Truck truck = new Truck(tankCapacity, consumption, quantity);

        String[] busTokens = br.readLine().split("\\s+");
        double fuel = Double.parseDouble(busTokens[1]);
        double fuelConsumn = Double.parseDouble(busTokens[2]);
        double sizeTank = Double.parseDouble(busTokens[3]);
        Bus bus = new Bus(sizeTank, fuelConsumn, fuel);

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            try {
                String[] commands = br.readLine().split("\\s+");
                if (commands[0].equalsIgnoreCase("Drive")) {
                    double distance = Double.parseDouble(commands[2]);
                    if (commands[1].equalsIgnoreCase("Car")) {
                        System.out.println(car.drive(distance));
                    } else if (commands[1].equalsIgnoreCase("Truck")) {
                        System.out.println(truck.drive(distance));
                    } else if (commands[1].equalsIgnoreCase("Bus")) {
                        System.out.println(bus.driveFull(distance));
                    }
                } else if (commands[0].equalsIgnoreCase("Refuel")) {
                    double refuel = Double.parseDouble(commands[2]);
                    if (commands[1].equalsIgnoreCase("Car")) {
                        car.refuel(refuel);
                    } else if (commands[1].equalsIgnoreCase("Truck")) {
                        truck.refuel(refuel);
                    } else if (commands[1].equalsIgnoreCase("Bus")) {
                        bus.refuel(refuel);
                    }

                } else if (commands[0].equalsIgnoreCase("DriveEmpty")) {
                    double distance = Double.parseDouble(commands[2]);
                    if (commands[1].equalsIgnoreCase("Bus")) {
                        System.out.println(bus.drive(distance));
                    }
                }
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }
}
