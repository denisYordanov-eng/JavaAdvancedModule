package StringProcessing_Exercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractHyperlinks_16 {
    public static void main(String[] args) {
        
        String input = readOutput();

        Pattern pattern = Pattern.compile("<a\\s+[^>]*?href\\s*=\\s*(?:\"([^\"]*)\"|'([^']*)'|([^\\s>]+))[^>]*>",
                Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            String href = matcher.group(1);
            if(href == null){
                href = matcher.group(2);
            }
            if(href == null){
                href = matcher.group(3);
            }
            System.out.println(href);
        }
    }

    private static String readOutput() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String inputLine = scanner.nextLine();
        while (!inputLine.equals("END")) {
            sb.append(inputLine);

            inputLine = scanner.nextLine();
        }
        return sb.toString();
    }
}
