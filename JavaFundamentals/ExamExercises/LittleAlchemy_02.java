package JavaAdvancedExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class LittleAlchemy_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> queue = readQueue(br);
        ArrayDeque<Integer> stackGold = new ArrayDeque<>();

        String input = br.readLine();
        while (!input.equalsIgnoreCase("Revision")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            int number = Integer.parseInt(tokens[2]);

            if (command.equalsIgnoreCase("Apply")) {
                for (int i = 0; i < number && !queue.isEmpty(); i++) {
                    int currentNumber = queue.poll();
                    if (currentNumber > 1) {
                        currentNumber--;
                        queue.offer(currentNumber);
                    } else {
                        stackGold.push(currentNumber);
                    }
                }
            } else if (command.equalsIgnoreCase("Air")) {
                if (!stackGold.isEmpty()) {
                    stackGold.pop();
                    queue.offer(number);
                }
            }
            input = br.readLine();
        }

        printOutput(queue, stackGold);
    }

    private static void printOutput(ArrayDeque<Integer> queue, ArrayDeque<Integer> stackGold) {
        StringBuilder sb = new StringBuilder();
        queue.stream()
                .map(n -> n.toString())
                .forEach(n -> sb.append(n).append(" "));

        System.out.println(sb.toString());
        if (!stackGold.isEmpty()) {
            System.out.println(stackGold.size());
        }else  {
            System.out.println("0");
        }
    }

    private static ArrayDeque<Integer> readQueue(BufferedReader br) throws IOException {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        Arrays.stream(br.readLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(n -> queue.offer(n));
        return queue;
    }
}
