package ObjectsClassesAndCollections_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class MaximumElement_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        readCommandsAndManipulateStack(stack, br);
    }

    private static void readCommandsAndManipulateStack(ArrayDeque<Integer> stack, BufferedReader br) throws IOException {
        int n = readNumber(br);
        for (int i = 0; i < n; i++) {
            String[] command = br.readLine().split("\\s+");
            switch (command[0]) {
                case "1":
                    int number = Integer.parseInt(command[1]);
                    stack.push(number);
                    break;
                case "2":
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                    break;
                case "3":
                  int maxElement = findMaxElementInStack(stack);
                  printMaxElement(maxElement);
                    break;
            }
        }
    }

    private static void printMaxElement(int maxElement) {
        System.out.println(maxElement);
    }

    private static int findMaxElementInStack(ArrayDeque<Integer> stack) {
        if (stack.isEmpty()){
            return 0;
        }
        int max = Integer.MIN_VALUE;
      for (int currentNumber: stack) {
          if (currentNumber > max) {
              max = currentNumber;
          }
      }
      return max;
    }

    private static int readNumber(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }
}
