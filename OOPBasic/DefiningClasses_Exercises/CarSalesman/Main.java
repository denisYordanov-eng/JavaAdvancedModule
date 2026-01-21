package DefiningClass_Exercises.CarSalesman;

import DefiningClass_Exercises.CompanyRoster.Employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        Map<String, Engine> engines = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = br.readLine().trim().split("\\s+");
            Engine engine = null;
            String type = tokens[0];
            int power = Integer.parseInt(tokens[1]);
            //“<Model> <Power> <Displacement> <Efficiency>”.
            switch (tokens.length) {
                case 2:
                    engine = new Engine(type, power);
                    break;
                case 3:
                    if (Character.isDigit(tokens[2].charAt(0))) {
                        Integer displacement = Integer.parseInt(tokens[2]);
                        engine = new Engine(type, power, displacement, null);
                    } else {
                        Integer displacement = null;
                        String efficiency = tokens[2];
                        engine = new Engine(type, power, null, efficiency);
                    }
                    break;
                case 4:
                    Integer displacement = Integer.parseInt(tokens[2]);
                    String efficiency = tokens[3];
                    engine = new Engine(type, power, displacement, efficiency);
                    break;
            }
            if (engine != null) {
                if (!engines.containsKey(type)) {
                    engines.put(type, engine);
                }
            }
        }

        int m = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < m; i++) {
            String[] carInfo = br.readLine().trim().split("\\s+");
            //“<Model> <Engine> <Weight> <Color>”,
            String model = carInfo[0];
            String currentEngine = carInfo[1];
            if (engines.containsKey(currentEngine)) {
                Car car = null;
                switch (carInfo.length) {
                    case 2:
                        car = new Car(model, engines.get(currentEngine), null, null);
                        break;
                    case 3:
                        if (Character.isDigit(carInfo[2].charAt(0))) {
                            Integer weight = Integer.parseInt(carInfo[2]);
                            car = new Car(model, engines.get(currentEngine), weight, null);
                        } else {
                            String color = carInfo[2];
                            car = new Car(model, engines.get(currentEngine), null, color);
                        }
                        break;
                    case 4:
                        Integer weight = Integer.parseInt(carInfo[2]);
                        String color = carInfo[3];
                        car = new Car(model, engines.get(currentEngine), weight, color);
                        break;
                }
                if (car != null) {
                    System.out.println(car.toString());
                }
            }
        }
    }
}