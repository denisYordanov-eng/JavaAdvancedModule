package InroToJava_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class CalculateExpression_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Read input
     double[] input = Arrays.stream(scanner.nextLine()
             .split("\\s+"))
             .mapToDouble(Double::parseDouble)
             .toArray();

     double a = input[0];
     double b = input[1];
     double c = input[2];

        double powA = Math.pow(a,2);
        double powB = Math.pow(b,2);
        double sqrtC = Math.sqrt(c);

     //Calculate f1
       double powStepF1 =(a + b + c) / sqrtC;
       double f1Result =  Math.pow((powA + powB) / (powA - powB), powStepF1);

       //Calculate f2
        double powStepF2 = a - b;
        double powC = Math.pow(c,3);
        double f2Result = Math.pow((powA + powB - powC),  powStepF2);


        //Calculate f3
        double averageOfNumbers = (a + b + c) / 3;
        double averageOfResults = (f1Result + f2Result) / 2;
        double f3Result = Math.abs(averageOfNumbers - averageOfResults);

       //Print final results
        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f",f1Result, f2Result, f3Result);
    }
}
