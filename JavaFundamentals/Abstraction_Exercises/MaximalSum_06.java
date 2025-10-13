package Abstraction_Exercises;

import java.util.Scanner;

public class MaximalSum_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] inputLine = scanner.nextLine().split("\\s+");
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(inputLine[j]);
            }
        }
        long sum = 0;
        long currentSum = 0;
        int startIndexRow = 0;
        int startIndexColumn = 0;
        for (int i = 0; i < matrix.length - 2; i++) {
            for (int j = 0; j < matrix[i].length - 2; j++) {
                currentSum = matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2]
                        + matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i + 1][j + 2]
                        + matrix[i + 2][j] + matrix[i + 2][j + 1] + matrix[i + 2][j + 2];
                if (currentSum > sum) {
                    sum = currentSum;
                    startIndexRow = i;
                    startIndexColumn = j;
                }
                currentSum = 0;
            }
        }
        System.out.printf("Sum = %d\n", sum);
        printBestSumMatrix(startIndexColumn, startIndexRow, matrix);
    }

    private static void printBestSumMatrix(int startIndexColumn, int startIndexRow, int[][] matrix) {
        for (int row = startIndexRow; row < startIndexRow + 3; row++) {
            for (int col = startIndexColumn; col < startIndexColumn + 3; col++) {
                if (col == 3) {
                    System.out.print(matrix[row][col]);
                } else {
                    System.out.print(matrix[row][col] + " ");
                }
            }
            System.out.println();
        }
    }
}

