package ObjectsClassesAndCollections_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;

public class DragonArmy_16 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = readNumber(br);
        Map<String, TreeMap<String, int[]>> dragons = new LinkedHashMap<>();
        fillMap(n, br, dragons);
        calculateAndPrint(dragons);
    }

    private static void calculateAndPrint(Map<String, TreeMap<String, int[]>> dragons) {
        for (Entry<String, TreeMap<String, int[]>> entry : dragons.entrySet()) {
            String type = entry.getKey();
            TreeMap<String, int[]> dragon = entry.getValue();
            double averageDamage = 0;
            double averageHealth = 0;
            double averageArmor = 0;
            for (int[] stats : dragon.values()) {
                averageDamage += stats[0];
                averageHealth += stats[1];
                averageArmor += stats[2];
            }
            int count = dragon.size();
            averageDamage /= count;
            averageHealth /= count;
            averageArmor /= count;

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", type, averageDamage, averageHealth, averageArmor);
            for (Entry<String, int[]> e2 : dragon.entrySet()) {
                String key = e2.getKey();
                int[] stats = e2.getValue();
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", key, stats[0], stats[1], stats[2]);
            }
        }
    }

    private static void fillMap(int n, BufferedReader br, Map<String, TreeMap<String, int[]>> dragons) throws IOException {
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("\\s+");

            String color = input[0];
            String name = input[1];
            int damage = input[2].equals("null") ? 45 : Integer.parseInt(input[2]);
            int health = input[3].equals("null") ? 250 : Integer.parseInt(input[3]);
            int armor = input[4].equals("null") ? 10 : Integer.parseInt(input[4]);

            dragons.putIfAbsent(color, new TreeMap<>());
            dragons.get(color).put(name, new int[]{damage, health, armor});
        }
    }

    private static int readNumber(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }
}
