package IntroToJava;

import java.util.Scanner;

public class ModifyABit_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int p = scanner.nextInt();
        int v = scanner.nextInt();

        if (v == 1){
            int mask = 1 << p;
            int result = n | mask;
            System.out.println(result);
        } else if (v == 0) {
            int mask = ~(1 << p);
            int result = n & mask;
            System.out.println(result);
        }
    }
}
