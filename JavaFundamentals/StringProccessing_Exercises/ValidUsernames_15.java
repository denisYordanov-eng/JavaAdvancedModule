package StringProcessing_Exercises;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsernames_15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //read input
        String inputLine = scanner.nextLine();
        //split input line in usernames using regex
        String[] usernames = inputLine.split("[\\s\\\\/()]+");

        //make a pattern
        Pattern pattern = Pattern.compile("^[A-Za-z][A-Za-z0-9_]{2,24}$");
        //initialize an arrayList for valid usernames
        ArrayList<String> validUsernames = new ArrayList<>();
        //make a foreach loop in usernames
        for (String username : usernames) {
            //make a matcher
            Matcher matcher = pattern.matcher(username);
            //check if there is a match add the username in validUsernames
            if (matcher.find()) {
                validUsernames.add(username);
            }
        }
        //check if the list of valid usernames is smaller than 2.if it's true return the program
        if (validUsernames.size() < 2) {
            return;
        }
        //initialize best sum
        int bestSum  = 0;

        //initialize best index
        int bestIndex = 0;

        //make a for loop in valid usernames -1
        for (int i = 0; i < validUsernames.size() - 1; i++) {
            //check the length of the current username and length of the next username
              int  sum = validUsernames.get(i).length() + validUsernames.get(i+1).length();

              //if sum  is bigger the best sum
                if (sum > bestSum) {
                    //make best sum equals to the  current sum
                    bestSum = sum;
                    //make best index equals to i
                    bestIndex = i;
                }
        }
        //print the valid username in best index
        //print the valid username in the best index + 1
        System.out.println(validUsernames.get(bestIndex));
        System.out.println(validUsernames.get(bestIndex + 1));
    }
}
