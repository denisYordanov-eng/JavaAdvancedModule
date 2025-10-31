package StringProcessing_Exercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceATag_11 {
    public static void main(String[] args) {
        String input = readInput();
        // make a pattern
        Pattern pattern = Pattern.compile("(?s)<a\\s+href\\s*=\\s*(\".*?\")\\s*>(.*?)</a>");
        Matcher matcher = pattern.matcher(input);
        //replace all matches with the replacement regex
        String output = matcher.replaceAll("[URL href=$1]$2[/URL]");

        System.out.println(output);

    }

    private static String readInput() {
        Scanner scanner = new Scanner(System.in);
        // made a string builder
        StringBuilder sb = new StringBuilder();

        //read first input line
        String inputLine = scanner.nextLine();

        //make while loop if input line equals "END" break the loop
        while (!inputLine.equals("END")) {
            //string builder append the line  and append the new line
            sb.append(inputLine).append("\n");

            //read input line from the console
            inputLine = scanner.nextLine();
        }
        return sb.toString();
    }
}
