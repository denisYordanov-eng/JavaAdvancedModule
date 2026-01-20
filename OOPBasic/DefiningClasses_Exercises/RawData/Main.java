package DefiningClass_Exercises.RawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      List<Car> cars =  new ArrayList<>();

        int n = Integer.parseInt(br.readLine().trim());


        for (int i = 0; i < n; i++) {
            String[] tokens = br.readLine().trim().split("\\s+");

            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            double tyreOnePressure = Double.parseDouble(tokens[5]);
            int tyreOneYears = Integer.parseInt(tokens[6]);
            double tyreTwoPressure = Double.parseDouble(tokens[7]);
            int tyreTwoYears = Integer.parseInt(tokens[8]);
            double tyreThreePressure = Double.parseDouble(tokens[9]);
            int tyreThreeYears = Integer.parseInt(tokens[10]);
            double tyreFourPressure = Double.parseDouble(tokens[11]);
            int tyreFourYears = Integer.parseInt(tokens[12]);


            Car car = new Car(model, engineSpeed, enginePower, cargoWeight, cargoType,
                    tyreOnePressure, tyreOneYears, tyreTwoPressure, tyreTwoYears, tyreThreePressure, tyreThreeYears
                    , tyreFourPressure, tyreFourYears);

            cars.add(car);
        }
        String command = br.readLine().trim();
        if (command.equals("fragile")) {

            for(Car car : cars) {
                if(car.getCargo().getCargoType().equals("fragile")) {
                    for(Tyres tyres : car.getTyres()) {
                        if(tyres.getTyrePressure() < 1){
                            System.out.println(car.toString());
                            break;
                        }
                    }
                }
            }
        }else if (command.equals("flamable")) {
            for(Car car : cars) {
                if (car.getEngine().getPower() > 250) {
                    System.out.println(car.toString());
                }
            }
        }
    }
}
