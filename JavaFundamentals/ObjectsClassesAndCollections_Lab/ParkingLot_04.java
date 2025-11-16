package ObjectsClassesAndCollections_Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class ParkingLot_04 {
    public static void main(String[] args) throws IOException {
        BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> leftCarsNumbers = checkParkingLot(br);
        printLeftCarsNumbers(leftCarsNumbers);
    }

    private static void printLeftCarsNumbers(HashSet<String> leftCarsNumbers) {
        if(leftCarsNumbers.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else {
            for (String carNumber : leftCarsNumbers) {
                System.out.println(carNumber);
            }
        }
    }

    private static HashSet<String> checkParkingLot(BufferedReader br) throws IOException {
        //read input line
        String inputLine = br.readLine();
        //initialize hash set of car numbers
        HashSet<String>carNumbers =  new HashSet<>();
        //if input line is END break
        while (!inputLine.equals("END")) {
            // make tokens.Split inputLine into a action and number
            String[] tokens = inputLine.split("[,\\s]+");
            String action = tokens[0];
            String carNumber = tokens[1];
            switch (action) {
                case"IN":
                    carNumbers.add(carNumber);
                    break;
                    case"OUT":
                        carNumbers.remove(carNumber);
                        break;
            }
            //update inputLine
            inputLine = br.readLine();
        }
        return  carNumbers;
    }
}
