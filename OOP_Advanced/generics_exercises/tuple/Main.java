package tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String[] firstObjectInput = reader.readLine().split("\\s+");
        String name = firstObjectInput[0] + " " + firstObjectInput[1];
        String neighbourhood = firstObjectInput[2];

        Tuple tupleOne = new Tuple<>(name, neighbourhood);

        String[] secondObjectInput = reader.readLine().split("\\s+");
        String beerDrinker = secondObjectInput[0];
        int beerCount = Integer.parseInt(secondObjectInput[1]);
        Tuple tupleTwo = new Tuple<>(beerDrinker, beerCount);

        String[] thirdObjectInput = reader.readLine().split("\\s+");
        int wholeNumber = Integer.parseInt(thirdObjectInput[0]);
        double number = Double.parseDouble(thirdObjectInput[1]);
        Tuple tupleThree = new Tuple<>(wholeNumber, number);

        printOutput(tupleOne, tupleTwo, tupleThree);
    }

    public static void printOutput(Tuple tupleOne, Tuple tupleTwo, Tuple tupleThree) {
        System.out.println(tupleOne.toString());
        System.out.println(tupleTwo.toString());
        System.out.println(tupleThree.toString());
    }
}
