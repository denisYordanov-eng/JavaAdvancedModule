package method_overriding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Rectangle> rectangles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = br.readLine().split("\\s+");

            if (tokens.length == 2) {
                double sideA = Double.parseDouble(tokens[0]);
                double sideB = Double.parseDouble(tokens[1]);
                Rectangle rectangle = new Rectangle(sideA, sideB);
                rectangles.add(rectangle);
            } else if (tokens.length == 1) {
                double sideA = Double.parseDouble(tokens[0]);
                Rectangle square = new Square(sideA);
                rectangles.add(square);
            }
        }
        printOutput(rectangles);
    }

    private static void printOutput(List<Rectangle> rectangles) {
        for (Rectangle rectangle : rectangles) {
            System.out.println(rectangle.area());
        }
    }
}
