package StringProcessing_Exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MagicExchangeableWords_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //read input
        String wordOne = scanner.next();
        String wordTwo = scanner.next();
        scanner.nextLine();
        // make a boolean flag and call a method
        boolean flag = checkExchangeable(wordOne, wordTwo);
        //print the flag
        System.out.println(flag);

    }

    private static boolean checkExchangeable(String wordOne, String wordTwo) {
        //make a map for wordOne and wordTwo
        Map<Character, Character> mapOne = new HashMap<Character, Character>();
        Map<Character, Character> mapTwo = new HashMap<Character, Character>();
        //take min length of the two Strings
        int minLength = Math.min(wordOne.length(), wordTwo.length());

        //make a for loop from zero to min length
        for (int i = 0; i < minLength; i++) {
            //initialize current char of wordOne and worTwo
            char c1 = wordOne.charAt(i);
            char c2 = wordTwo.charAt(i);
            //check if mapOne contains current char of wordOne
            if (mapOne.containsKey(c1)) {
                //check if current char of wordOne and current char of wordTwo are not equal return false
                if (mapOne.get(c1) != c2) {
                    return false;
                }
                //else if mapOne does not contain c1 and c2 put them in mapOne
            } else {
                mapOne.put(c1, c2);
            }
            //check if mapTwo contains wordTwo currentChar
            if (mapTwo.containsKey(c2)) {
                //check if current char of wordOne and current char of wordTwo are not equal return false
                if (mapTwo.get(c2) != c1) {
                    return false;
                }
                //else if mapTwo does not contain a current char of wordOne and current char of WordTwo
                // put them in mapTwo
            } else {
                mapTwo.put(c2, c1);
            }
        }
        //check if wordOne length are equal of wordTwo
        if (wordOne.length() != wordTwo.length()) {
            // check if wordWord is longer
            if (wordOne.length() > wordTwo.length()) {
                //if it's longer make a for loop from minLength to wordOne length
                for (int i = minLength; i < wordOne.length(); i++) {
                    //check if mapOne does not contain current char of wordOne
                    // and return false when MapOne doesn't have the current char
                    if (!mapOne.containsKey(wordOne.charAt(i))) {
                        return false;
                    }
                }
            } else {
                //make a for loop from minLength to length of wordTwo
                for (int i = minLength; i < wordTwo.length(); i++) {
                    //check if mapTwo contains current char of wordTwo
                    //if it does not contain return false
                    if (!mapTwo.containsKey(wordTwo.charAt(i))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
