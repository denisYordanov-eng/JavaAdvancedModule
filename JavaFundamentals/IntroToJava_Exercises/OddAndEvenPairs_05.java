package InroToJava_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class OddAndEvenPairs_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        if(numbers.length % 2 != 0){
            System.out.println("invalid length");
            return;
        }

        for (int i = 0; i <numbers.length - 1; i+= 2) {
            int previousNum = numbers[i];
            int currentNum = numbers[i + 1];

            if(currentNum % 2 == 0 && previousNum % 2 == 0){
                System.out.printf("%d, %d -> both are even\n",previousNum, currentNum);
            } else if (currentNum % 2 == 1 && previousNum % 2 == 1) {
                System.out.printf("%d, %d -> both are odd\n",previousNum, currentNum);
            }else {
                System.out.printf("%d, %d -> different\n",previousNum, currentNum);
            }
            previousNum = currentNum;
        }
    }
}
