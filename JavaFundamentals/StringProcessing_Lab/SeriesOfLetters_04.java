package StringProcessing_Lab;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeriesOfLetters_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //read input String
        String input = scanner.nextLine();
        //initialize a regex pattern - capture one letter or one digit or white space or symbol
        // "\\1*"-> if the next symbol is the same as previous ignore it.
        String pattern = "(.)\\1*";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);

        //make a String builder sb
        StringBuilder sb = new StringBuilder();

        while (m.find()){
           sb.append( m.group(1));
        }
        System.out.println(sb.toString());
    }
}
