package IntroToJava;

import java.util.Scanner;

public class AverageOfThreeNumbers_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //read input
        double firstNum = scanner.nextDouble();
        double secondNum = scanner.nextDouble();
        double thirdNum = scanner.nextDouble();

        //calc sum
        double sum = (firstNum + secondNum + thirdNum) ;
        //calc average
        double average = sum / 3.0;

        //print output
        System.out.printf("%.2f", average);
    }
}
