package JavaAdvancedExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Shockwave_01 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int[] inputArr = readInputArr(input);
        int rows = inputArr[0];
        int cols = inputArr[1];

        String commands = br.readLine();

        //initialize multidimensional array and automated is fill with zeros
        int[][] shockwave = new int[rows][cols];

        while (!"Here We Go".equalsIgnoreCase(commands)) {
            int[] numbers = readInputArr(commands);
            int x1 = numbers[0];
            int y1 = numbers[1];
            int x2 = numbers[2];
            int y2 = numbers[3];

            manipulateShockWave(x1, y1, x2, y2, shockwave);

            commands = br.readLine();
        }
        printShockwaveResult(shockwave);
    }

    private static void printShockwaveResult(int[][] shockwave) {
        for (int i = 0; i < shockwave.length; i++) {
            for (int j = 0; j < shockwave[i].length; j++) {
                System.out.print(shockwave[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void manipulateShockWave(int x1, int y1, int x2, int y2, int[][] shockwave) {
        //manipulate elements from range x1 to x2 and  from y1 to y2
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                shockwave[i][j] += 1;
            }
        }
    }

    private static int[] readInputArr(String input) {
        return Arrays.stream(input
                        .split("\\s+"))
                .mapToInt(Integer::valueOf).toArray();
    }
}
