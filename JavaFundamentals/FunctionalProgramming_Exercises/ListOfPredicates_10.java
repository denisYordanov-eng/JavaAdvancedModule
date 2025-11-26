package FunctionalProgramming_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOfPredicates_10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = readNumber(br);

        List<Integer> dividedNumbers = readList(br);

        List<Integer>numbers = fillList(n);

        StringBuilder sb = new StringBuilder();

        Predicate<Integer> isValid = number -> {
            for (int dividedNumber : dividedNumbers) {
                if (number % dividedNumber != 0) {
                    return false;
                }
            }
            return true;
        };

        for (int number : numbers) {
            if (isValid.test(number)) {
                sb.append(number).append(" ");
            }
        }
        printOutput(sb);
    }

    private static void printOutput(StringBuilder sb) {
        System.out.println(sb.toString());
    }

    private static List<Integer> fillList(int n) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++){
            numbers.add(i + 1);
        }
         return  numbers;
    }

    private static List<Integer> readList(BufferedReader br) throws IOException {
        return  Arrays.stream(br.readLine()
                .split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static int readNumber(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }
}
