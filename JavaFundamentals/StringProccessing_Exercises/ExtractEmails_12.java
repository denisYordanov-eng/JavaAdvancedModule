package StringProcessing_Exercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //read input
        String input = scanner.nextLine();
        //make a pattern
        Pattern pattern = Pattern.compile("(?<=\\s|^)([A-Za-z0-9]+[A-Za-z0-9._-]*[A-Za-z0-9])@([A-Za-z]+(?:-[A-Za-z]+)*(?:\\.[A-Za-z]+(?:-[A-Za-z]+)*)+)(?=[.,\\s]|$)");
        //make a while loop if input equal end break the loop
        while (!input.equals("end")) {
            //make a matcher
            Matcher matcher = pattern.matcher(input);
            //make while loop and check if matcher find a match or more of one match print the match
            while (matcher.find()) {
                System.out.println(matcher.group());
            }
            //read new input line from the scanner
            input = scanner.nextLine();
        }
    }
}
