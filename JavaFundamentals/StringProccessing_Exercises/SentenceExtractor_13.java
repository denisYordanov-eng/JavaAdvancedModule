package StringProcessing_Exercises;

import java.util.Scanner;
import java.util.regex.Pattern;

public class SentenceExtractor_13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String keyWord = scanner.nextLine();
        String[] sentence = scanner.nextLine().split("(?<=[.!?])\\s*");

        for (String line : sentence) {
            if (line. matches(".*\\b" + Pattern.quote(keyWord) + "\\b.*"))  {
                System.out.println(line.trim());
            }
        }

    }
}
