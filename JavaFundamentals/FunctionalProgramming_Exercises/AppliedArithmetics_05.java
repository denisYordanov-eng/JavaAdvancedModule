package FunctionalProgramming_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetics_05 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = fillNumbers(br);
        manipulateNumbers(numbers, br);
    }

    private static void manipulateNumbers(List<Integer> numbers, BufferedReader br) throws IOException {
        Function<Integer, Integer> add = (x) -> x + 1;
        Function<Integer, Integer> sub = (x) -> x - 1;
        Function<Integer, Integer> multiply = (x) -> x * 2;
        
        String command = br.readLine();
        while (!("end").equals(command)) {
            switch (command) {
                case "add":
                    for (int i = 0; i < numbers.size(); i++) {
                        numbers.set(i, add.apply(numbers.get(i)));
                    }
                    break;
                case "subtract":
                    for (int i = 0; i < numbers.size(); i++) {
                        numbers.set(i, sub.apply(numbers.get(i)));
                    }
                    break;
                case "multiply":
                    for (int i = 0; i < numbers.size(); i++) {
                        numbers.set(i, multiply.apply(numbers.get(i)));
                    }
                    break;
                case "print":
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < numbers.size(); i++) {
                        int num = numbers.get(i);

                        if (i == numbers.size() - 1) {
                            sb.append(num);
                        } else {
                            sb.append(num).append(" ");
                        }
                    }
                    System.out.println(sb.toString());
                    break;
            }
            command = br.readLine();
        }
    }

    private static List<Integer> fillNumbers(BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
