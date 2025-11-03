package StringProcessing_Exercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MelrahShake_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String textLine = scanner.nextLine();
        String keyWord = scanner.nextLine();

        while (true){
            int firstIndex = textLine.indexOf(keyWord);
            int lastIndex = textLine.lastIndexOf(keyWord);

            if (firstIndex != -1 && lastIndex != -1 && firstIndex != lastIndex && !keyWord.isEmpty()){
            StringBuilder sb  = new StringBuilder(textLine);

            sb.delete(lastIndex, lastIndex + keyWord.length());
            sb.delete(firstIndex, firstIndex + keyWord.length());

                textLine = sb.toString();
                System.out.println("Shaked it.");

                int middleIndex = keyWord.length()/2;
                keyWord = keyWord.substring(0, middleIndex) + keyWord.substring(middleIndex + 1);
            }else {
                System.out.println("No shake.");
                System.out.println(textLine);
                break;
            }
        }
    }
}
