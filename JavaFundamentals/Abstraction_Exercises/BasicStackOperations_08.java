package Abstraction_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class BasicStackOperations_08 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = fillArray(br);

        int numberOfElementsPushToStack = arr[0];
        int numberOfElementsPopFromStack = arr[1];
        int targetNumber = arr[2];

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] numbers = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < numberOfElementsPushToStack; i++) {
            int currentNumber = numbers[i];
            stack.push(currentNumber);
        }

        for (int i = 0; i < numberOfElementsPopFromStack && !stack.isEmpty(); i++) {
            stack.pop();
        }

        if (stack.contains(targetNumber)) {
            System.out.println("true");
        }else {
            if(!stack.isEmpty()) {
                int minNumber = findSmallestNumberInStack(stack);
                System.out.println(minNumber);
            }
            else  {
                System.out.println(0);
            }
        }
    }

    private static int findSmallestNumberInStack(ArrayDeque<Integer> stack) {
        int smallestNumber = Integer.MAX_VALUE;
        for (int currentNumber: stack) {
           if (currentNumber < smallestNumber) {
               smallestNumber = currentNumber;
           }
        }
        return smallestNumber;
    }

    private static int[] fillArray(BufferedReader br) throws IOException {
        return  Arrays.stream(br.readLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
