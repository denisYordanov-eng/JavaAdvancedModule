package DataRepresentationAndManipulation_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class Searching_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = readArr(scanner);
        int wantedIndex = Integer.parseInt(scanner.nextLine());
        int position = findIndexInArrLinearSearch(arr, wantedIndex);
        int positionBinarySearch = findIndexInArrBinarySearch(arr, wantedIndex, 0, arr.length - 1);
        System.out.println(position);
        System.out.println(positionBinarySearch);
    }

    private static int findIndexInArrBinarySearch(int[] arr, int wantedIndex, int start, int end) {
        while (start <= end) {
            int middle = (start + end) / 2;
            if (arr[middle] < wantedIndex) {
                start = middle + 1;
            } else if (arr[middle] > wantedIndex) {
                end = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    private static int findIndexInArrLinearSearch(int[] arr, int wantedIndex) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == wantedIndex) {
                return i;
            }
        }
        return -1;
    }


    private static int[] readArr(Scanner scanner) {
        return Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
