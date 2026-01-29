package encapsulation_exercise.class_box;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //the length, width and height

        double length = readDouble(reader);
        double width = readDouble(reader);
        double height = readDouble(reader);

        Box box = new Box(length, width, height);

        printOutput(box);
    }

    private static void printOutput(Box box) {
        System.out.printf("Surface Area - %.2f%n", box.calculateSurfaceArea());
        System.out.printf("Lateral Surface Area - %.2f%n", box.calculateLateralSurfaceArea());
        System.out.printf("Volume - %.2f", box.calculateVolumeArea());
    }

    private static double readDouble(BufferedReader reader) throws IOException {
        return Double.parseDouble(reader.readLine());
    }
}
