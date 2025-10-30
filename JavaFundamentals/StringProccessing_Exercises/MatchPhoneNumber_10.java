package StringProcessing_Exercises;

import java.util.Scanner;
import java.util.regex.Pattern;

public class MatchPhoneNumber_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pattern = "^\\+359([ -])2\\1\\d{3}\\1\\d{4}$";
        String phoneNumber = scanner.nextLine();
        while (!phoneNumber.equals("end")){
            if(Pattern.matches(pattern, phoneNumber)){
                System.out.println(phoneNumber);
            }

            phoneNumber = scanner.nextLine();
        }
    }
}
