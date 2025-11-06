package DataRepresentationAndManipulation_Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = readArray(scanner);
        int n = numbers.length;
        reverseArray(numbers,n);
    }

    private static void reverseArray(int[] numbers, int n) {
        if (n <= 0) {
            return;
        }
        System.out.print(numbers[n - 1] + " ");
        reverseArray(numbers, n - 1);
    }


    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
