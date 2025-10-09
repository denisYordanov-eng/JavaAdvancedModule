package Abstraction_Lab;

import java.util.Scanner;

public class SumMatrixElements_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Read input
        String[] input = scanner.nextLine().split(",\\s+");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        //initialize a matrix Arr and sum all elements in it
        int[][] matrix = new int[a][b];
        long sum = 0L;
        for (int row = 0; row < matrix.length; row++) {
            String[] reminder = scanner.nextLine().split(",\\s+");
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = Integer.parseInt(reminder[col]);
                sum += matrix[row][col];
            }
        }
        //Print output
        printOutput(a, b, sum);

    }

    private static void printOutput(int a, int b, long sum) {
        System.out.println(a);
        System.out.println(b);
        System.out.println(sum);
    }
}
