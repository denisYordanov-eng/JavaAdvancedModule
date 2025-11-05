package DataRepresentationAndManipulation_Lab;

import java.util.Scanner;

public class RecursiveFactorial_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = readNumber(scanner);
        int result = calculateFactorial(n);
        printResult(result);
    }

    private static void printResult(int result) {
        System.out.println(result);
    }

    private static int calculateFactorial(int n) {
        if(n <= 1){
            return 1;
        }

        return n * (calculateFactorial(n - 1));
    }

    private static int readNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }
}
