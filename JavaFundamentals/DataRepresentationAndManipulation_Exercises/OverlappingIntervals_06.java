package DataRepresentationAndManipulation_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class OverlappingIntervals_06 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = readNumber(br);

        int[][]intervals = readIntervals(n, br);

       sortIntervals(intervals);

      boolean result = checkForEqualElements(intervals);

         printResult(result);

    }

    private static boolean checkForEqualElements(int[][] intervals) {
        for (int i = 0; i < intervals.length - 1; i++) {
            //check if end of the current interval is bigger or equal of start of the next interval
            if (intervals[i][1] >= intervals[i  + 1][0]) {
                return true;
            }
        }
        return false;
    }

    private static void printResult(boolean result) {
        System.out.println(result);
    }


    private static void  sortIntervals(int[][] intervals) {
         Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
    }


    private static int[][] readIntervals(int n, BufferedReader br) throws IOException {

        int[][] intervals = new int[n][2];


        for (int i = 0; i < n  ; i++) {
           int[] inputIntervals = Arrays.stream(br.readLine().split(","))
                   .mapToInt(Integer::parseInt)
                   .toArray();

           //put a start number of interval
           intervals[i][0] = inputIntervals[0];

           //put end number of interval
            intervals[i][1] = inputIntervals[1];

        }
        return intervals;
    }

    private static int readNumber(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }
}
