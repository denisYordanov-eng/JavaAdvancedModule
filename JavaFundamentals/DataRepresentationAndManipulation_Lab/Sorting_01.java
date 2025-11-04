package DataRepresentationAndManipulation_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class Sorting_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //readArray from the console
        int[] arr1 = readArr(scanner);

        // print array using selectionSortMethod
        printArr(selectionSort(arr1));

        // print array using bubbleSort
        printArr(bubbleSort(arr1));
    }

    private static void printArr(int[] arr) {

        System.out.println(Arrays.toString(arr).replaceAll("[\\[\\],]", "").trim());
    }

    private static int[] readArr(Scanner scanner) {

        return Arrays.stream(scanner.nextLine()
                       .split("\\s+"))
               .mapToInt(Integer::parseInt)
               .toArray();
    }
    private static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    private static int[] bubbleSort(int[] arr) {
        boolean flag = true;
        do {
            flag = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    flag = true;
                }
            }
        }
        while (flag == true);
        return arr;
    }
}
