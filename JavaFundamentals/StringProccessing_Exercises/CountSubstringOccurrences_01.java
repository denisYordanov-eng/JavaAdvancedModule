package StringProcessing_Exercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountSubstringOccurrences_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //read text input
        String text = scanner.nextLine().toLowerCase();

        //read wanted word
        String wantedWord = scanner.nextLine().toLowerCase();

        //initialize a start index
        int index = text.indexOf(wantedWord);

        //initialize a count
        int count = 0;

        //make a while loop and check if index == -1 so there is no match
        while (index != -1) {
            //increment count
            count++;
            //update index to the form wanted word to from next letter
            index = text.indexOf(wantedWord, index + 1);
        }
        //print count
        System.out.println(count);
    }
}

