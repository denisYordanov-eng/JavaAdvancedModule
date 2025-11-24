package FunctionalProgramming_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class CustomMinFunction_03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = readNumArr(br);
        Function<int[], Integer> findSmallestNum = (nums) -> {
            int smallest = Integer.MAX_VALUE;
            for (int current : nums) {
                if (current < smallest) {
                    smallest = current;
                }
            }
            return smallest;
        };
        printOutput(findSmallestNum, numbers);
    }

    private static void printOutput(Function<int[], Integer> findSmallestNum, int[] numbers) {

        int smallestElement = findSmallestNum.apply(numbers);
        System.out.println(smallestElement);

    }

    private static int[] readNumArr(BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
