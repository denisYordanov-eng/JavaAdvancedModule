package Abstraction_Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Plus_Remove_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Make a list of original chars
        List<char[]> originalChars = new ArrayList<>();
        //Make a list of chars to upper
        List<char[]> copyChars = new ArrayList<>();

        while (true) {
            //Read input
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("END")){
                break;
            }
            //Add input in the original list of chars
            originalChars.add(input.toCharArray());
            //Add input in the copy list of chars but set current input to uppercase
            copyChars.add(input.toUpperCase().toCharArray());
        }

        manipulateStrings(originalChars,copyChars);
        printOriginalMatrix(originalChars);
    }

    private static void printOriginalMatrix(List<char[]> originalChars) {
        //In for loop we print the original chars but make sure that chars that we made empty will not be printed
        for (int i = 0; i < originalChars.size(); i++) {
            System.out.println(Arrays.toString(originalChars.get(i)).replaceAll("[\\[\\], \0]", ""));
        }
    }

    private static void manipulateStrings(List<char[]> originalChars, List<char[]> copyChars) {
        for (int i = 0; i < originalChars.size() - 2; i++) {
            for(int j = 0; j < originalChars.get(i).length; j++){
                try {
                    //Get chars in try catch because the length of every (i) row is not equal
                    char a = copyChars.get(i)[j];
                    char b = copyChars.get(i + 1)[j - 1];
                    char c = copyChars.get(i + 1)[j];
                    char d = copyChars.get(i + 1)[j + 1];
                    char e = copyChars.get(i + 2)[j];
                    //Check if every char we get is  equal
                    //If true we set original chars to be empty
                    if(a == b && b == c && c == d && d == e){
                        originalChars.get(i)[j] = '\0';
                        originalChars.get(i + 1)[j - 1] = '\0';
                        originalChars.get(i + 1)[j] = '\0';
                        originalChars.get(i + 1)[j + 1] = '\0';
                        originalChars.get(i + 2)[j] = '\0';
                    }
                }catch (IndexOutOfBoundsException e){}
            }
        }
    }
}
