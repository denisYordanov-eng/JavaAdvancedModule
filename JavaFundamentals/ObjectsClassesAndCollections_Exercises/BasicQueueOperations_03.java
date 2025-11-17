package ObjectsClassesAndCollections_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class BasicQueueOperations_03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int[] commands = readArr(br);
        int numberOfElements = commands[0];
        int numberToRemove = commands[1];
        int searchElement = commands[2];

        fillQueue(br, queue, numberOfElements);

        removeElements(numberToRemove, queue);

        boolean foundNumber = checkForSearchElement(searchElement, queue);
        if (foundNumber) {
            printTrue();
        } else {
            int smallestNumber = findSmallestElement(queue);
            printSmallestElement(smallestNumber);
        }
    }

    private static void printSmallestElement(int smallestNumber) {
        System.out.println(smallestNumber);
    }

    private static int findSmallestElement(ArrayDeque<Integer> queue) {
        if (queue.isEmpty()) {
            return 0;
        }
        int smallestNumber = Integer.MAX_VALUE;
        for (int currentElement : queue) {
            if (currentElement < smallestNumber) {
                smallestNumber = currentElement;
            }
        }
        return smallestNumber;
    }

    private static void printTrue() {
        System.out.println("true");
    }

    private static boolean checkForSearchElement(int searchElement, ArrayDeque<Integer> queue) {
        if (queue.isEmpty()) {
            return false;
        }
        if (queue.contains(searchElement)) {
            return true;
        }
        return false;
    }

    private static void removeElements(int numberToRemove, ArrayDeque<Integer> queue) {
        for (int i = 0; i < numberToRemove && !queue.isEmpty(); i++) {
            queue.poll();
        }
    }

    private static void fillQueue(BufferedReader br, ArrayDeque<Integer> queue, int numberOfElements) throws IOException {
        int[] arrInput = readArr(br);
        for (int i = 0; i < numberOfElements; i++) {
            queue.add(arrInput[i]);
        }
    }

    private static int[] readArr(BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
