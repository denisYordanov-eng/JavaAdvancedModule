package FunctionalProgramming_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class FindEvensOrOdds_04 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = readInput(reader);
        Function<String, Integer> stringToInteger = string -> Integer.parseInt(string);
        int startNumber = stringToInteger.apply(input[0]);
        int endNumber = stringToInteger.apply(input[1]);

        String evenOrOddCommand = reader.readLine();
        List<Integer> outputList = madeAnArrayOfEvenOrOddNums(startNumber, endNumber, evenOrOddCommand);
        printOutput(outputList);
    }

    private static void printOutput(List<Integer> outputList) {
        for (Integer num : outputList) {
            System.out.print(num + " ");
        }
    }

    private static List<Integer> madeAnArrayOfEvenOrOddNums(int startNumber, int endNumber, String evenOrOddCommand) {
        List<Integer> output = new ArrayList<>();
        Predicate<Integer> evenOrOdd = number -> number % 2 == 0;
        Predicate<Integer> oddOrEven = number -> number % 2 != 0;
        int currentNumber = startNumber;
        for (int i = startNumber; i <= endNumber; i++) {
            if (("even").equals(evenOrOddCommand)) {
                if (evenOrOdd.test(currentNumber)) {
                    output.add(currentNumber);
                }
            } else if (("odd").equals(evenOrOddCommand)) {
                if (oddOrEven.test(currentNumber)) {
                    output.add(currentNumber);
                }
            }
            currentNumber++;
        }
        return output;
    }

    private static String[] readInput(BufferedReader reader) throws IOException {
        return reader.readLine().split("\\s+");
    }
}
