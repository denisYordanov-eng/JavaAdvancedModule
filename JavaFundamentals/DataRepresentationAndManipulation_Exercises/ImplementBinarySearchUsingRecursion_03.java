package DataRepresentationAndManipulation_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ImplementBinarySearchUsingRecursion_03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // read array
        int[] numbers = readInput(br);

        // read target number
        int targetNumber = readNumber(br);

        //find index using binary search method and recursion to change mid variable
        int targetIndex = binarySearch(numbers, targetNumber, 0, numbers.length - 1);

        //print output
        printOutput(targetIndex);
    }

    private static void printOutput(int targetIndex) {
        System.out.println(targetIndex);
    }

    private static int binarySearch(int[] numbers, int targetNumber, int start, int end) {
        //check base case
        if (start > end) {
            return -1;
        }
        //create every time mid variable
        int mid = start + (end - start) / 2;

        //check if number[mid] equals target number return the index and stop the recursion
        if (numbers[mid] == targetNumber) {
            return mid;
        } else if (numbers[mid] < targetNumber) { // if number[mid] < targetNumber
            // call the binary search again and set start = mid +1
            return binarySearch(numbers, targetNumber, mid + 1, end);
        } else {// if numbers[mid] > target number
            //call binary search method and set end to mid  - 1
            return binarySearch(numbers, targetNumber, start, mid - 1);
        }
    }

    private static int readNumber(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static int[] readInput(BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
