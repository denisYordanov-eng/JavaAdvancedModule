package Abstraction_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class ReverseNumbersWithAStack_07 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> stack =  fillStack(br);
        printOutput(stack);
    }

    private static void printOutput(ArrayDeque<Integer> stack) {
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }

    private static ArrayDeque<Integer> fillStack(BufferedReader br) throws IOException {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
         Arrays.stream(br.readLine().split("\\s+"))
                 .mapToInt(Integer::parseInt)
                 .forEach(e -> stack.push(e));
         return stack;
    }
}
