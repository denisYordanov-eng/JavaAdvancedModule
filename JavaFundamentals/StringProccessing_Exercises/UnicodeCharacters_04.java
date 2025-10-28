package StringProcessing_Exercises;

import java.util.Scanner;

public class UnicodeCharacters_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //read the text from the console
        String text = scanner.nextLine();
        //initialize a StringBuilder
        StringBuilder sb = new StringBuilder();
        // make for loop  to text length
        for (int i = 0; i < text.length(); i++) {
            //take the current char
            char currentChar = text.charAt(i);
            // call a method that convert the current char in a uni code
            String convertedStr = convertStringToUnicode(currentChar);
            //append the converted uni code String in String builder
            sb.append(convertedStr);
        }
        //print the output
        System.out.println(sb.toString());
    }

    private static String convertStringToUnicode(char currentChar) {
        //take the current char and  format it using  String format method
        // a  pattern for uni code that I found in internet
        // and character cast to integer
        return String.format("\\u%04x", (int) currentChar);
    }
}
