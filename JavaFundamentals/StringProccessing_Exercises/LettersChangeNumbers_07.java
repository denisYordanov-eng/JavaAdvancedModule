package StringProcessing_Exercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LettersChangeNumbers_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //read input
        String[] input = scanner.nextLine().split("\\s+");
        //make a pattern
        String pattern = "([A-Za-z])([0-9]+)([A-Za-z])";

        //initialize sum
        double sum = 0;
        //make a foreach loop
        for (String currentString : input) {
            // make a pattern and a matcher
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(currentString);
            // make a while loop iterate if there is a match
            while (m.find()) {
                //initialize first letter
                String firstLetter = m.group(1);
                //initialize number
                double number = Double.parseDouble(m.group(2));
                //initialize second letter
                String secondLetter = m.group(3);
                //check if first char is upper device the number  from the position of alphabet of the first char
                // and add it to the sum
                if (Character.isUpperCase(firstLetter.charAt(0))) {
                    int numberOfChar = calculatePositionOfUpperChar(firstLetter.charAt(0));
                    sum += number / numberOfChar;
                    //if first char is lower multiply  number to the position of first char
                    //and add it to the sum
                } else if (Character.isLowerCase(firstLetter.charAt(0))) {
                    int positionOfLowerChar = calculatePositionOfLowerChar(firstLetter.charAt(0));
                    sum += number * positionOfLowerChar;
                }
                // if second char is upper subtract the position of second char in alphabet from the sum
                if (Character.isUpperCase(secondLetter.charAt(0))) {
                    int positionOfUpperChar = calculatePositionOfUpperChar(secondLetter.charAt(0));
                    sum -= positionOfUpperChar;
                    //if second char is lower add the position of second char in alphabet from the sum
                } else if (Character.isLowerCase(secondLetter.charAt(0))) {
                    int positionOfCharacter = calculatePositionOfLowerChar(secondLetter.charAt(0));
                    sum += positionOfCharacter;
                }
            }
        }
        printSum(sum);
    }

    private static void printSum(double sum) {
        System.out.printf("%.2f%n", sum);
    }

    private static int calculatePositionOfLowerChar(char c) {
        return (int) c - (int) 'a' + 1;
    }

    private static int calculatePositionOfUpperChar(char c) {
        return (int) c - 'A' + 1;
    }
}
