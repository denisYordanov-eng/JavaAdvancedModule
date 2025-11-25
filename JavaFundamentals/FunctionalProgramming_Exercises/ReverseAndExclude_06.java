package FunctionalProgramming_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Consumer;

public class ReverseAndExclude_06 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int[] numbers = readSetNumbers(br);
      List<Integer> reverseSet =  reverseNumbersSet(numbers);
      int dividedNumber = readNumber(br);
      reverseSet.removeIf(number -> number % dividedNumber == 0);
      printOutput(reverseSet);
    }

    private static void printOutput(List<Integer> reverseSet) {
        StringBuilder sb = new StringBuilder();
        for (Integer number : reverseSet) {
            sb.append(number).append(" ");
        }
        System.out.println(sb.toString());
    }

    private static int readNumber(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static List<Integer> reverseNumbersSet(int[] numbers) {
      List<Integer> reverseList = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++) {
            reverseList.add(numbers[numbers.length - 1 - i]);
        }
        return reverseList;
    }

    private static int[] readSetNumbers(BufferedReader br) throws IOException {
            return Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
