package DataRepresentationAndManipulation_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class FindTheMissingNumber_07 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = readNumber(br);

        int[]numbers = readArr(br, n);

        int[] sortedNumbers = sortNumbers(numbers);

        int missingNumber = findMissingNumber(sortedNumbers, n);

        printMissingNumber(missingNumber);
    }

    private static void printMissingNumber(int missingNumber) {
        System.out.println(missingNumber);
    }

    private static int findMissingNumber(int[] sortedNumbers, int n) {
        //initialize missing number
        int missingNumber = 0;
        //make a for loop to sortedNumbers length
        for (int i = 0; i < sortedNumbers.length; i++) {
            // if current number is not equal to i + 1 (i starts from 0)
            if(sortedNumbers[i] != i + 1){
                missingNumber = i + 1;// make missing number to i + 1
               return missingNumber;
            }
        }
        return n;
    }

    private static int[] sortNumbers(int[] numbers) {
        //initialize boolean
        boolean flag;
        do {
            //make flag = false
            flag = false;
            // make for loop to numbers length - 1
            for(int i = 0; i < numbers.length - 1; i++) {
                //check if current number is bigger than next number
                if(numbers[i] > numbers[i + 1]) {
                   swapNumbers(numbers[i], numbers[i + 1]); //swap numbers
                    flag = true;// make flag == true
                }
            }
        }while(flag);
        return numbers;
    }

    private static void swapNumbers(int currentNumber, int nextNumber) {
        int temp = currentNumber;
        currentNumber = nextNumber;
        nextNumber = temp;
    }

    private static int[] readArr(BufferedReader br, int n) throws IOException {

        return Arrays.stream(br.readLine()
                .split("[,\\s]+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static int readNumber(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }
}
