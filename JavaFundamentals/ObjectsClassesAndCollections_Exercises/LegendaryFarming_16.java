package ObjectsClassesAndCollections_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class LegendaryFarming_16 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> shardsFragmentsMotes = new HashMap<>();
        shardsFragmentsMotes.put("shards", 0);
        shardsFragmentsMotes.put("fragments", 0);
        shardsFragmentsMotes.put("motes", 0);

        Map<String, Integer> junk = new TreeMap<>();

        String winner = "";

        while (winner.isEmpty()) {
            String[] input = br.readLine().split("\\s+");
            for (int i = 0; i < input.length; i += 2) {
                int quantity = Integer.parseInt(input[i]);
                String key = input[i + 1].toLowerCase();
                if (shardsFragmentsMotes.containsKey(key)) {
                    shardsFragmentsMotes.put(key, shardsFragmentsMotes.getOrDefault(key, 0) + quantity);
                    if (shardsFragmentsMotes.get(key) >= 250) {
                        shardsFragmentsMotes.put(key, shardsFragmentsMotes.get(key) - 250);
                        winner = defineWinner(key);
                        break;
                    }
                } else {
                    junk.put(key, junk.getOrDefault(key, 0) + quantity);
                }
            }
        }
        printOutput(winner, shardsFragmentsMotes, junk);
    }


    private static void printOutput(String winner, Map<String, Integer> shardsFragmentsMotes, Map<String, Integer> junk) {
        System.out.printf("%s obtained!%n", winner);

        shardsFragmentsMotes
                .entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    int cmp = e2.getValue().compareTo(e1.getValue());
                    if (cmp != 0) {
                        return cmp;
                    } else {
                        return e1.getKey().compareTo(e2.getKey());
                    }
                })
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));

        for (Map.Entry<String, Integer> entry : junk.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
    }

    private static String defineWinner(String key) {
        String first = "";
        switch (key) {
            case "fragments":
                first = "Valanyr";
                break;
            case "shards":
                first = "Shadowmourne";
                break;
            case "motes":
                first = "Dragonwrath";
                break;

        }
        return first;
    }
}
