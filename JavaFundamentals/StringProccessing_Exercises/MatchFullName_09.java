package StringProcessing_Exercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchFullName_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Make a pattern
        String pattern = "^[A-Z][a-z]+ [A-Z][a-z]+$";

        //read the first line
        String text = scanner.nextLine();

        //make a pattern compile
        Pattern p = Pattern.compile(pattern);
        //make a while loop  if text equals "end" break it

        while (!text.equals("end")) {
            //check if pattern matches the text
            //and if it's a match print it
            if (Pattern.matches(pattern, text)) {
                System.out.println(text);
            }
            //read another line from the console
            text = scanner.nextLine();
        }
    }
}
