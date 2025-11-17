package ObjectsClassesAndCollections_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class BasicStackOperations_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[]arrCommands = readArr(br);
        int n = arrCommands[0];
        int elementsToPop = arrCommands[1];
        int searchElement = arrCommands[2];

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        fillStack(n,br, stack);
        popElementsFromStack(stack,elementsToPop);
        boolean searchFound = checkStack(stack, searchElement);
        if (searchFound) {
            printTrue();
        }else {
           int smallestNumber = searchSmallestElement(stack);
           printOutput(smallestNumber);
        }

    }

    private static void printOutput(int smallestNumber) {
        System.out.println(smallestNumber);
    }

    private static int searchSmallestElement(ArrayDeque<Integer> stack) {
      if(stack.isEmpty()){
          return 0;
      }
      int minNumber = Integer.MAX_VALUE;
      for(int num : stack){
          if(num < minNumber){
          minNumber = num;
          }
      }
      return minNumber;
    }

    private static void printTrue() {
        System.out.println("true");
    }

    private static boolean checkStack(ArrayDeque<Integer> stack, int searchElement) {
        if (stack.contains(searchElement)){
            return true;
        }
        return false;
    }

    private static void popElementsFromStack(ArrayDeque<Integer> stack, int elementsToPop) {
        for(int i = 0; i < elementsToPop && !stack.isEmpty(); i++) {
                stack.pop();
        }
    }

    private static void fillStack(int n, BufferedReader br, ArrayDeque<Integer> stack) throws IOException {
        int[] elements = readArr(br);
        for (int i = 0; i < n; i++) {
            stack.push(elements[i]);
        }
    }

    private static int[] readArr(BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
