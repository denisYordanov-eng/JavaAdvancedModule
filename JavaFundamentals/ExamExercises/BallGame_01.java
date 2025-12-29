package JavaAdvancedExam;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BallGame_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> strengthStack = readInputArrayDeque(br);
        ArrayDeque<Integer> accuracyQueue = readInputQueue(br);

        int goals = 0;

        while (!strengthStack.isEmpty() && !accuracyQueue.isEmpty()) {
            int currentStrength = strengthStack.pop();
            int currentAccuracy = accuracyQueue.poll();

            int currentSum = currentStrength + currentAccuracy;

            if (currentSum == 100) {
                goals++;
            } else if (currentSum > 100) {
                //decrease last element with 10
                currentStrength = currentStrength - 10;
                strengthStack.push(currentStrength);

                //move first element to be last
                accuracyQueue.offer(currentAccuracy);
            } else {
                //currentSum < 100
                if (currentStrength < currentAccuracy) {
                    //remove only currentStrength
                    accuracyQueue.addFirst(currentAccuracy);
                } else if (currentStrength > currentAccuracy) {
                    //remove only  currentAccuracy
                    strengthStack.push(currentStrength);
                } else {
                    // currentStrength == currentAccuracy
                    strengthStack.push(currentSum);
                }
            }
        }

        printOutput(goals, strengthStack, accuracyQueue);
    }

    private static void printOutput(int goals, ArrayDeque<Integer> strengthStack, ArrayDeque<Integer> accuracyQueue) {
        if (goals == 3) {
            System.out.println("Paul scored a hat-trick!");
        } else if (goals == 0) {
            System.out.println("Paul failed to score a single goal.");
        } else if (goals > 3) {
            System.out.println("Paul performed remarkably well!");
        } else if (goals > 0 && goals < 3) {
            System.out.println("Paul failed to make a hat-trick.");
        }

        if (goals > 0) {
            System.out.printf("Goals scored: %d%n", goals);
        }

        if (!strengthStack.isEmpty()) {
            //  String values = strengthStack.toString().replaceAll("[\\[\\]]","");

            String value = strengthStack.stream()
                    .map(e -> e.toString())
                    .collect(Collectors.joining(", "));

            System.out.printf("Strength values left: %s%n", value);
        }

        if (!accuracyQueue.isEmpty()) {

            //String queueValues = accuracyQueue.toString().replaceAll("[\\[\\]]","");

            String outputQueue = accuracyQueue.stream()
                    .map(e -> e.toString())
                    .collect(Collectors.joining(", "));

            System.out.printf("Accuracy values left: %s%n", outputQueue);
        }

    }


    private static ArrayDeque<Integer> readInputQueue(BufferedReader br) throws IOException {
        ArrayDeque<Integer> accuracyQueue = new ArrayDeque<>();
        int[] numbers = Arrays.stream(br.readLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < numbers.length; i++) {
            accuracyQueue.offer(numbers[i]);
        }
        return accuracyQueue;
    }

    private static ArrayDeque<Integer> readInputArrayDeque(BufferedReader br) throws IOException {
        ArrayDeque<Integer> strengthStack = new ArrayDeque<>();
        int[] numbers = Arrays.stream(br.readLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < numbers.length; i++) {
            strengthStack.push(numbers[i]);
        }
        return strengthStack;
    }
}