package Abstraction_Exercises;

import java.util.Scanner;

public class FillTheMatrix_01 {
    public static void main(String[] args) {
        //Read Input
        Scanner scanner = new Scanner(System.in);
        String[] inputLine = scanner.nextLine().split(", ");
        int n = Integer.parseInt(inputLine[0]);
        String pattern = inputLine[1];

        int[][] matrix = new int[n][n];
        switch (pattern) {
            case "A":
                matrix = makeAMatrixInAPattern(n);
                break;
            case "B":
                matrix = makeBMatrixPattern(n);
                break;
        }
        printMatrix(matrix);
    }

    private static int[][] makeBMatrixPattern(int n) {
        int[][] matrix = new int[n][n];
        int number = 1;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < matrix[i].length; j++) {
                if (i % 2 == 0) {
                    matrix[j][i] = number++;
                } else {
                    matrix[n - 1 - j][i] = number++;
                }
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] makeAMatrixInAPattern(int n) {
        int[][] aMatrix = new int[n][n];
        int number = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                aMatrix[j][i] = number++;
            }
        }
        return aMatrix;
    }
}
