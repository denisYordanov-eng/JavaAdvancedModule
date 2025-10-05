package InroToJava_Exercise;

import java.util.Scanner;

public class FormattingNumbers_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split("\\s+");

        int firstNumber = Integer.parseInt(numbers[0]);

        //first number to print
        String numberToHex = Integer.toHexString(firstNumber).toUpperCase();


        String numberToBinary = Integer.toBinaryString(firstNumber);
        //second number to print
        String numberWithPadding = String.format("%010d",Integer.parseInt(numberToBinary));


        double  secondNumber = Double.parseDouble(numbers[1]);

        double  thirdNumber = Double.parseDouble(numbers[2]);

        System.out.printf("|%-10s|%-10s|%10.2f|%-10.3f|",numberToHex,numberWithPadding, secondNumber,thirdNumber);

    }
}
