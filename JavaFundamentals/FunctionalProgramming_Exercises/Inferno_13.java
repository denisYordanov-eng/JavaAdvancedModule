package FunctionalProgramming_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class Inferno_13 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = readNumbers(br);

        HashMap<String, Predicate<Integer>> commands = new HashMap<>();

        String commandLine = br.readLine();
        while (!commandLine.equals("Forge")) {
            String[] parts = commandLine.split(";");
            Predicate<Integer> predicate = makePredicate(parts, numbers);
            String commandType = parts[0];

            String key = parts[1] + parts[2];
            if(("Exclude").equals(commandType)) {
            commands.put(key, predicate);
            }else {
                commands.remove(key);
            }
            commandLine = br.readLine();
        }
        for (int i = 0; i < numbers.length; i++) {
            boolean forRemove = false;
            for(Map.Entry<String, Predicate<Integer>> entry : commands.entrySet()) {
                if(entry.getValue().test(i)) {
                    forRemove = true;
                    break;
                }
            }
            if(!forRemove){
                System.out.print(numbers[i] + " ");
            }
        }

    }

    private static Predicate<Integer> makePredicate(String[] parts, int[] numbers) {
        String filterType = parts[1];
        int number = Integer.parseInt(parts[2]);
        switch (filterType) {
            case "Sum Left":
                return index -> (index > 0 ? numbers[index  - 1] : 0) + numbers[index] == number;
            case "Sum Right":
                return index -> (index > numbers.length - 1 ? numbers[index + 1] : 0) + numbers[index]  == number;
            default:
                return index ->
                        ((index < numbers.length - 1 ? numbers[index + 1] : 0) +
                                (index > 0 ? numbers[index - 1] : 0))  + numbers[index]  == number;
        }
    }

    private static int[] readNumbers(BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
