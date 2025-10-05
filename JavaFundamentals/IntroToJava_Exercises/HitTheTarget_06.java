package InroToJava_Exercise;

import java.util.Scanner;

public class HitTheTarget_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //read input
        int num = Integer.parseInt(scanner.nextLine());

        //added
        for (int num1 = 1; num1 <= 20 ; num1++) {
            for (int num2 = 1 ; num2 <= 20 ; num2++) {
                if(num1 + num2 == num){
                    System.out.printf("%d + %d = %d\n",num1,num2,num);
                }
            }
        }
        //subtract
        for (int numA = 1; numA <= 20; numA++) {
            for (int numB = 1; numB <= 20; numB++) {
                if(numA - numB == num){
                    System.out.printf("%d - %d = %d\n",numA,numB,num);
                }
            }
        }
    }
}
