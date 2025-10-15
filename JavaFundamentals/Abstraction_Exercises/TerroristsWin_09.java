package Abstraction_Exercises;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TerroristsWin_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder(scanner.nextLine());

        while (sb.indexOf("|") != -1) {
            //take index of  first pipe
            int start = sb.indexOf("|");
             // take index of last pipe
            int end = sb.indexOf("|", start + 1);

            //initialize new string to take chars between pipes
            String bombChars = sb.substring(start + 1, end);

             //calculate sum  of chars
            int sum = calculateCharsSum(bombChars);

            //take the last digit of number
            int power = sum % 10;
            //make a startIndex.We take the biggest number
            // if start - power is < 0 then we take 0 index, else we take star - power index
            int left = Math.max(0, start - power);
            // we take  smaller number if  end + power >  sb. length - 1 we take sb length,
            // else we take edn + power index
            int right = Math.min(sb.length() - 1, end + power);

            //replace every char from start index to end  with '.'
            for (int i = left; i <= right; i++) {
                sb.setCharAt(i,'.');
            }
        }
        //print result sb
        System.out.println(sb);
    }
    private static int calculateCharsSum(String bombChars) {
        int sum = 0;
        for (char currentCh : bombChars.toCharArray()) {
            sum += currentCh;
        }
        return sum;
    }
}
