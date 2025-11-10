package DataRepresentationAndManipulation_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultiplyBigNumber_08 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //read firstNumberAsAString
        String firstNumber = readNumberAsAString(br);

        //read secondNumberAsAString
        String secondNumber = readNumberAsAString(br);

        String result = calculateResult(firstNumber,secondNumber);
        printOutput(result);
    }

    private static void printOutput(String result) {
        System.out.println(result);
    }

    private static String calculateResult(String firstNumber, String secondNumber) {
        StringBuilder result = new StringBuilder();
        int secondNum = Integer.parseInt(secondNumber);
        int carry = 0;
        for (int i = 0; i < firstNumber.length(); i++) {
            int currentDigit = Integer.parseInt("" + firstNumber.charAt(firstNumber.length() - 1 - i));
            int sum = currentDigit * secondNum + carry;
            //append lastDigit
            result.append(sum % 10);
            //take first digit
            carry = sum / 10;

         }
        if (carry > 0){

            result.append(carry);
        }

        while (result.length() > 1 && result.charAt(result.length() - 1) == '0'){
            result.setLength(result.length() - 1);
        }
        result.reverse();
        return result.toString();
    }

    private static String readNumberAsAString(BufferedReader br) throws IOException {
        return  br.readLine();
    }
}
