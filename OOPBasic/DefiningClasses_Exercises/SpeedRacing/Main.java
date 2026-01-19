package DefiningClass_Exercises.SpeedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Map<String,Car> cars = new LinkedHashMap<>();
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        for (int i = 0; i < n; i++) {
            String[] tokens = bufferedReader.readLine().split("\\s+");
            String model =  tokens[0];
            double fuelConsumption = Double.parseDouble(tokens[1]);
            double fuelPricePerKm = Double.parseDouble(tokens[2]);

            Car car = new Car(model, fuelConsumption, fuelPricePerKm);
            if(!cars.containsKey(model)){
                cars.put(model, car);
            }
        }
        String inputLine = bufferedReader.readLine().trim();
        while (!inputLine.equals("End")) {
            String[] Driving  = inputLine.split("\\s+");
            String targetModel = Driving[1];
            double targetKm = Double.parseDouble(Driving[2]);
            if(cars.containsKey(targetModel)) {
               Car currentCar = cars.get(targetModel);
               double fuel = currentCar.getFuelAmount();
               double pricePerKm = currentCar.getFuelConsumptionPerKm();
               currentCar.drive(targetKm);
            }
            inputLine =  bufferedReader.readLine().trim();
        }
        for(Car entry : cars.values()){
            System.out.println(entry.toString());
        }
    }
}
