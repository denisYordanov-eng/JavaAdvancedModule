package Abstraction_Lab;

import java.util.Scanner;

public class CalculateTriangleAreaMethod_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //read input
        String[] input = scanner.nextLine().split("\\s+");

        double base = Double.parseDouble(input[0]);
        double height = Double.parseDouble(input[1]);

        double area = calculateAreaOfTriangle(base, height);
        printArea(area);
    }

    private static void printArea(double area) {
        System.out.printf("Area = %.2f", area);
    }

    private static double calculateAreaOfTriangle(double base, double height) {
        return base * height / 2;
    }
}
