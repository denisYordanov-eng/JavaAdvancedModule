package InroToJava_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class TriangleArea_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //ReadInput
        int[] pointsA = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int ax = pointsA[0];
        int ay = pointsA[1];

        int[] pointsB = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int bx = pointsB[0];
        int by = pointsB[1];

        int[] pointsC = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int cx = pointsC[0];
        int cy = pointsC[1];

        //Calc formula
        int result = Math.abs(ax * (by - cy) + bx *(cy - ay) + cx *(ay - by)) / 2;
        //Print result
        System.out.println(result);
    }
}
