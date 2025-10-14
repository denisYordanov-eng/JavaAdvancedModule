package Abstraction_Exercises;

import java.util.Scanner;

public class MatrixShuffling_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        scanner.nextLine();

        String[][] matrix = new String[row][col];

        for (int i = 0; i < row; i++) {
            String[] inputLine = scanner.nextLine().split("\\s+");
            for (int j = 0; j < col; j++) {
                matrix[i][j] = inputLine[j];
            }
        }

        String commandLine = scanner.nextLine();
        while (!commandLine.equals("END")) {
            try {
            String[] command = commandLine.split("\\s+");
            if(!command[0].equals("swap")) {
                System.out.println("Invalid input!");
                commandLine = scanner.nextLine();
                continue;
            }

            int row1 = Integer.parseInt(command[1]);
            int col1 = Integer.parseInt(command[2]);
            int wantedRow = Integer.parseInt(command[3]);
            int wantedCol = Integer.parseInt(command[4]);

                String temp =  matrix[row1][col1];
            matrix[row1][col1] = matrix[wantedRow][wantedCol];
            matrix[wantedRow][wantedCol] = temp;
            }
            catch (Exception e) {
                System.out.println("Invalid input!");
                commandLine = scanner.nextLine();
                continue;
            }
            printMatrix(row,col, matrix);

            commandLine = scanner.nextLine();
        }
    }

    private static void printMatrix(int row, int col, String[][] matrix) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(j == col - 1){
                    System.out.print(matrix[i][j]);
                }else {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println();
        }
    }


}
