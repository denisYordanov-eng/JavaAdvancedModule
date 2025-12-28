import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LifoFifoIntegrator {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(br.readLine().split("\\s+"))
                .map(Integer::valueOf)
                .forEach(num -> stack.push(num));

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        Arrays.stream(br.readLine().split("\\s+"))
                .map(Integer::valueOf)
                .forEach(n -> queue.offer(n));

        Set<Integer> evenSums = new HashSet<>();

        int totalSum = 0;
        while (!queue.isEmpty() && !stack.isEmpty()) {
            int firstElementQueue = queue.poll();
            int lastElementStack = stack.pop();

            int currentSum = firstElementQueue + lastElementStack;
            totalSum += currentSum;
            if (currentSum % 2 != 0) {  //odd numbers
                stack.push(lastElementStack);
            } else {
                //add evenSums
                evenSums.add(currentSum);
            }
        }

        printOutput(totalSum, evenSums);

    }

    private static void printOutput(int totalSum, Set<Integer> evenSums) {
        System.out.printf("sum is %d%n", totalSum);

        evenSums.stream().sorted((a, b) -> Integer.compare(a, b))
                .forEach(evenSum -> {
                    System.out.print(evenSum + " ");
                });
    }
}
