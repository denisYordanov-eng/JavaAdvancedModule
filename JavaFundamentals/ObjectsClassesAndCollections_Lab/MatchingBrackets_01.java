package ObjectsClassesAndCollections_Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class MatchingBrackets_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = readArithmeticalExpression(br);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        findExpressions(stack, input);
    }

    private static void findExpressions(ArrayDeque<Integer> stack, String input) {
        //make a for loop to length of input
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i); // make a current char of input
            if(currentChar =='('){// if current char == '(' push current index to stack
                stack.push(i);
            }else if(currentChar == ')'){//else if current char == ')' get the last index of '('
            String contents = input.substring(stack.pop(),i+1); // make a string using the first index of '('
                // and then remove the index of stack
                // and current index + 1 to include')'
            printOutputContents(contents); //print the expression
            }
        }
    }

    private static void printOutputContents(String contents) {
        System.out.println(contents);
    }

    private static String readArithmeticalExpression(BufferedReader  br) throws IOException {
      return br.readLine();

    }
}
