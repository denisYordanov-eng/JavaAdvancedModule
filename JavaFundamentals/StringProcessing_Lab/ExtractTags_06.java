package StringProcessing_Lab;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractTags_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regexPattern = "(<.+?>)(\\w*)";

        StringBuilder sb = new StringBuilder();

        //read first input line
        String inputLine = scanner.nextLine();

        //if inputLine.equals("END") -> break;
        while (!inputLine.endsWith("END")) {
            Pattern pattern = Pattern.compile(regexPattern);
            Matcher matcher = pattern.matcher(inputLine);
            //check in a while loop if it has a match
            //while loop -> checks one or more matches
            //if statement -> checks only one match
            while (matcher.find()) {
                //append first group match in to sb
                sb.append(matcher.group(1)).append("\n");
            }
            //read new string from the console
            inputLine = scanner.nextLine();
        }
        //print output
        System.out.println(sb);
    }
}
