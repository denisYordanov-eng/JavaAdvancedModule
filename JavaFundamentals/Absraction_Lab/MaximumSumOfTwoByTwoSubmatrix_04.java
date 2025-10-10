package Abstraction_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOfTwoByTwoSubmatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Read input
        String[] input = scanner.nextLine().split(",\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] singleRow = scanner.nextLine().split(",\\s+");
            for (int j = 0; j < singleRow.length; j++) {
                matrix[i][j] = Integer.parseInt(singleRow[j]);
            }
        }
        long bestSum = Integer.MIN_VALUE;
        int[] bestNumbers = new int[4];
        long currentSum = 0L;
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                currentSum = matrix[row][col] + matrix[row][col + 1]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1];


                if (currentSum > bestSum) {
                    bestSum = currentSum;
                    Arrays.fill(bestNumbers, 0);
                    bestNumbers[0] = matrix[row][col];
                    bestNumbers[1] = matrix[row][col + 1];
                    bestNumbers[2] = matrix[row + 1][col];
                    bestNumbers[3] = matrix[row + 1][col + 1];
                }
            }
        }
        printOutput(bestSum, bestNumbers);
    }

    public static void printOutput(long bestSum, int[] bestNumbers) {
        System.out.println(bestNumbers[0] + " " + bestNumbers[1]);
        System.out.println(bestNumbers[2] + " " + bestNumbers[3]);
        System.out.println(bestSum);
    }

}





