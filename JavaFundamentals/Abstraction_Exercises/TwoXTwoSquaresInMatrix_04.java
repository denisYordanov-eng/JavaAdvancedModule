package Abstraction_Exercises;

import java.util.Scanner;

public class TwoXTwoSquaresInMatrix_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = line[j];
            }
        }
        int count = findEqualChars(matrix);
        System.out.println(count);
    }

    private static int findEqualChars(String[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                if (matrix[i][j].equals(matrix[i][j + 1]) &&
                matrix [i + 1][j].equals(matrix[i + 1][j + 1]) &&
                matrix[i][j].equals(matrix[i + 1][j]) &&
                matrix [i][j + 1].equals(matrix[i + 1][j + 1])) {
                    count++;
                }
            }
        }
        return count;
    }
}
