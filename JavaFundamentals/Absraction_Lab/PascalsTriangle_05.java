package Abstraction_Lab;

import java.util.Scanner;

public class PascalsTriangle_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        long[][] pascalTriangle = makeAPascalTriangle(n);
        for (long[] row : pascalTriangle) {
            for (long value : row) {
                if (value != 0) {
                    System.out.print(value + " ");
                }
            }
            System.out.println();
        }
    }

    private static long[][] makeAPascalTriangle(int n) {
        long[][] pascalTriangle = new long[n][n];
        for (int currentHeight = 0; currentHeight < n; currentHeight++) {
            pascalTriangle[currentHeight][0] = 1;
            pascalTriangle[currentHeight][currentHeight] = 1;
            if (currentHeight >= 2) {
                for (int i = 1; i < currentHeight; i++) {
                    long[] previousRow = pascalTriangle[currentHeight - 1];
                    long previousRowSum = previousRow[i] + previousRow[i - 1];
                    pascalTriangle[currentHeight][i] = previousRowSum;
                }
            }
        }
        return pascalTriangle;
    }
}
