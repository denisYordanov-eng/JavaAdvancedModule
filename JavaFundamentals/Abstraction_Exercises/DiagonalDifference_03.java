package Abstraction_Exercises;

import java.util.Scanner;

public class DiagonalDifference_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }

        int[] lAndRDiagonalSum = new int[2];
        lAndRDiagonalSum = findSums(matrix,lAndRDiagonalSum);
        printOutput(lAndRDiagonalSum);
    }

    private static void printOutput(int[] lAndRDiagonalSum) {
        int diff = Math.abs(lAndRDiagonalSum[0] - lAndRDiagonalSum[1]);
        System.out.println(diff);
    }

    private static int[] findSums(int[][] matrix, int[] lAndRDiagonalSum) {
        lAndRDiagonalSum[0] = lAndRDiagonalSum[1] = 0;

            for (int i = 0; i < matrix.length; i++) {
                lAndRDiagonalSum[0] += matrix[i][i];
                lAndRDiagonalSum[1] += matrix[i][matrix.length - 1 -i];
            }

        return lAndRDiagonalSum;
    }
}
