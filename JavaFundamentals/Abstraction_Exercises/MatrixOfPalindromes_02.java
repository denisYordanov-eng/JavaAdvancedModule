package Abstraction_Exercises;


import java.util.Scanner;

public class MatrixOfPalindromes_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //read input
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        String[][] matrix = buildMatrix(rows, cols);
        printTheMatrixOutput(matrix);
    }

    private static void printTheMatrixOutput(String[][] matrix) {

        for (String[] cols : matrix) {
            for (String str : cols) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }


    private static String[][] buildMatrix(int rows, int cols) {
        String[][] matrix = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char firstAndLast = (char) ('a' + i);
                char middle = (char) ('a' + i + j);
                matrix[i][j] = String.valueOf("" + firstAndLast + middle + firstAndLast);
            }
        }
        return matrix;
    }
}


