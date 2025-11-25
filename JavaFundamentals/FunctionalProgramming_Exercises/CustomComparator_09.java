package FunctionalProgramming_Exercises;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CustomComparator_09 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = readList(br);
        List<Integer> oddNumbers = new ArrayList<>();
        List<Integer> evenNumbers = new ArrayList<>();
        Predicate<Integer> evenNumber = number -> number % 2 == 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (evenNumber.test(numbers.get(i))) {
                evenNumbers.add(numbers.get(i));
            } else {
                oddNumbers.add(numbers.get(i));
            }
        }
        evenNumbers.sort((e1, e2) -> e1.compareTo(e2));
        oddNumbers.sort((e1, e2) -> e1.compareTo(e2));
        printOutput(evenNumbers, oddNumbers);
    }

    private static void printOutput(List<Integer> numbers, List<Integer> oddNumbers) {
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        for (int number : oddNumbers) {
            System.out.print(number + " ");
        }
    }

    private static List<Integer> readList(BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
