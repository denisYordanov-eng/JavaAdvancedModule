package JavaAdvancedExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Snake_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int screenSize = Integer.parseInt(br.readLine());

        String[] commands = br.readLine().split(", ");

        char[][] gameBoard = readGameBoardChars(br, screenSize);

        int[] startingPoint = findStartingPoint(gameBoard);

        int snakeRow = startingPoint[0];
        int snakeCol = startingPoint[1];

        int allFood = startingPoint[2];
        int eatenFood = 0;

        for (String command : commands) {
            switch (command) {
                case "up":
                    snakeRow--;
                    if (snakeRow < 0) {
                        snakeRow = gameBoard.length - 1;
                    }
                    break;
                case "down":
                    snakeRow++;
                    if (snakeRow >= gameBoard.length) {
                        snakeRow = 0;
                    }
                    break;
                case "left":
                    snakeCol--;
                    if (snakeCol < 0) {
                        snakeCol = gameBoard.length - 1;
                    }
                    break;
                case "right":
                    snakeCol++;
                    if (snakeCol >= gameBoard[0].length) {
                        snakeCol = 0;
                    }
                    break;
            }

            if (gameBoard[snakeRow][snakeCol] == '*') {
                continue;
            } else if (gameBoard[snakeRow][snakeCol] == 'f') {
                eatenFood++;
                if (eatenFood == allFood) {
                    //add initial snake length to eaten food
                    System.out.printf("You win! Final snake length is %d\n", (eatenFood + 1));
                    return;
                }
            } else if (gameBoard[snakeRow][snakeCol] == 'e') {
                System.out.println("You lose! Killed by an enemy!");
                return;
            }
        }
        if (allFood > eatenFood) {
            int diff = allFood - eatenFood;
            System.out.printf("You lose! There is still %d food to be eaten.", diff);
        }
    }

    private static int[] findStartingPoint(char[][] gameBoard) {
        int[] startingPoint = new int[3];
        int foodCounter = 0;
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                if (gameBoard[i][j] == 's') {
                    startingPoint[0] = i;
                    startingPoint[1] = j;
                }
                if (gameBoard[i][j] == 'f') {
                    foodCounter++;
                }
            }
        }
        startingPoint[2] = foodCounter;
        return startingPoint;
    }

    private static char[][] readGameBoardChars(BufferedReader br, int screenSize) throws IOException {
        char[][] gameBoard = new char[screenSize][screenSize];
        for (int i = 0; i < screenSize; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < screenSize; j++) {
                gameBoard[i][j] = input[j].charAt(0);
            }
        }
        return gameBoard;
    }
}
