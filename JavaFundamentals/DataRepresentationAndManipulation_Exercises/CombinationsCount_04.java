package DataRepresentationAndManipulation_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CombinationsCount_04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //read n
        int n = readInteger(br);

        //read k
        int k = readInteger(br);

        //calculate total combinations
        long totalCombinations = calculateCombinations(n, k);

        //print total combinations
        print(totalCombinations);
    }

    private static void print(long totalCombinations) {
        System.out.println(totalCombinations);
    }

    private static long calculateCombinations(int n, int k) {
        //base case
        if (k == 0 || k == n) {
            return 1;
        }
        //recursive formula C(n, k) = C(n - 1,k - 1) + C(n - 1, k)
        return calculateCombinations(n - 1, k - 1) + calculateCombinations(n - 1, k);
    }

    private static int readInteger(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }
}
