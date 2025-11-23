package Functional_Programing_Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class CountUppercaseWords_03 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = readArr(reader);
        ArrayList<String> words = new ArrayList<>();

        Predicate<String> checkForUpperCase = (w) -> Character.isUpperCase(w.charAt(0));
        for (String word : input) {
            if (checkForUpperCase.test(word)) {
                words.add(word);
            }
        }

        printOutput(words);
    }

    private static void printOutput(ArrayList<String> words) {
        System.out.println(words.size());
        for (String word : words) {
            System.out.println(word);
        }
    }

    public static String[] readArr(BufferedReader reader) throws IOException {
        return reader.readLine().split("\\s+");
    }
}
