package StringProcessing_Exercises;

import java.util.Scanner;

import java.util.Set;
import java.util.TreeSet;

public class Palindromes_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //read input words
        String[] input = scanner.nextLine().split("[\\s,.?!]+");

        //initialize a tree set
        Set<String> palindromes = new TreeSet<String>();

        for (String word : input) {
            checkIfWordIsPalindrome(word);
            if (checkIfWordIsPalindrome(word)) {
                palindromes.add(word);
            }
        }
        System.out.println(palindromes);
    }

    private static boolean checkIfWordIsPalindrome(String word) {
        StringBuilder wordToCheck = new StringBuilder();
        wordToCheck.append(word);
        wordToCheck.reverse();

        if (wordToCheck.toString().equals(word)) {
            return true;
        }

        return false;
    }
}
