package Abstraction_Lab;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class EncryptSortAndPrintArray_02 {
    public static void main(String[] args) {
    
        String[] names = readInput();
       
        int[] sumCharsName = calculateEachNameSum(names);
        
        printOutput(sumCharsName);
        
    }

    private static void printOutput(int[] sumCharsName) {
        for (int sum : sumCharsName) {
            System.out.println(sum);
        }
    }

    private static int[] calculateEachNameSum(String[] names) {
        int[] sumNamesCh = new int[names.length];
        Set<Character> vowels = new HashSet<>(Arrays.asList(
                'a', 'e', 'i', 'o', 'u',
                'A', 'E', 'I', 'O', 'U')
        );
        for (int i = 0; i < names.length; i++) {
            String currentName = names[i];
            int sum = 0;
            for (int j = 0; j < currentName.length(); j++) {
                char currentChar = currentName.charAt(j);
                if(vowels.contains(currentChar)){
                    sum += currentChar * currentName.length();
                }else {
                    sum += currentChar / currentName.length();
                }
                sumNamesCh[i] = sum;
            }
        }
        Arrays.sort(sumNamesCh);
        return sumNamesCh;
    }
    
    private static String[] readInput() {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] names = new String[n];
        
        for (int i = 0; i < n; i++) {
           names[i]  = scanner.nextLine();
        }
        return names;
    }
}
