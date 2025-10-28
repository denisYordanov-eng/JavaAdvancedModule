package StringProcessing_Exercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TextFilter_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // read banned words from the console
        String[] bannedWords = scanner.nextLine().split(",\\s+");

        //read text from the console and replace every new line with ""
        String text = scanner.nextLine();

        // make a foreach loop in bannedWords
        for (String bannedWord : bannedWords) {
            //make the  current bannedWord a regex pattern and make it case-insensitive with (?i)
            Pattern pattern = Pattern.compile("(?i)" + bannedWord);
            // make matcher that match the text with pattern
            Matcher matcher = pattern.matcher(text);
            // while there is a match
            while (matcher.find()) {

                String replacement = replaceTheBannedWord(bannedWord);
                //replace the String with the replacement
                text = text.replaceAll("(?i)" + bannedWord, replacement);
            }
        }
        //print the text
        System.out.println(text);
    }

    private static String replaceTheBannedWord(String bannedWord) {
        StringBuilder newWord = new StringBuilder();
        for (int i = 0; i < bannedWord.length(); i++) {
            newWord.append("*");
        }
        return newWord.toString();
    }
}
