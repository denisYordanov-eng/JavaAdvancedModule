package DataRepresentationAndManipulation_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindTheMissingNumber_07_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = readNumber(br);

        int[] arr = readArr(br);

        int[] patternArr = makePatternArr(n);

        int  missingNumber = findMissingNumber(arr,patternArr);

        printOutput(missingNumber);
    }

    private static void printOutput(int missingNumber) {
        System.out.println(missingNumber);
    }

    private static int findMissingNumber(int[] arr, int[] patternArr) {
        int patternArrSum = Arrays.stream(patternArr).sum();
        int sumArr = Arrays.stream(arr).sum();
        return patternArrSum - sumArr;
    }

    private static int[] makePatternArr(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

    private static int[] readArr(BufferedReader br) throws IOException {
        return  Arrays.stream(br.readLine()
                .split("[,\\s]+"))
                .mapToInt(Integer::parseInt)
                .toArray();

    }

    private static int readNumber(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }
}
