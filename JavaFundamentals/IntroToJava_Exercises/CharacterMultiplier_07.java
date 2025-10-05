package InroToJava_Exercise;

import java.util.Scanner;

public class CharacterMultiplier_07 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.next("\\w+");
        String secondName = scanner.next("\\w+");

       int shortestStr = Math.min(firstName.length(),secondName.length());

       long sum = 0;
       //multiply chars
        for (int i = 0; i < shortestStr ; i++) {
           char firstChar = firstName.charAt(i);
           char secondChar = secondName.charAt(i);
            sum += ((long) firstChar * secondChar);
        }

        //find longer String
        String longer = "";
        String shorter = "";
        if(firstName.length()<secondName.length()){
            longer = secondName;
            shorter = firstName;
        }else {
            longer = firstName;
            shorter = secondName;
        }
        //add chars from longer String to  sum
        for (int j = shorter.length(); j < longer.length(); j++) {
                char currentCh =  longer.charAt(j);
                sum += ((long) currentCh);
        }
        // print the result
        System.out.println(sum);
    }
}
