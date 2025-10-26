package StringProcessing_Lab;

import java.util.Scanner;


public class ParseTags_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String startTag = "<upcase>";
        String closedTag = "</upcase>";

        while (input.contains(startTag)) {
            int startIndex = input.indexOf(startTag);
            int endIndex = input.indexOf(closedTag);

            String strToReplace = input.substring(startIndex + startTag.length(), endIndex);
            String  replacement =  strToReplace.toUpperCase();
            input = input.replaceFirst(strToReplace, replacement);
            input = input.replaceFirst(startTag,"");
            input = input.replaceFirst(closedTag,"");
        }

        System.out.println(input);
    }
}
