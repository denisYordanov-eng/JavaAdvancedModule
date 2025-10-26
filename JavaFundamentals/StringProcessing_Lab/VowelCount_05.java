package StringProcessing_Lab;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VowelCount_05 {
    public static void main(String[] args) {
        //solving the task with regex
        Scanner scanner = new Scanner(System.in);
        //read input
        String text = scanner.nextLine();
        //read pattern
        Pattern pattern = Pattern.compile("[aeiouyAEIOUY]");
        Matcher matcher = pattern.matcher(text);
        int count = 0;

        while (matcher.find()) {
            count++;
        }
        System.out.printf("Vowels: %d",count);
    }
}
