package Abstraction_Exercises;

import java.util.Scanner;

public class CollectTheCoins_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] matrix = new String[4][];
        for (int row = 0; row < 4; row++) {
            String inputLine = scanner.nextLine();
            matrix[row] = new String[inputLine.length()];
            for (int col = 0; col < inputLine.length(); col++) {
                matrix[row][col] = "" + inputLine.charAt(col);
            }
        }
        String commands = scanner.nextLine();
        commands = commands.toLowerCase();

        int row = 0;
        int col = 0;
        int coins = 0;
        int wallCount = 0;


        for (int i = 0; i < commands.length(); i++) {
            char currentCommand = commands.charAt(i);
            try {
                if (currentCommand == '>') {
                    col++;
                    boolean checkIfTrueOrFalse = checkIfElementEquals$(matrix, row, col);
                    if (checkIfTrueOrFalse) {
                        coins++;
                    }
                } else if (currentCommand == '^') {
                    row--;
                    boolean checkIfTrueOrFalse = checkIfElementEquals$(matrix, row, col);
                    if (checkIfTrueOrFalse) {
                        coins++;
                    }
                } else if (currentCommand == '<') {
                    col--;
                    boolean checkChar = checkIfElementEquals$(matrix, row, col);
                    if (checkChar) {
                        coins++;
                    }
                } else if (currentCommand == 'v') {
                    row++;
                    boolean checkChar = checkIfElementEquals$(matrix, row, col);
                    if (checkChar) {
                        coins++;
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                wallCount++;
                switch (currentCommand) {
                    case '>':
                        col--;
                        break;
                    case '<':
                        col++;
                        break;
                    case 'v':
                        row--;
                        break;
                    case '^':
                        row++;
                        break;
                }
            }
        }

        printOutput(coins, wallCount);
    }

    private static void printOutput(int coins, int wallCount) {
        System.out.printf("Coins = %d\n", coins);
        System.out.printf("Walls = %d\n", wallCount);
    }

    private static boolean checkIfElementEquals$(String[][] matrix, int row, int col) {
        if (matrix[row][col].equals("$")) {
            return true;
        }
        return false;
    }
}
