package StringProcessing_Exercises;

import java.util.Scanner;
import java.util.regex.Pattern;

public class TextFilter_03_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //read bannedWords
        String[] bannedWords = scanner.nextLine().split(",\\s+");

        //read text
        String text = scanner.nextLine();

        //make a foreach loop in bannedWords
        for (String bannedWord : bannedWords) {
            //make a String replacement
            String replacement = replaceWord(bannedWord);
            //make String format using regex to make case-insensitive
            //and Pattern.quote to escape any character in the String
            String regex = String.format("(i?)\\b%s\\b", Pattern.quote(bannedWord));
            //replace all String in text with a replacement
            text = text.replaceAll(regex, replacement);
        }
        //print output
        System.out.println(text);
    }

    private static String replaceWord(String bannedWord) {
        StringBuilder newWord = new StringBuilder();
        for (int i = 0; i < bannedWord.length(); i++) {
            newWord.append("*");
        }
        return newWord.toString();
    }
}
