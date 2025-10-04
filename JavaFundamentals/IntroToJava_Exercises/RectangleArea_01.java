package InroToJava_Exercise;


import java.util.Scanner;

public class RectangleArea_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            //Read Output
        double sideA = scanner.nextDouble();
        double sideB = scanner.nextDouble();

        //Calc Area
        double area = sideA * sideB;

        //Print Area
        System.out.printf("%.2f", area);
    }
}
