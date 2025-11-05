package DataRepresentationAndManipulation_Lab;

import java.util.Arrays;
import java.util.Scanner;



public class RecursiveArraySum_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] arr = readInputArr(scanner);
        int sum = findSum(arr,0);
        printResult(sum);

    }

    private static void printResult(int sum) {
        System.out.println(sum);
    }

    private static int findSum(int[] arr, int index) {
        if (index == arr.length - 1) {
            return arr[index];
        }
        return  arr[index] + findSum(arr,index + 1) ;
    }

    private static int[] readInputArr(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
