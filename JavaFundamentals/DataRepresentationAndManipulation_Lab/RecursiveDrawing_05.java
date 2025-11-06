package DataRepresentationAndManipulation_Lab;

import java.util.Scanner;

public class RecursiveDrawing_05 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        //read number from the console
        int n = readNumber(scanner);
        //print symbols
        printSymbols(n);
    }

    private static int readNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private static void printSymbols(int n) {
        // bottom of the recursion (the stop condition)
        if (n == 0) {
            return;
        }
        //make a char variable
        char symbol = '*';
        //print  char symbol n times, this is pre-axion
        System.out.println(createSymbols(n, symbol));

        //recursive call
        printSymbols(n - 1);
        //post-axion change char to '#' and print n times
        symbol = '#';
        System.out.println(createSymbols(n, symbol));
    }

    private static String createSymbols(int n, char symbol) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(symbol);
        }
        return sb.toString();
    }
}

