package StringProcessing_Lab;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsernames_07 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String regex = "^(?=.{3,16}$)(?!.*[-_]{2})[A-Za-z0-9](?:[A-Za-z0-9]|[-_](?=[A-Za-z0-9]))*[A-Za-z0-9]$";
        Pattern pattern = Pattern.compile(regex);
        String inputLine =  scanner.nextLine().replaceAll("\\r\\n","").trim();
        while (!inputLine.equals("END")){
        Matcher matcher = pattern.matcher(inputLine);
        if (matcher.matches()){
            System.out.println("valid");
        }else {
            System.out.println("invalid");
        }
            inputLine =  scanner.nextLine().replaceAll("\\r\\n","").trim();
        }
    }
}
