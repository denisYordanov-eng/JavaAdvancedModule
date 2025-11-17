package ObjectsClassesAndCollections_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BalancedParentheses_05 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Character> stack = new ArrayDeque<>();
        fillDeque(stack, br);
        boolean balanced = checkIsBalanced(stack);
        if (balanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean checkIsBalanced(ArrayDeque<Character> stack) {
        boolean balanced = true;
       for(char ch : stack) {
           if(ch == '{' || ch == '[' || ch == '(') {
               stack.push(ch);
           }else {
               if(stack.isEmpty()) {
                   balanced = false;
               }
                   char open = stack.pop();
                   if(!matches(open,ch)){
                       balanced = false;
                   }
           }
       }
       return balanced;
    }

    private static boolean matches(char open, char closed) {
        return (open =='(' && closed ==')' )||
                (open == '[' && closed ==']') ||
                (open == '{' && closed =='}');
    }


    private static void fillDeque(ArrayDeque<Character> stack, BufferedReader br) throws IOException {
        String inputLine = br.readLine().trim();
        for (int i = 0; i < inputLine.length(); i++) {
            char currentChar = inputLine.charAt(i);
            stack.add(currentChar);
        }

    }
}
