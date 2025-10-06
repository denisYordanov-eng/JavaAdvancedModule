package InroToJava_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class FirstOddOrEvenElements_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String[] command = scanner.nextLine().split("\\s+");

        int numbersToGet = Integer.parseInt(command[1]);
        String oddOrEven = command[2];

        StringBuilder stringBuilder = new StringBuilder();

        int count = 0;
        //find odd numbers
        if (oddOrEven.equals("odd")) {
            for (int i = 0; i < numbers.length; i++) {
                int currentNumber = Math.abs(numbers[i]);
                if (currentNumber % 2 == 1) {
                    stringBuilder.append(currentNumber).append(" ");
                    count++;
                }
                if (count == numbersToGet || i == numbers.length - 1) {
                    System.out.println(stringBuilder.toString());
                    return;
                }
            }
        } else if (oddOrEven.equals("even")) { // find even numbers
            for (int i = 0; i < numbers.length; i++) {
                int currentNumber = Math.abs(numbers[i]);
                if (currentNumber % 2 == 0) {
                    stringBuilder.append(currentNumber).append(" ");
                    count++;
                }
                if (count == numbersToGet || i == numbers.length - 1) {
                    break;
                }
            }
            System.out.println(stringBuilder.toString());
        }
    }
}