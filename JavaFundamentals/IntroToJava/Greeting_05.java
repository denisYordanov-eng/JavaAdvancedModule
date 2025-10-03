package IntroToJava;

import java.util.Scanner;

public class Greeting_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Read input
        String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();

        //check if any of  the names is empty
        if(firstName.isEmpty()){
            firstName = "*****";
        }
        if (lastName.isEmpty()) {
            lastName = "*****";
        }

        //print output
        System.out.printf("Hello, %s %s!",firstName,lastName);
    }
}
