package StringProcessing_Exercises;

import java.util.Scanner;

public class SumBigNumbers_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
     //read first number
        String firstNumber = scanner.nextLine();
        //read second number
        String secondNumber = scanner.nextLine();
        // call  method to calculate result
        String result = calculateResult(firstNumber, secondNumber);
       //print result
        System.out.println(result);
    }

    private static String calculateResult(String firstNumber, String secondNumber) {
        // calculate differences between the length of the numbers
        // take diff
        int diff = Math.abs(firstNumber.length() - secondNumber.length());
        // pad the shorter with zeros so both have equal length
        if (firstNumber.length() < secondNumber.length()) {
            //fill the number with zeros to make first number and second  secon equal length
            firstNumber = padWithZeros(diff, firstNumber);
            //if  second number is shorter
            //fill the second number with zero to make first and second number equal length
        } else if (secondNumber.length() < firstNumber.length()) {
            secondNumber = padWithZeros(diff, secondNumber);
        }
          //initialize StringBuilder
        StringBuilder resultStr = new StringBuilder();
        //initialize carry
        int carry = 0;
        // make a for loop that iterates  form  last digit to  the first (right to left)
        for (int i = firstNumber.length() - 1; i >= 0; i--) {
            //make current char of first number to integer digit
            int currentDigit = firstNumber.charAt(i) - '0';
            //make current char  of second number to integer digit
            int secondCurrentDigit = secondNumber.charAt(i) - '0';
            // calculate sum between digits and carry
            int sum = currentDigit + secondCurrentDigit + carry;
            //append the last digit
            resultStr.append(sum % 10);
            // calculate the carry(ten tens part of the sum)
            carry = sum / 10;
        }
        //if carry is bigger append it to the resultStr
        if (carry > 0) {
            resultStr.append(carry);
        }
        //reverse the result
        resultStr.reverse();
        // delete the  leading zeros that we place  earlier
        while (resultStr.length() > 0 && resultStr.charAt(0) == '0') {
            resultStr.deleteCharAt(0);
        }
        //return the result
        return resultStr.toString().trim();
    }

    private static String padWithZeros(int number, String strNumber) {
        StringBuilder sb = new StringBuilder();
        // fill the number diff  length with zeros
        for (int i = 0; i < number; i++) {
            sb.append(0);
        }
        //append number
        sb.append(strNumber);
        return sb.toString();
    }
}
