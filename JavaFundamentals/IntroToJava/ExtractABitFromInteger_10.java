package IntroToJava;

import java.util.Scanner;

public class ExtractABitFromInteger_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n =  scanner.nextInt();
        int p =  scanner.nextInt();

        int mask = n >> p;
        int bit  = mask & 1;

        System.out.println(bit);

    }
}
