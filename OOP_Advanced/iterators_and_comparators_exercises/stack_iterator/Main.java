package stack_iterator;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] stackInput = br.readLine().split("[, ]+");
        Integer[] numbers = Arrays.stream(stackInput).skip(1)
                .filter(s -> !s.isEmpty())
                .map(Integer::valueOf).toArray(Integer[]::new);

        StackIter<Integer> stackIter = new StackIter<Integer>(numbers);


        String input = br.readLine();

        while (!input.equalsIgnoreCase("END")) {
            String[] tokens = input.split("[, ]+");
            String command = tokens[0];

            switch (command) {
                case "Push":
                    int number = Integer.parseInt(tokens[1]);
                    stackIter.push(number);
                    break;
                case "Pop":
                    try {
                        stackIter.pop();
                    } catch (NoSuchElementException nsee) {
                        System.out.println(nsee.getMessage());
                        input = br.readLine();
                        continue;
                    }
                    break;

            }
            input = br.readLine();
        }
        if (stackIter != null) {
            for (Integer num : stackIter) {
                System.out.println(num.toString());
            }
            for (Integer number : stackIter) {
                System.out.println(number.toString());
            }
        }
    }
}
