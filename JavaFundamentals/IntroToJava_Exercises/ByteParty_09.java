package InroToJava_Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ByteParty_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //read numbers and put them in an array
        int n = Integer.parseInt(scanner.nextLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            int currentIntNumber = Integer.parseInt(scanner.nextLine());
            numbers[i] = currentIntNumber;
        }

        //read commands and make some refactoring by commands
        String input = scanner.nextLine();
        while (!input.equals("party over")) {
            String[] command = input.split("\\s+");

            String commandType = command[0];
            int position = Integer.parseInt(command[1]);

            switch (commandType) {
                case "-1":
                    for (int i = 0; i < numbers.length; i++) {
                        int number = numbers[i];
                        int refactoredNumber = refactorNumberInByte(number, position);
                        numbers[i] = refactoredNumber;
                    }
                    break;

                case "0":
                    for (int i = 0; i < numbers.length; i++) {
                        int currentNumber = numbers[i];
                        int newN =  setZeroInEachNAtThePosition(currentNumber,position);
                        numbers[i] = newN;
                    }
                    break;
                case "1":

                    for (int i = 0; i < numbers.length; i++) {
                        int currentNumber = numbers[i];
                        int newN =  setOneInEachNAtThePosition(currentNumber,position);
                        numbers[i] = newN;
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        //Print output
        for(int number:numbers){
            System.out.println(number);
        }
    }

    private static int setOneInEachNAtThePosition(int currentNumber, int position) {
        int mask = 1 << position;
        return currentNumber | mask;
    }

    private static int setZeroInEachNAtThePosition(int currentNumber, int position) {

        int mask = ~(1 << position);
        return currentNumber & mask;
    }

    private static int refactorNumberInByte(int number,int position) {
        return number ^ (1<< position);
    }
}
