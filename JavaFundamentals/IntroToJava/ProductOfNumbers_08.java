package IntroToJava;

import java.math.BigInteger;
import java.util.Scanner;

public class ProductOfNumbers_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = Integer.parseInt(scanner.next());
        int stop = Integer.parseInt(scanner.next());

        int  printStart = start;
        BigInteger product =  BigInteger.ONE;
        do {
            BigInteger number = new BigInteger("" + start);
            product = product.multiply(number);
            start++;
        }
        while (start <= stop);

        System.out.printf("product[%d..%d] = %d",printStart, stop, product);
    }
}
